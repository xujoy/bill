package com.joy.bill.service.repository;

import com.joy.bill.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joy on 2018/3/27.
 */
public interface UserRepository extends JpaRepository<User,Integer> {

    public User getByAccount(String account);



}
