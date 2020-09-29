package com.junjie.financial_management.controller;

import com.alibaba.fastjson.JSON;
import com.junjie.financial_management.service.MenuService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class MenuController {

    @Autowired
    private MenuService menuService;

    @GetMapping(value = "/getMenu")
    public String getMenu(@RequestParam("status") Integer id) {
        Map<String, Object> map = new HashMap<>();
        List<?> list = menuService.getMenu(id);
        map.put("menus", list);
        String json_res = JSON.toJSONString(map);
        return json_res;
    }
}
