package com.junjie.financial_management.shiro;

import org.springframework.stereotype.Controller;
import java.util.LinkedHashMap;

@Controller
public class FilterChainDefinitionMapBuilder {
    public LinkedHashMap<String, String> builder() {
        LinkedHashMap<String, String> map = new LinkedHashMap<>();
        //这里填的是被映射的路径
        //map.put("http://localhost:8080/login","anon");
        //map.put("/shiro/login","anon");
        //map.put("/shiro/logout","logout")
        //角色拥有 user 权限才可以登陆 /user
        //map.put("/user","roles[user]");
        //map.put("/admin","roles[admin]");
        //map.put("/**","authc");
        map.put("/**", "anon");
        return map;
    }

}
