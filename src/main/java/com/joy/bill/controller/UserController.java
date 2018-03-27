package com.joy.bill.controller;

import com.joy.bill.model.entity.User;
import com.joy.bill.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpRequest;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

/**
 * Created by joy on 2018/3/28.
 */

@RestController
@RequestMapping("/user")
public class UserController {

    @Autowired
    UserServiceImpl userService;

    @PostMapping("/adduser")
    public User addUser(User user){
        user = userService.addUser(user);
        return user;
    }


}
