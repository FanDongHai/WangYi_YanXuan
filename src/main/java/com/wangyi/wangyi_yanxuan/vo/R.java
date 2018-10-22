package com.wangyi.wangyi_yanxuan.vo;

import java.util.List;
import java.util.Map;

public class R<T> {
    private int code;
    private int count;
    private String msg;
    private List<T> data;


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

    public List<T> getData() {
        return data;
    }

    public void setData(List<T> data) {
        this.data = data;
    }

    public int getCount() {
        return count;
    }

    public void setCount(int count) {
        this.count = count;
    }


    public R(int code, int count, String msg, List<T> data) {
        this.code = code;
        this.count = count;
        this.msg = msg;
        this.data = data;
    }

    public R() {
    }
}
