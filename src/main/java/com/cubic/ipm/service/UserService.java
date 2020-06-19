package com.cubic.ipm.service;


import com.cubic.ipm.dto.PrivilegeControlDto;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;

import java.util.List;


public interface UserService {
	public User createUser(User user);
	public List<User> getUser();
	public void deleteUser(Long id);
	public void updateUser(User user);
	public Role[] getRole();
	
	/* Get Vendor Call Taker and Respected Candidates & Manage Methods */
	public PrivilegeControlDto getVcCandidates();
	public PrivilegeControlDto manageVcCandidates(PrivilegeControlDto privilegeControlDto);
	
	/* Get Marketer and respected Vendor Call Taker and Manage Methods */
	public PrivilegeControlDto getMarketerVcs();
	public PrivilegeControlDto manageMarketerVcs(PrivilegeControlDto privilegeControlDto);
	
	/* For Tree Structure */ 
	public List<User> getUsers(Role role);
	public List<User> getVcTakers(Long marketerId); 
	
	
	
}
