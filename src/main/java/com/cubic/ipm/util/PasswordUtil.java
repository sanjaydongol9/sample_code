package com.cubic.ipm.util;

import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;

public class PasswordUtil {
	public static String encryptPassword(String password) {
		if (password != null && !password.isEmpty()) {
			BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
			return passwordEncoder.encode(password);
		}
		return null;
	}

	public static Boolean matchDBPassword(String rawPassword,
			String dbEncryptedPassword) throws Exception {
		BCryptPasswordEncoder passwordEncoder = new BCryptPasswordEncoder();
		if (!passwordEncoder.matches(rawPassword, dbEncryptedPassword))
			return false;

		return true;
	}
}
