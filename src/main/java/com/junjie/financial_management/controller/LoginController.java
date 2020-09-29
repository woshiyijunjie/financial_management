package com.junjie.financial_management.controller;

import com.junjie.financial_management.common.lang.Result;
import com.junjie.financial_management.entity.User;
import com.junjie.financial_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginController {

    @Autowired
    private UserService userService;

    //返回数据采用封装好的数据
    //根据 name 查询 user
    //这样接受 Json 数据只能使用 Post 请求
    @PostMapping(value = "/LoginGetUserByNumber")
    public Result getUserByName(@RequestBody User user) {
        try {
            User getUser = userService.getUserByNumber(user.getNumber());

            if (getUser.getPassword().equals(user.getPassword())) {
                //后面控制所需要的用户数据
                //1.id 2.name 3.status
                Map<String, Object> map = new HashMap<>();
                map.put("user_id", getUser.getId());
                map.put("user_name", getUser.getName());
                map.put("user_number", getUser.getNumber());
                map.put("user_bankid", getUser.getBankid());
                map.put("user_status", getUser.getStatus());
                return Result.success("登陆成功！", map);
            } else return Result.failure("用户密码错误！", null);
            //这里没有再专门去查取用户是否存在了，抛了空指针异常说明用户不存在
        } catch (NullPointerException e) {
            //这里还可以利用 Json 工具转化你想要发送过去的数据(数据以集合或者对象的方式)

            return Result.failure("用户不存在！", null);
        }
    }

}
