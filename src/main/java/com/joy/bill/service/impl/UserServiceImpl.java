package com.joy.bill.service.impl;

import com.joy.bill.model.entity.BalanceChange;
import com.joy.bill.model.entity.User;
import com.joy.bill.service.UserService;
import com.joy.bill.service.repository.BalanceChangeRepository;
import com.joy.bill.service.repository.UserRepository;
import com.joy.bill.utils.StringUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;

/**
 * Created by joy on 2018/3/27.
 */
@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    BalanceChangeRepository balanceChangeRepository;

    @Override
    public User addUser(User user) {
        if(userRepository.getByAccount(user.getAccount())== null){
            user.setPassword(StringUtil.encodeMD5(user.getAccount()+user.getPassword()));
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
            user.setPassword(StringUtil.encodeMD5(user.getAccount() + password));
            userRepository.save(user);
        }
    }

    /**
     * 减少用户的结余
     * @param money
     * @param account
     * @return
     */
    @Override
    @Transactional
    public void reduceUserBanlance(double money, String account ,String balanceMSG) {
        User user = userRepository.getByAccount(account);
        if(user!=null){
            BalanceChange balanceChange = new BalanceChange();
            balanceChange.setAccount(user.getAccount());
            balanceChange.setChangeAfter(user.getBalance());
            balanceChange.setChangeBefore(user.getBalance()+money);
            balanceChange.setMessage(balanceMSG);
            balanceChange.setDate(new Date());
            balanceChangeRepository.save(balanceChange);
            user.setBalance(user.getBalance()-money);
            userRepository.save(user);
        }

    }

    /**
     * 添加用户的结余
     * @param money
     * @param account
     * @return
     */
    @Override
    @Transactional
    public void addUserBanlance(double money, String account,String balanceMSG) {
        User user = userRepository.getByAccount(account);
        if(user!=null){

            BalanceChange balanceChange = new BalanceChange();
            balanceChange.setAccount(user.getAccount());
            balanceChange.setChangeAfter(user.getBalance());
            balanceChange.setChangeBefore(user.getBalance()+money);
            balanceChange.setMessage(balanceMSG);
            balanceChange.setDate(new Date());
            balanceChangeRepository.save(balanceChange);

            user.setBalance(user.getBalance()+money);
            userRepository.save(user);

        }

    }

}
