package com.junjie.financial_management.mapper;

import com.junjie.financial_management.entity.Goods;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface GoodsMapper {

    //获取所有的物品信息(这里使用连表查询)
    List<Goods> getAllGoods();

    //获取当前用户的所有信息
    List<Goods> getCurrentUserAllGoods(Integer id);

    //查询信息 1.物品名称 2.物品类别 3.购买时间
    List<Goods> selectCurrentUserGoodsByNKT(@Param("uid") Integer uid,
                                            @Param("goodsname") String goodsname,
                                            @Param("goodskind")String goodskind,
                                            @Param("time") String time);
    //查询信息 1.学生姓名 2.学生学号 3.购买时间
    List<Goods> selectAllGoodsByNKT(@Param("name") String name,
                                    @Param("number") String number,
                                    @Param("goodsbuytime") String goodsbuytime);
    //修改审查状态信息
    int updateGoodsStatus(@Param("gid") Integer gid, @Param("goodsstatus") Integer goodsstatus);

    //信息添加
    int addGoods(Goods good);

    //信息修改
    int updateGoods(Goods good);

    //根据 id 删除信息
    int deleteGoodsById(Integer id);

}
