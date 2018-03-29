package com.joy.bill.service.repository;

import com.joy.bill.model.entity.BalanceChange;
import org.springframework.data.repository.PagingAndSortingRepository;


/**
 * Created by joy on 2018/3/27.
 */
public interface BalanceChangeRepository extends PagingAndSortingRepository<BalanceChange,Integer> {
}
