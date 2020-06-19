package com.cubic.ipm.util;

import java.util.Iterator;

import org.springframework.security.core.context.SecurityContextHolder;

import com.cubic.ipm.model.Role;


/**
 * @author Surendra J
 *
 */
public class SessionManager {
	private static final String BLANK = "";

	public static AuthenticatedUser getPrincipal() {
		return (AuthenticatedUser) SecurityContextHolder.getContext()
				.getAuthentication().getPrincipal();
	}

	public static String getUserName() {
		return getPrincipal().getUsername();
	}

	public static Role getRole() {
		String role = BLANK;
		for (Iterator<?> iterator = getPrincipal().getAuthorities().iterator(); iterator
				.hasNext();) {
			// Currently Just One Role Assigned
			role = String.valueOf(iterator.next());
			break;
		}
		return Role.valueOf(role);
	}

	public static Long getUserId() {
		return getPrincipal().getUserId();

	}

	public static boolean isAnonymousUser() {
		return SecurityContextHolder.getContext().getAuthentication()
				.getPrincipal().equals("anonymousUser");
	}
	
	public static AuthenticatedUser getAuthenticatedPriniciapl() {
		return (AuthenticatedUser) SecurityContextHolder
				.getContext().getAuthentication().getPrincipal();
	}

}
