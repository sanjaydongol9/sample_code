package com.cubic.ipm.controller;

import com.cubic.ipm.model.User;
import com.cubic.ipm.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * Created by Sunil on 3/16/2016.
 */
@RestController
@RequestMapping(value = "/user")
public class UserController {

    @Autowired
    UserService userService;

    @RequestMapping(value = "/allUser", method = RequestMethod.GET)
    public List<User> getAllUser() {
        return userService.getUser();
    }

    @RequestMapping(value = "/deleteUser/{id}", method = RequestMethod.GET)
    public void deleteUser(@PathVariable("id") Long id){
        userService.deleteUser(id);
    }

    @RequestMapping(value = "/updateUser", method = RequestMethod.PUT)
    public void updateUser(@RequestBody User user){

        userService.updateUser(user);
    }


}
