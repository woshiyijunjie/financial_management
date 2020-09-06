package com.junjie.financial_management.service;

import com.junjie.financial_management.entity.Bill;

import java.util.List;

public interface BillService {
    //查询所有的Bill信息
    List<Bill> getAllBill();
    //查询出当前用户的所有信息
    List<Bill> getAllUserBill(Integer uid);
    //根据 bill_name, bill_number, bill_time 进行查询操作
    List<Bill> getBillByNNT(String billname, String billnumber, String billtime, Integer uid);
    //增加一条信息
    int addBill(Bill bill);
    //根据 id 号删除 bill 的信息
    int deleteBillById(Integer id);
    //bill修改的方法
    int updateBillById(Bill bill);
    //bill修改的方法(四条信息)
    int updateFourBillById(Bill bill);
    //根据 id 改变 bill 的 bill_status 的状态
    int updateBillStatusById(Integer id, Integer billStatus);
    //根据 id 改变 bill 的 bill_money_status 的状态
    int updateBillMoneyStatusById(Integer id, Integer billMoneyStatus);
}
