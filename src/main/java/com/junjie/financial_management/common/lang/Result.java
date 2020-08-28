package com.junjie.financial_management.common.lang;

import java.io.Serializable;

public class Result implements Serializable{

    private int code;//200 正常 400 数据异常
    private String msg;
    private Object data;

    public int getCode() {
        return code;
    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {
        return msg;
    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    private static Result getResult(int code, String msg, Object data) {
        Result r = new Result();
        r.setCode(code);
        r.setMsg(msg);
        r.setData(data);
        return r;
    }

    //成功时候的方法
    public static Result success(String msg, Object data) {
        return getResult(200, msg, data);
    }

    //失败时的方法
    public static Result failure(String msg, Object data) {
        return getResult(400, msg, data);
    }
}
