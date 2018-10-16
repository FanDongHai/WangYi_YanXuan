package com.wangyi.wangyi_yanxuan.utils;


import com.wangyi.wangyi_yanxuan.vo.R;

public class ResultUtil {

/**
 *@Author feri
 *@Date Created in 2018/10/12 11:37
 */

    public static R setOK(String msg){
        return new R(200,msg,null);
    }
    public static R setERROR(String msg){
        return new R(400,msg,null);
    }
    public static R setRes(int count){
        if(count>0){
            return setOK("操作成功");
        }else {
            return setERROR("操作失败");
        }
    }

}
