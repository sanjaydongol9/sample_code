package com.cubic.ipm.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;

import com.cubic.ipm.enums.Flags;
import com.cubic.ipm.model.Role;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.ipm.dao.UserDaoService;
import com.cubic.ipm.dto.PrivilegeControlDto;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.model.UserControl;
import com.cubic.ipm.service.UserService;
import com.cubic.ipm.util.PasswordUtil;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Autowired
	private UserDaoService userDaoService;
	
	@Override
	public User createUser(User user) {
		if(!user.getPassword().equals(user.getRePassword()))
			throw new IllegalArgumentException("Password does not match with repassword");

		user.setPassword(PasswordUtil.encryptPassword(user.getPassword()));
		user.setCreatedDate(new Date());
		User user1 = new User();
		try{
			user.setFlag(Flags.ACTIVE);
			user1 = userDaoService.save(user);
		}
		catch(Exception e){
			System.out.println("Exception: "+ e.getMessage());

		}
		return user1;
	}

	@Override
	public List<User> getUser() {

		return userDaoService.getUsers();
	}

	@Override
	public void deleteUser(Long id) {
		User user = userDaoService.findUserById(id);
		user.setFlag(Flags.DELETED);
		userDaoService.update(user);
	}

	@Override
	public void updateUser(User user) {
		user.setFlag(Flags.UPDATED);
		userDaoService.update(user);
	}

	@Override
	public Role[] getRole() {
		return Role.values();
	}
	@Override
	public PrivilegeControlDto getVcCandidates() {
		PrivilegeControlDto privilegeControlDto = new PrivilegeControlDto();
		HashMap<User, List<Candidate>> vcCandidates = new HashMap<>();
		List<Candidate> candidates = new ArrayList<>();
		
		/* Get All Candidate First */
		candidates = userDaoService.getCandidates(); 
		List<Candidate> list = new ArrayList<>(); 
		for(Candidate candidate : candidates) {
			
			/* If Vendor Already in Map then add it */
			if(vcCandidates.containsKey(candidate.getVcTaker())){
				User key = candidate.getVcTaker();
				list = vcCandidates.get(key);
				list.add(candidate); 
				vcCandidates.put(key, list);
			} else {
				list = new ArrayList<>(); 
				list.add(candidate);
				vcCandidates.put(candidate.getVcTaker(),list);
			}
			
			//Prevent to Extra Deep Loop
			//FIXME:
			candidate.getVcTaker().setControllableUsers(null);
			//candidate.getVcTaker().setSupervisors(null);
		}
		
		/* Set All Vendors that not associated to any Candidate */
		List<User> vcTakers = userDaoService.getNotAssignedVcTakers();
		for(User user: vcTakers) {
			//FIXME:
			user.setControllableUsers(null);
			//user.setUsers(null);
			vcCandidates.put(user, new ArrayList<Candidate>());
		}
		
		privilegeControlDto.setVendorCallTakers(vcCandidates);
		return privilegeControlDto;
	}

	@Override
	public PrivilegeControlDto manageVcCandidates(PrivilegeControlDto privilegeControlDto) {
		List<Candidate> candidates = new ArrayList<>(); 
		for(Map.Entry<User, List<Candidate>> entry : privilegeControlDto.getVendorCallTakers().entrySet()) {
			User key = entry.getKey(); 
			//key = userDaoService.find(key.getId());
			List<Candidate> tempCandiates = entry.getValue();
			
			for(Candidate c : tempCandiates) {
				c.setVcTaker(key);
				candidates.add(c); 
			}
			
		}
		
		
				
		/* Save to Database */
		userDaoService.saveCandidate(candidates);
		return privilegeControlDto;
	}

	@Override
	public PrivilegeControlDto getMarketerVcs() {
		HashMap<User, List<User>> marketeingVcs = new HashMap<>();
		PrivilegeControlDto privilegeControlDto = new PrivilegeControlDto();
		
		/* Get All Users */
		List<User> users = getUser(); 
		boolean isControlManaged = false; 
		List<User> vcList = new ArrayList<>(); 
		List<Long> vcIds = new ArrayList<>();
		
		for(User user: users) {
			if(user.getRole().toString().equals(Role.ROLE_MARKETING.toString())) {
				if(!marketeingVcs.containsKey(user)) {
					List<User> tempVcs  = new ArrayList<>();
					
					if(user.getControllableUsers().size() > 0){
						//List<User> supervisors = new ArrayList<>();
						for(UserControl userControl : user.getControllableUsers()) {
							userControl.getMarketer().setControllableUsers(null);
							tempVcs.add(userControl.getVendorCallTaker());
						}
						//List<User> supervisors = user.getControllableUsers();
						
						user.setControllableUsers(null);
						//user.setSupervisors(null);
						
						//tempVcs.addAll(supervisors);
						isControlManaged = true;
					}
					
					marketeingVcs.put(user, tempVcs); 
				} 
				
			}  else if(user.getRole().toString().equals(Role.ROLE_VC.toString())) {
				//Total VC List
				vcList.add(user);
				vcIds.add(user.getId());
			}
			
		}
		
		/* If Control not managed yet, add all vc to first Marketer */ 
		if(!isControlManaged && vcList.size() > 0) {
			 Map.Entry<User, List<User>> entry = marketeingVcs.entrySet().iterator().next();
			 User key= entry.getKey();
			 marketeingVcs.put(key, vcList);
		} else if(isControlManaged && vcList.size() > 0) {
			//Some Vc are not managed 
			 List<User> managedVc = userDaoService.getManagedVc(vcIds);
			 Map.Entry<User, List<User>> entry = marketeingVcs.entrySet().iterator().next();
			 User key= entry.getKey();
			 List<User> resultList = entry.getValue(); 
			 
			for(User vc: vcList) {
				if(!managedVc.contains(vc)) {
					resultList.add(vc); 
				}
			}
			
			marketeingVcs.put(key, resultList);
		}
		
		//privilegeControlDto = userService.getVcCandidates();
		privilegeControlDto.setMarketers(marketeingVcs);
		return privilegeControlDto;
	}

	@Override
	public PrivilegeControlDto manageMarketerVcs(PrivilegeControlDto privilegeControlDto) {
		 //first physical delete all  
		userDaoService.deleteUserControll();
		
		//Now save all the association 
		userDaoService.saveUserControll(privilegeControlDto); 
		return privilegeControlDto;
	}

	@Override
	public List<User> getUsers(Role role) {
		return userDaoService.getAllUsers(role);
	}

	@Override
	public List<User> getVcTakers(Long marketerId) {
		return userDaoService.getVcTakers(marketerId);
	}
	
	

}
