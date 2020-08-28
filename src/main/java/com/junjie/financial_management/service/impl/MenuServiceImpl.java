package com.junjie.financial_management.service.impl;

import com.junjie.financial_management.entity.Menu;
import com.junjie.financial_management.mapper.MenuMapper;
import com.junjie.financial_management.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class MenuServiceImpl implements MenuService{

    //获取显示列表的信息
    @Autowired
    private MenuMapper menuMapper;

    //根据用户获取显示列表
    @Override
    public List<Menu> getMenu(Integer id) {
        return menuMapper.getMenu(id);
    }

}
