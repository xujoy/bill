package com.joy.bill.service.impl;

import com.joy.bill.model.entity.Bill;
import com.joy.bill.service.BillService;
import com.joy.bill.service.UserService;
import com.joy.bill.service.repository.BillRepository;
import org.apache.commons.lang3.StringUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;
import java.util.Date;
import java.util.List;
import java.util.Optional;

/**
 * Created by joy on 2018/3/29.
 */
@Service
public class BillServiceImpl implements BillService {
    @Autowired
    BillRepository billRepository;
    @Autowired
    UserService userService;


    @Override
    public List<Bill> getBillsByAccount(String account) {
        return billRepository.getByAccount(account);
    }

    @Override
    @Transactional
    public Bill addBills(Bill bill) {
        if(!StringUtils.isBlank(bill.getAccount())){
            //如果是消费的话则从用户的结余里面进行扣除
            if(bill.getBuy()>0 || bill.getSale()>0){
                bill.setProfit(bill.getSale()-bill.getBuy());
                billRepository.save(bill);
                userService.reduceUserBanlance(bill.getBuy(),bill.getAccount(),"添加买入，卖出记录修改账户结余");
            }
            //判断添加的流水是退款还是运费  则想用户的结余里面进行添加
            if(bill.getRefund()>0 || bill.getFreight()>0){
                billRepository.save(bill);
                userService.addUserBanlance(bill.getRefund()+bill.getFreight(),bill.getAccount(),"添加退款，运费修改账户结余");
            }
        }
        return null;
    }

    @Override
    @Transactional
    public void delBillsByBillId(int id) {
        Optional<Bill> optionalbill = billRepository.findById(id);
        if(optionalbill.isPresent()){
            Bill bill = optionalbill.get();
            if(bill.getBuy()>0 || bill.getSale()>0){
                billRepository.delete(bill);
                userService.addUserBanlance(bill.getBuy(),bill.getAccount(),"删除买入卖出记录，修改账户结余");
            }
            //删除和添加相反
            if(bill.getRefund()>0 || bill.getFreight()>0){
                billRepository.delete(bill);
                userService.reduceUserBanlance(bill.getRefund()+bill.getFreight(),bill.getAccount(),"删除退款，运费记录，修改账户结余");
            }

        }
    }

    @Override
    @Transactional
    public void updateBille(Bill bill) {
        Bill oldBill = getBillById(bill.getId());
        if(oldBill.getBuy()>0 || oldBill.getSale()>0){
            userService.addUserBanlance(oldBill.getBuy(),oldBill.getAccount(),"修改买入，卖出记录，修改账户结余");
        }
        //删除和添加相反
        if(oldBill.getRefund()>0 || oldBill.getFreight()>0){
            userService.reduceUserBanlance(oldBill.getRefund()+oldBill.getFreight(),oldBill.getAccount(),"修改退款，运费记录，修改账户结余");
        }

        if(bill.getBuy()>0 || bill.getSale()>0){
            bill.setProfit(bill.getSale()-bill.getBuy());
            bill.setDate(new Date());
            billRepository.save(bill);
            userService.reduceUserBanlance(bill.getBuy(),bill.getAccount(),"修改买入，卖出记录，修改账户结余");
        }
        //判断添加的流水是退款还是运费  则想用户的结余里面进行添加
        if(bill.getRefund()>0 || bill.getFreight()>0){
            billRepository.save(bill);
            userService.addUserBanlance(bill.getRefund()+bill.getFreight(),bill.getAccount(),"修改退款，运费记录，修改账户结余");
        }
    }

    @Override
    public Bill getBillById(int id) {
        Bill bill = null;
        Optional<Bill> optionalBill =  billRepository.findById(id);
        if(optionalBill.isPresent()){
            bill = optionalBill.get();
        }
        return bill;
    }
    @Override
    public Page<Bill> findAllByAccount(String account, int page, int count,String orderType,String coloum) {
        Sort sort = new Sort(Sort.Direction.fromString(orderType), coloum);
        Pageable pageable = PageRequest.of(page,count,sort);
        Page<Bill> bills = billRepository.findByAccount(pageable,account);
        System.out.println("总条数"+bills.getTotalElements());
        System.out.println("总页数"+bills.getTotalPages());
        return bills;
    }

}
