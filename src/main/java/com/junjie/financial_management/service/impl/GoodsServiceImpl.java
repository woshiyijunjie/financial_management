package com.junjie.financial_management.service.impl;

import com.junjie.financial_management.entity.Goods;
import com.junjie.financial_management.mapper.GoodsMapper;
import com.junjie.financial_management.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private GoodsMapper goodsMapper;

    //获取所有用户的信息
    @Override
    public List<Goods> getAllGoods() {
        return goodsMapper.getAllGoods();
    }

    //获取当前所有用户的所有信息
    @Override
    public List<Goods> getCurrentUserAllGoods(Integer id) {
        return goodsMapper.getCurrentUserAllGoods(id);
    }

    //查询信息 1.物品名称 2.物品类别 3.购买时间 (普通用户)
    @Override
    public List<Goods> selectCurrentUserGoodsByNKT(Integer uid, String goodsname, String goodskind, String time) {
        return goodsMapper.selectCurrentUserGoodsByNKT(uid, goodsname, goodskind, time);
    }

    //查询信息 1.学生姓名 2.学生学号 3.购买时间 (管理员)
    @Override
    public List<Goods> selectAllGoodsByNKT(String name, String number, String goodsbuytime) {
        return goodsMapper.selectAllGoodsByNKT(name, number, goodsbuytime);
    }

    //修改审查状态信息
    @Override
    public int updateGoodsStatus(Integer gid, Integer goodsstatus) {
        return goodsMapper.updateGoodsStatus(gid, goodsstatus);
    }

    //添加一条goods信息
    @Override
    public int addGoods(Goods good) {
        return goodsMapper.addGoods(good);
    }

    //当图片没有发生修改的时候修改四条信息
    @Override
    public int updateGoodsById(Goods good) {
        return goodsMapper.updateGoods(good);
    }

    //根据 id 删除一条信息
    @Override
    public int deleteGoodsById(Integer id) {
        return goodsMapper.deleteGoodsById(id);
    }
}
