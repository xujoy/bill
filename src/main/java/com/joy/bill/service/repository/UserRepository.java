package com.joy.bill.service.repository;

import com.joy.bill.model.entity.User;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.PagingAndSortingRepository;

/**
 * Created by joy on 2018/3/27.
 */
public interface UserRepository extends PagingAndSortingRepository<User,Integer> {

    public User getByAccount(String account);



}
