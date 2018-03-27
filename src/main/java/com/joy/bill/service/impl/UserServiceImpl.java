package com.joy.bill.service.impl;

import com.joy.bill.model.entity.User;
import com.joy.bill.service.UserService;
import com.joy.bill.service.repository.UserRepository;
import com.sun.javafx.tools.ant.Utils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
/**
 * Created by joy on 2018/3/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public User addUser(User user) {
        if(userRepository.getByAccount(user.getAccount())== null){
            user = userRepository.save(user);
        }
        return user;
    }

    @Override
    public User selectUserByAccount(String account) {
        return userRepository.getByAccount(account);
    }

    @Override
    public void changePWD(String account, String password) {
        User user = userRepository.getByAccount(account);
        if(user!=null){
            user.setPassword(password);
            userRepository.save(user);
        }
    }
}
