package com.joy.bill.service.repository;

import com.joy.bill.model.entity.BalanceChange;
import org.springframework.data.jpa.repository.JpaRepository;

/**
 * Created by joy on 2018/3/27.
 */
public interface BalanceChangeRepository extends JpaRepository<BalanceChange,Integer> {
}
