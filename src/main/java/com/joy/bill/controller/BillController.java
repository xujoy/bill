package com.joy.bill.controller;

import com.joy.bill.model.entity.Bill;
import com.joy.bill.service.BillService;
import com.joy.bill.utils.Result;
import com.joy.bill.utils.ResultUtil;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;


/**
 * Created by joy on 2018/3/29.
 */
@RequestMapping(value = "/bill")
@RestController
public class BillController {

    @Autowired
    BillService billServiceimpl;

    @GetMapping("/billsbyaccount/{account}")
    public Result getBillsByaccount(@PathVariable String account){
        return ResultUtil.success(billServiceimpl.getBillsByAccount(account));
    }
    @PostMapping("/add")
    public Result addBills(Bill bill){
        return ResultUtil.success(billServiceimpl.addBills(bill));
    }


    @PutMapping("/update")
    public Result updateBill(Bill bill){
        System.out.println("~~~"+bill.getId());

         billServiceimpl.updateBille(bill);
         return ResultUtil.success();
    }


    @DeleteMapping("/del/{id}")
    public Result delBill(@PathVariable int id){
        billServiceimpl.delBillsByBillId(id);
         return ResultUtil.success();
    }


    @GetMapping("/getall/{page}/{count}/{account}")
    public Page<Bill> getBills(@PathVariable int page,@PathVariable int count,@PathVariable String account){
        return billServiceimpl.findAllByAccount(account,page,count,"DESC","id");
    }


}
