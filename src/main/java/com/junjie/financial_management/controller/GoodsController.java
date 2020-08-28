package com.junjie.financial_management.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junjie.financial_management.entity.Goods;
import com.junjie.financial_management.service.BillService;
import com.junjie.financial_management.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
public class GoodsController {

    @Autowired
    private GoodsService goodsService;

    @Autowired
    private BillService billService;

    //查询出所有用户的物品信息
    @GetMapping(value = "/getAllGoods")
    public String getStuAllGoods(@RequestParam("pageNum") Integer pageNum,
                                 @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> allGoods = goodsService.getAllGoods();
        PageInfo<Goods> pageInfo = new PageInfo<>(allGoods);
        String json_res = JSON.toJSONString(pageInfo);
        return json_res;
    }
    //查询出当前用户所有的物品信息
    @GetMapping(value = "/getCurrentUserAllGoods")
    public String getCurrentUserAllGoods(@RequestParam("pageNum") Integer pageNum,
                                         @RequestParam("pageSize") Integer pageSize,
                                         @RequestParam("id") Integer id) {
        PageHelper.startPage(pageNum, pageSize);
        List<Goods> allGoods = goodsService.getCurrentUserAllGoods(id);
        PageInfo<Goods> pageInfo = new PageInfo<>(allGoods);
        String json_res = JSON.toJSONString(pageInfo);
        return json_res;
    }
    //根据 1.货物名 2.货物种类 3.购买时间  查询信息(普通用户)
    @GetMapping(value = "/selectCurrentUserGoodsByNKT")
    public String selectCurrentUserGoodsByNKT(@RequestParam(value = "uid") Integer uid,
                              @RequestParam(value = "goodsname", required = false) String goodsname,
                              @RequestParam(value = "goodskind", required = false) String goodskind,
                              @RequestParam(value = "time" , required = false) String time){
        return JSON.toJSONString(goodsService.selectCurrentUserGoodsByNKT(uid, goodsname, goodskind, time));
    }
    //查询信息 1.学生姓名 2.学生学号 3.购买时间 (管理员)
    @GetMapping(value = "/selectAllGoodsByNKT")
    public String selectBySST(@RequestParam(value = "name", required = false) String name,
                              @RequestParam(value = "number", required = false) String number,
                              @RequestParam(value = "goodsbuytime", required = false) String goodsbuytime) {
        return JSON.toJSONString(goodsService.selectAllGoodsByNKT(name, number, goodsbuytime));
    }
    //修改审查状态信息(这里同时也要把 bill 里面的状态修改)
    @PutMapping(value = "/updateGoodsStatus/{gid}")
    public int updateGoodsStatus(@PathVariable("gid") Integer gid,
                                 @RequestParam("bid") Integer bid,
                                 @RequestParam("goodsstatus") Integer goodsstatus) {
        return goodsService.updateGoodsStatus(gid, goodsstatus)
             + billService.updateBillStatusById(bid, goodsstatus);
    }
    //删除对应的 goods
    @DeleteMapping("/deleteGoodsById")
    public int deleteGoodsById(@RequestParam("id") Integer id, @RequestParam("bid") Integer bid) {
        return goodsService.deleteGoodsById(id) + billService.deleteBillById(bid);
    }

}
