package com.cubic.ipm.util;

import com.cubic.ipm.model.Role;
import com.cubic.ipm.model.User;
import com.cubic.ipm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

import javax.annotation.PostConstruct;
import java.util.Date;

/**
 * Created by abc on 3/29/16.
 */
@Component
public class InitDB {
    @Autowired
    UserService userService;

    @PostConstruct
    public void inidDb() {
        User user = new User();
        user.setCreatedDate(new Date());
        user.setEmail("admin@yopmail.com");
        user.setFirstName("Admin");
        user.setLastName("Nimda");
        user.setMiddleName("B");
        user.setEnable(true);
        user.setPassword("admin@123");
        user.setRePassword("admin@123");
        user.setRole(Role.ROLE_ADMIN);
        user.setGender("m");
//        userService.createUser(user);
    }
}
