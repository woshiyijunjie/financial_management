package com.junjie.financial_management.controller;

import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.subject.Subject;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

@Controller
public class ShiroHandler {

    @RequestMapping("/shiro/login")
    public String login(@RequestParam("username") String username,
                        @RequestParam("password") String password) {

        Subject currentUser = SecurityUtils.getSubject();

        if (!currentUser.isAuthenticated()) {
            // 把用户名和密码封装为 UsernamePasswordToken 对象
            UsernamePasswordToken token = new UsernamePasswordToken(username, password);
            // remember me
            token.setRememberMe(true);
            try {
                System.out.println(token.hashCode());
                // 执行登录.
                currentUser.login(token);
            }catch (UnknownAccountException uae) {
                // 如果没用指定的账户 shiro 会抛出 UnknownAccountException 异常

            } catch (IncorrectCredentialsException ice) {
                // 如果账户是存在的但是账户的密码不对会抛出 IncorrectCredentialsException 异常
                //注意：这个异常时shiro 在帮你比较密码时抛出的异常

            } catch (LockedAccountException lae) {
                // 如果用户被锁定会抛出 LockedAccountException 异常

            } catch (AuthenticationException ae) {
                // 所有认证异常的父类
                System.out.println("登陆出错失败！！！");
                System.out.println(ae.getMessage());
                return null;
            }
        }

        System.out.println(username +":"+password);
        return "redirect:/list";
    }

    //login
    @RequestMapping("/login")
    public String login() {
        return "login";
    }

    //list
    @RequestMapping("/list")
    public String list() {
        return "list";
    }

    ///unauthorized
    @RequestMapping("/unauthorized")
    public String unauthorized() {
        return "unauthorized";
    }

    //admin
    @RequestMapping("/admin")
    public String admin() {
        return "admin";
    }

    //user
    @RequestMapping("/user")
    public String user() {
        return "user";
    }
}
