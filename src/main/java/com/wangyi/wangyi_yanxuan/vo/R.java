package com.wangyi.wangyi_yanxuan.vo;


/**
 *@Author feri
 *@Date Created in 2018/10/12 11:36
 */

public class R {
    private int code;
    private String msg;
    private Object data;

    public int getCode() {

        return this.code;

    }

    public void setCode(int code) {
        this.code = code;
    }

    public String getMsg() {

        return this.msg;

    }

    public void setMsg(String msg) {
        this.msg = msg;
    }

    public Object getData() {

        return this.data;


    }

    public void setData(Object data) {
        this.data = data;
    }

    public R(int code, String msg, Object data) {
        this.code = code;
        this.msg = msg;
        this.data = data;
    }

    public R() { }

}
