package com.joy.bill.service;

import com.joy.bill.model.entity.User;

/**
 * Created by joy on 2018/3/27.
 */
public interface UserService {

    public User addUser(User user);

    public User selectUserByAccount(String account);

    public void changePWD(String account,String password);



}
