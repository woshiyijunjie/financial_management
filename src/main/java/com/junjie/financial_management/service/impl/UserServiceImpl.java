package com.junjie.financial_management.service.impl;

import com.junjie.financial_management.entity.User;
import com.junjie.financial_management.mapper.UserMapper;
import com.junjie.financial_management.realm.ShiroRealm;
import com.junjie.financial_management.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

/**
 * @author yijunjie
 * @date 2020/7/19 - 10:44
 */
@Service
public class UserServiceImpl implements UserService{

    @Autowired
    private UserMapper userMapper;

    //查询出所有的Users
  @Override
    public List<User> getAllUsers () {
        return userMapper.getAllUsers();
    }
    //根据学号来查询密码
    @Override
    public User getUserByNumber(String number) {
        return userMapper.getUserByNumber(number);
    }
    //根据 id 来查询信息
    @Override
    public User getUserById(Integer id) {
        return userMapper.getUserById(id);
    }
    //根据 id 来修改 user 信息
    @Override
    public int updateUserById(User user) {
        return userMapper.updateUserById(user);
    }
    //根据 id 来查询 user 密码信息
    @Override
    public String selectPasswordById(Integer id) {
        return userMapper.getUserById(id).getPassword();
    }
    //根据number和name来进行模糊查询
    @Override
    public List<User> getUsersByNN(User user) {
        return userMapper.getUsersByNN(user);
    }
    @Override
    public int updateUserPassById(User user) {
        return userMapper.updateUserPassById(user);
    }
}
