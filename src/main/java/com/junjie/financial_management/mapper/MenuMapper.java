package com.junjie.financial_management.mapper;

import com.junjie.financial_management.entity.Menu;

import java.util.List;

public interface MenuMapper {

    //查询当前用户的菜单栏
    List<Menu> getMenu(Integer status);

}
