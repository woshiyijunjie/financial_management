package com.junjie.financial_management.entity;

import com.fasterxml.jackson.annotation.JsonFormat;
import org.springframework.format.annotation.DateTimeFormat;

import java.util.Date;

public class Bill {

    private Integer id;
    private Integer uid;
    private String billName;//姓名
    private String billBankid;//银行账户
    private String billNumber;//学号
    private double billSmoney;//应到金额
    @DateTimeFormat(pattern = "yyyy-MM-dd")
    @JsonFormat(pattern = "yyyy-MM-dd")
    private Date billTime;//报账日期
    private double billRmoney;//实到金额
    private Integer billStatus;//状态
    private Integer billMoneyStatus;//是否转钱的状态

    public Bill(Integer uid, String billName, String billBankid, String billNumber, double billSmoney, Date billTime, double billRmoney, Integer billStatus, Integer billMoneyStatus) {
        this.uid = uid;
        this.billName = billName;
        this.billBankid = billBankid;
        this.billNumber = billNumber;
        this.billSmoney = billSmoney;
        this.billTime = billTime;
        this.billRmoney = billRmoney;
        this.billStatus = billStatus;
        this.billMoneyStatus = billMoneyStatus;
    }

    public Bill() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public Integer getUid() {
        return uid;
    }

    public void setUid(Integer uid) {
        this.uid = uid;
    }

    public String getBillName() {
        return billName;
    }

    public void setBillName(String billName) {
        this.billName = billName;
    }

    public String getBillBankid() {
        return billBankid;
    }

    public void setBillBankid(String billBankid) {
        this.billBankid = billBankid;
    }

    public String getBillNumber() {
        return billNumber;
    }

    public void setBillNumber(String billNumber) {
        this.billNumber = billNumber;
    }

    public double getBillSmoney() {
        return billSmoney;
    }

    public void setBillSmoney(double billSmoney) {
        this.billSmoney = billSmoney;
    }

    public Date getBillTime() {
        return billTime;
    }

    public void setBillTime(Date billTime) {
        this.billTime = billTime;
    }

    public double getBillRmoney() {
        return billRmoney;
    }

    public void setBillRmoney(double billRmoney) {
        this.billRmoney = billRmoney;
    }

    public Integer getBillStatus() {
        return billStatus;
    }

    public void setBillStatus(Integer billStatus) {
        this.billStatus = billStatus;
    }

    public Integer getBillMoneyStatus() {
        return billMoneyStatus;
    }

    public void setBillMoneyStatus(Integer billMoneyStatus) {
        this.billMoneyStatus = billMoneyStatus;
    }

    @Override
    public String toString() {
        return "Bill{" +
                "id=" + id +
                ", uid=" + uid +
                ", billName='" + billName + '\'' +
                ", billBankid='" + billBankid + '\'' +
                ", billNumber='" + billNumber + '\'' +
                ", billSmoney=" + billSmoney +
                ", billTime=" + billTime +
                ", billRmoney=" + billRmoney +
                ", billStatus=" + billStatus +
                ", billMoneyStatus=" + billMoneyStatus +
                '}';
    }
}
