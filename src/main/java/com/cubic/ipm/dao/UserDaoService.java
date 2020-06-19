package com.cubic.ipm.dao;

import com.cubic.ipm.dto.PrivilegeControlDto;
import com.cubic.ipm.model.Candidate;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;

import java.util.List;

public interface UserDaoService extends BaseDaoService<User> {

	// Spring Authentication Only
	public User findByUserName(String userName);

	public List<User> getUsers();
	
	public void deleteUser(Long id);

	/* Shift To Candidate Dao Service */
	public List<Candidate> getCandidates();

	public List<User> getAllUsers(Role role);

	public List<User> getNotAssignedVcTakers();

	/* Shift To Candidate Dao Service */
	public void saveCandidate(List<Candidate> candidates);
	public User findUserById(Long id);

	
	public void deleteUserControll();
	
	public PrivilegeControlDto saveUserControll(PrivilegeControlDto privilegeControlDto);
	
	public List<User> getManagedVc(List<Long> vcIds);
	
	public List<User> getVcTakers(Long marketerId); 
}
