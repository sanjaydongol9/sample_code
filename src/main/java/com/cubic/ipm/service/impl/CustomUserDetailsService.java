package com.cubic.ipm.service.impl;

import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.cubic.ipm.dao.UserDaoService;
import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.util.AuthenticatedUser;


@Service("customUserDetailsService")
public class CustomUserDetailsService implements UserDetailsService {
	@Autowired
	private UserDaoService userDao;

	@Override
	@Transactional(readOnly=true)
	public UserDetails loadUserByUsername(final String username)
			throws UsernameNotFoundException {
		User user = userDao.findByUserName(username);

		List<GrantedAuthority> authorities = buildUserAuthority(user.getRole());
		AuthenticatedUser authUser = buildUserForAuthentication(user,
				authorities);
		return authUser;

	}

	private AuthenticatedUser buildUserForAuthentication(User user,
			List<GrantedAuthority> authorities) {
		Boolean enabled = true;

		AuthenticatedUser authenticatedUser = new AuthenticatedUser(
				user.getEmail(), user.getPassword(), enabled, true, true,
				true, authorities);

		authenticatedUser.setUserId(user.getId());

//		if (user.getRole().getRole().toString()
//				.equals(Role.ROLE_DOCTOR.toString())) {
//			authenticatedUser.setDoctorId(user.getDoctorEntity().getId());
//			authenticatedUser.setDoctorName(user.getDoctorEntity()
//					.getFirstName());
//		} else if (user.getRole().getRole().toString()
//				.equals(Role.ROLE_PATIENT.toString())) {
//			authenticatedUser.setPatientId(user.getPatientEntity().getId());
//			/*authenticatedUser.setDoctorName(user.getPatientEntity()
//					.getFirstName());*/
//
//		} else if (user.getRole().getRole().toString()
//				.equals(Role.ROLE_OPERATOR.toString())) {
//			authenticatedUser.setOperatorId(user.getOperatorEntity().getId());
//			authenticatedUser.setOperatorName(user.getOperatorEntity()
//					.getFirstName());
//
//		}

		return authenticatedUser;

	}

	private List<GrantedAuthority> buildUserAuthority(Role role) {
		Set<GrantedAuthority> setAuths = new HashSet<GrantedAuthority>();
		// Build user's authorities
		setAuths.add(new SimpleGrantedAuthority(role.name().toString()));
		List<GrantedAuthority> Result = new ArrayList<GrantedAuthority>(
				setAuths);
		return Result;
	}

	/*public UserDaoService getUserDao() {
		return userDao;
	}

	public void setUserDao(UserDaoService userDao) {
		this.userDao = userDao;
	}*/

}
