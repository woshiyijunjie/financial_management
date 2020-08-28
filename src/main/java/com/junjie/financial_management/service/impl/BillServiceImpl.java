package com.junjie.financial_management.service.impl;

import com.junjie.financial_management.entity.Bill;
import com.junjie.financial_management.mapper.BillMapper;
import com.junjie.financial_management.service.BillService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class BillServiceImpl implements BillService{

    @Autowired
    private BillMapper billMapper;

    //查询所有的Bill信息
    @Override
    public List<Bill> getAllBill() {
        return billMapper.getAllBill();
    }

    //查询出当前用户所有信息

    @Override
    public List<Bill> getAllUserBill(Integer uid) {
        return billMapper.getAllUserBill(uid);
    }

    //根据 bill_name, bill_number, bill_time 进行查询操作
    @Override
    public List<Bill> getBillByNNT(String billname, String billnumber, String billtime, Integer uid) {
        return billMapper.getBillByNNT(billname, billnumber, billtime, uid);
    }

    //增加一条信息
    @Override
    public int addBill(Bill bill) {
        return billMapper.addBill(bill);
    }
    //根据 id 号删除 bill 的信息
    @Override
    public int deleteBillById(Integer id) {
        return billMapper.deleteBillById(id);
    }

    //修改的方法
    @Override
    public int updateBillById(Bill bill) {
        return billMapper.updateBillById(bill);
    }

    //修改的方法(四条信息)
    @Override
    public int updateFourBillById(Bill bill) {
        return billMapper.updateFourBillById(bill);
    }

    //根据 id 改变 bill 的 bill_status 的状态
    @Override
    public int updateBillStatusById(Integer id, Integer billStatus) {
        return billMapper.updateBillStatusById(id, billStatus);
    }
    //根据 id 改变 bill 的 bill_money_status 的状态
    @Override
    public int updateBillMoneyStatusById(Integer id, Integer billMoneyStatus) {
        return billMapper.updateBillMoneyStatusById(id, billMoneyStatus);
    }
}
