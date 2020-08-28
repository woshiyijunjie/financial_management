package com.junjie.financial_management.entity;

/**
 * @author yijunjie
 * @date 2020/7/13 - 10:47
 */
public class User {

    private Integer id;
    private String number;//用户学号
    private String password;//用户密码
    private String name;//用户姓名
    private Integer sex;//性别
    private String bankid;//银行号码
    private String email;//邮箱
    private Integer status;//身份状态

    public User(String number, String password, String name, Integer sex, String bankid, String email, Integer status) {
        this.number = number;
        this.password = password;
        this.name = name;
        this.sex = sex;
        this.bankid = bankid;
        this.email = email;
        this.status = status;
    }

    public User() {

    }

    public Integer getId() {
        return id;
    }

    public void setId(Integer id) {
        this.id = id;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public Integer getSex() {
        return sex;
    }

    public void setSex(Integer sex) {
        this.sex = sex;
    }

    public String getBankid() {
        return bankid;
    }

    public void setBankid(String bankid) {
        this.bankid = bankid;
    }

    public String getEmail() {
        return email;
    }

    public void setEmail(String email) {
        this.email = email;
    }

    public Integer getStatus() {
        return status;
    }

    public void setStatus(Integer status) {
        this.status = status;
    }

    @Override
    public String toString() {
        return "User{" +
                "id=" + id +
                ", number='" + number + '\'' +
                ", password='" + password + '\'' +
                ", name='" + name + '\'' +
                ", sex=" + sex +
                ", bankid='" + bankid + '\'' +
                ", email='" + email + '\'' +
                ", status=" + status +
                '}';
    }
}
