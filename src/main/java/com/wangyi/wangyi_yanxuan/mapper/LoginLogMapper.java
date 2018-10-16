package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface LoginLogMapper {

    @Insert("insert into t_loginlog (uid, createtime, ip) values (#{uid,jdbcType=INTEGER}, #{createtime,jdbcType=TIMESTAMP}, #{ip,jdbcType=VARCHAR})")
    int insert(LoginLog record);

    @Select("select * from t_loginlog")
    @ResultType(LoginLog.class)
    List<LoginLog> findAll();

}