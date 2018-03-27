package com.joy.bill.service.repository;

import com.joy.bill.model.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joy on 2018/3/27.
 */
public interface BillRepository extends JpaRepository<Bill,Integer> {
}
