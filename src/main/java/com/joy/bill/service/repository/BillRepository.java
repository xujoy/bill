package com.joy.bill.service.repository;

import com.joy.bill.model.entity.Bill;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.Pageable;
import org.springframework.data.repository.PagingAndSortingRepository;

import java.util.List;

/**
 * Created by joy on 2018/3/27.
 */
public interface BillRepository extends PagingAndSortingRepository<Bill,Integer> {

    public List<Bill> getByAccount(String account);

    Page<Bill> findByAccount(Pageable pageable,String account);






}
