package com.cubic.ipm.dao.impl;

import java.util.ArrayList;
import java.util.List;
import java.util.Map;
import java.util.StringJoiner;

import com.cubic.ipm.enums.Flags;
import org.hibernate.Criteria;
import org.hibernate.Query;
import org.hibernate.criterion.Restrictions;
import org.springframework.stereotype.Repository;

import com.cubic.ipm.dao.UserDaoService;
import com.cubic.ipm.dto.PrivilegeControlDto;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.model.UserControl;


@Repository
public class UserDaoServiceImpl extends BaseDaoServiceImpl<User> implements UserDaoService {

	@SuppressWarnings("unchecked")
	@Override
	public User findByUserName(String userName) {
		List<User> proxyList = new ArrayList<User>();
		Criteria criteria = getCurrentSession()
				.createCriteria(User.class);
		criteria.add(Restrictions.eq("username", userName));
		proxyList = criteria.list();
		return proxyList.size() > 0 ? proxyList.get(0) : null;
	}

	@Override
	public List<User> getUsers() {
		List<User> user = new ArrayList<>();

		String sql = "FROM com.cubic.ipm.model.User u where u.flag <>:flag";
		Query query = getCurrentSession()
				.createQuery(sql);
		query.setParameter("flag", Flags.DELETED);

		return  query.list();
}

	@Override
	public void deleteUser(Long id) {
		delete(id);
	}

	@Override
	public List<Candidate> getCandidates() {
		List<Candidate> candidates = new ArrayList<Candidate>();
		candidates = getCurrentSession().createCriteria(Candidate.class).list();
		return candidates;
	}

	@Override
	public List<User> getAllUsers(Role role) {
		Query query = getCurrentSession().createQuery("from User u where role=:role");
		query.setParameter("role", role);
		return query.list();
	}

	@Override
	public List<User> getNotAssignedVcTakers() {
		List<User> vcTakers = new ArrayList<>();

		Query query = getCurrentSession()
				.createQuery("from User u where u.id not in ( select c.vcTaker.id from Candidate c) "
						+ "AND u.role=:role");
		query.setParameter("role", Role.ROLE_VC);


		vcTakers = query.list();
		return vcTakers;
	}

	@Override
	public void saveCandidate(List<Candidate> candidates) {

		for(Candidate candidate: candidates){
			//getCurrentSession().saveOrUpdate(candidate);
			String sql = "UPDATE Candidate set vcTaker = :vcId WHERE id=:id";
			Query query = getCurrentSession().createQuery(sql);
			query.setLong("vcId", candidate.getVcTaker().getId());
			query.setLong("id", candidate.getId());
			query.executeUpdate();
		}


	}
	public User findUserById(Long id){
		return find(id);
	}

	@Override	
	public void deleteUserControll() {
		String sql = "DELETE FROM UserControl"; 
		Query query = getCurrentSession().createQuery(sql); 
		query.executeUpdate();
		//getCurrentSession().clear();
	}

	@Override
	public PrivilegeControlDto saveUserControll(PrivilegeControlDto privilegeControlDto) {
		
		//String sql = "INSERT INTO UserControl(id, marketer,vendorCallTaker) VALUES "; 
		//StringJoiner joiner = new StringJoiner(",");
		
		for(Map.Entry<User, List<User>> entry: privilegeControlDto.getMarketers().entrySet()) {
			User user = entry.getKey(); 
			List<User> userVcs = entry.getValue();
			if(userVcs.size()> 0) {
				for(User tempUser: userVcs) {
					//joiner.add("('',"+user.getId() + ","+tempUser.getId()+")");
					UserControl userControl = new UserControl(); 
					User tUser = new User(); 
					tUser.setId(user.getId());
					userControl.setMarketer(tUser);
					
					tUser = new User(); 
					tUser.setId(tempUser.getId());
					userControl.setVendorCallTaker(tUser);
					
					getCurrentSession().save(userControl);
					
				}
			}
			
		}
//		sql = sql + joiner.toString();
//		
//		Query query = getCurrentSession().createQuery(sql); 
//		query.executeUpdate();
		return privilegeControlDto;
	}
	
	@Override
	public List<User> getManagedVc(List<Long> vcIds) {
		Query query = getCurrentSession().createQuery("select distinct uc.vendorCallTaker from UserControl uc "
				+ "where uc.vendorCallTaker.id in(:vcIds))");
		query.setParameterList("vcIds", vcIds);
		return query.list();
	}

	@Override
	public List<User> getVcTakers(Long marketerId) {
		Query query = getCurrentSession().createQuery("select uc.vendorCallTaker from UserControl uc where uc.marketer.id=:marketerId"); 
		query.setLong("marketerId", marketerId); 
		return query.list();
	}

}
