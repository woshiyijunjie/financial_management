package com.junjie.financial_management.controller;

import com.alibaba.fastjson.JSON;
import com.github.pagehelper.PageHelper;
import com.github.pagehelper.PageInfo;
import com.junjie.financial_management.entity.User;
import com.junjie.financial_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

/**
 * @author yijunjie
 * @date 2020/7/19 - 10:54
 */
//@CrossOrigin//这一个注解是用来解决跨域的问题
@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //获取所有的Users
    @GetMapping("/getAllUsers")
    public String getAllUsers(@RequestParam("pageNum") Integer pageNum,
                              @RequestParam("pageSize") Integer pageSize) {
        PageHelper.startPage(pageNum, pageSize);
        List<User> allUsers = userService.getAllUsers();
        PageInfo<User> pageInfo = new PageInfo<>(allUsers);
        String json_res = JSON.toJSONString(pageInfo);
        return json_res;
    }

    //根据 id 来查询 User 所有信息
    @GetMapping("/getUserById")
    public User getUserById(@RequestParam("id") Integer id) {
        return userService.getUserById(id);
    }

    //根据 id 来修改 user 信息
    @PutMapping("/updateUserById")
    public String updateUserById(@RequestBody User user) {
        userService.updateUserById(user);
        return "SUCCESS";
    }

    //根据 id 来查询 user 密码信息
    @GetMapping("/selectPasswordById")
    public String selectPasswordById(@RequestParam("id") Integer id) {
        return userService.getUserById(id).getPassword();
    }

    //根据 id 和 name 来进行模糊查询
    @GetMapping("/getUsersByNN")
    public String getUsersByNN(@RequestParam(value = "number", required = false) String number,
                               @RequestParam(value = "name", required = false) String name) {

        User user = new User();
        user.setNumber(number);
        user.setName(name);
        return JSON.toJSONString(userService.getUsersByNN(user));
    }

    //根据 id 来修改 user 的密码信息
    @PutMapping("/updateUserPasswordById")
    public int updateUserPasswordById(@RequestBody User user) {
        return userService.updateUserPassById(user);
    }
}
