package com.junjie.financial_management.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junjie.financial_management.entity.Bill;
import com.junjie.financial_management.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class BillController {

    @Autowired
    private BillService billService;

    //获取所有的 Bill 信息 (使用分页操作)
    @GetMapping("/getAllBill")
    public String getAllBill(@RequestParam("pageNum") Integer pageNum,
                             @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bill> allBills = billService.getAllBill();
        PageInfo<Bill> pageInfo = new PageInfo<>(allBills);
        String json_res = JSON.toJSONString(pageInfo);
        return json_res;
    }

    //获取当前用户的所有信息
    @GetMapping("/getAllUserBill")
    public String getAllUserBill(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize,
                                 @RequestParam("uid") Integer uid) {
        PageHelper.startPage(pageNum, pageSize);
        List<Bill> allBills = billService.getAllUserBill(uid);
        PageInfo<Bill> pageInfo = new PageInfo<>(allBills);
        String json_res = JSON.toJSONString(pageInfo);
        return json_res;
    }

    //修改 bill 的 bill_money_status 的状态
    @PutMapping("/updateBillMoneyStatusById/{id}")
    public int updateBillMoneyStatusById(@PathVariable("id") Integer id,
                                         @RequestParam("billMoneyStatus") Integer billMoneyStatus) {
        return billService.updateBillMoneyStatusById(id, billMoneyStatus);
    }

    //修改 bill 的 四条信息
    @PutMapping(value = "/updateFourBillById")
    public String updateFourBillById(@RequestBody Bill bill) {
        billService.updateFourBillById(bill);
        return "SUCCESS";
    }

    //根据 bill_name, bill_number, bill_time 进行查询操作
    @GetMapping("/getBillByNNT")
    public String getBillByNNT(@RequestParam(value = "billname", required = false) String billname,
                               @RequestParam(value = "billnumber", required = false) String billnumber,
                               @RequestParam(value = "billtime", required = false) String billtime,
                               @RequestParam(value = "uid", required = false) Integer uid) {
        return JSON.toJSONString(billService.getBillByNNT(billname, billnumber, billtime, uid));
    }
}
