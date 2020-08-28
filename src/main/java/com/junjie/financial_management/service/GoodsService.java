package com.junjie.financial_management.service;

import com.junjie.financial_management.entity.Goods;

import java.util.List;

public interface GoodsService {

    //获取的所有账务信息
    List<Goods> getAllGoods();
    //获取当前所有用户的所有信息
    List<Goods> getCurrentUserAllGoods(Integer id);
    //当前用户查询：1.用户 uid 2.goods_name 3.goods_kind 4.goods_buy_time
    List<Goods> selectCurrentUserGoodsByNKT(Integer uid, String goodsname, String goodskind, String time);
    //管理员查询信息 1.学生姓名 2.学生学号 3.购买时间
    List<Goods> selectAllGoodsByNKT(String name,String number,String goodsbuytime);
    //修改审查状态信息
    int updateGoodsStatus(Integer gid, Integer goodsstatus);
    //添加一条goods信息
    int addGoods(Goods good);
    //修改信息
    int updateGoodsById(Goods good);
    //根据 id 删除一条信息
    int deleteGoodsById(Integer id);
}
