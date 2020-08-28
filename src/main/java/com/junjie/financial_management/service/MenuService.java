package com.junjie.financial_management.service;

import com.junjie.financial_management.entity.Menu;

import java.util.List;

public interface MenuService {

    //根据用户查询显示列表
    List<Menu> getMenu(Integer id);
}
