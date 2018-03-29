package com.joy.bill.service;

import com.joy.bill.model.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Sort;

import java.util.List;

/**
 * Created by joy on 2018/3/28.
 */
public interface BillService {

    public List<Bill> getBillsByAccount(String account);

    public Bill addBills(Bill bill);

    public void delBillsByBillId(int id);

    public void updateBille(Bill bill);

    public Bill getBillById(int id);

    public Page<Bill> findAllByAccount(String account, int page, int count, String orderType, String coloum);



}
