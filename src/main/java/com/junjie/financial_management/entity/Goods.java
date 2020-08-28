package com.junjie.financial_management.entity;

import java.util.Date;

public class Goods {

    private Integer id;
    private Integer uid;
    private Integer bid;
    //连表查询的字段----
    private String number;//用户学号
    private String name;//用户姓名
    //-----------------
    private String goodsName;//物品名称
    private String goodsKind;//物品种类
    private double goodsMoney;//花费金额
    private Date goodsBuyTime;//购买时间
    private String goodsUpTime;//上传时间
    private Integer goodsStatus;//审查状态

    public Goods(Integer uid, Integer bid, String goodsName, String goodsKind, double goodsMoney, Date goodsBuyTime, String goodsUpTime, Integer goodsStatus) {
        this.uid = uid;
        this.bid = bid;
        this.goodsName = goodsName;
        this.goodsKind = goodsKind;
        this.goodsMoney = goodsMoney;
        this.goodsBuyTime = goodsBuyTime;
        this.goodsUpTime = goodsUpTime;
        this.goodsStatus = goodsStatus;
    }

    public Goods() {

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

    public Integer getBid() {
        return bid;
    }

    public void setBid(Integer bid) {
        this.bid = bid;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getGoodsName() {
        return goodsName;
    }

    public void setGoodsName(String goodsName) {
        this.goodsName = goodsName;
    }

    public String getGoodsKind() {
        return goodsKind;
    }

    public void setGoodsKind(String goodsKind) {
        this.goodsKind = goodsKind;
    }

    public double getGoodsMoney() {
        return goodsMoney;
    }

    public void setGoodsMoney(double goodsMoney) {
        this.goodsMoney = goodsMoney;
    }

    public Date getGoodsBuyTime() {
        return goodsBuyTime;
    }

    public void setGoodsBuyTime(Date goodsBuyTime) {
        this.goodsBuyTime = goodsBuyTime;
    }

    public String getGoodsUpTime() {
        return goodsUpTime;
    }

    public void setGoodsUpTime(String goodsUpTime) {
        this.goodsUpTime = goodsUpTime;
    }

    public Integer getGoodsStatus() {
        return goodsStatus;
    }

    public void setGoodsStatus(Integer goodsStatus) {
        this.goodsStatus = goodsStatus;
    }

    @Override
    public String toString() {
        return "Goods{" +
                "id=" + id +
                ", uid=" + uid +
                ", bid=" + bid +
                ", number='" + number + '\'' +
                ", name='" + name + '\'' +
                ", goodsName='" + goodsName + '\'' +
                ", goodsKind='" + goodsKind + '\'' +
                ", goodsMoney=" + goodsMoney +
                ", goodsBuyTime=" + goodsBuyTime +
                ", goodsUpTime='" + goodsUpTime + '\'' +
                ", goodsStatus=" + goodsStatus +
                '}';
    }
}
