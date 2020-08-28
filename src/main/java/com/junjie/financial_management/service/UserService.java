package com.junjie.financial_management.service;

import com.junjie.financial_management.entity.User;

import java.util.List;

/**
 * @author yijunjie
 * @date 2020/7/19 - 10:43
 */
public interface UserService {

    //查询出所有的 Users
    List<User> getAllUsers();
    //根据学号来查询user所有信息
    User getUserByNumber(String number);
    //根据 id 来查询 User 所有信息
    User getUserById(Integer id);
    //根据 id 来修改 user 信息
    int updateUserById(User user);
    //根据 id 来查询 user 的密码信息
    String selectPasswordById(Integer id);
    //根据number和name来进行模糊查询
    List<User> getUsersByNN(User user);
    //根据 id 来修改密码
    int updateUserPassById(User user);
}
