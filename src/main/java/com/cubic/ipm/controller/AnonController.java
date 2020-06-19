package com.cubic.ipm.controller;

import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.cubic.ipm.model.User;
import com.cubic.ipm.service.UserService;

@RestController
@RequestMapping("/anon/")
public class AnonController {
	private Logger logger = Logger.getLogger(AnonController.class); 
	
	@Autowired
	private UserService userService; 
	
	public User createUser(@RequestBody User user) {
		try {
			logger.info("++++ Creating the User ++++");
			return userService.createUser(user);
		} catch (IllegalArgumentException e) {
			logger.error(e.getMessage());
			throw new IllegalArgumentException(e.getMessage()); 
		}
	}
}
