package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface LoginLogMapper {

    @Insert("insert into t_loginlog (no, createtime, ip) values (#{no,jdbcType=VARCHAR}, #{createtime,jdbcType=TIMESTAMP}, #{ip,jdbcType=VARCHAR})")
    int insert(LoginLog record);

    @Select("select * from t_loginlog order by createtime desc limit #{index},#{size}")
    @ResultType(LoginLog.class)
    List<LoginLog> findAll(Map<String, Object> info);

    @Select("select count(1) from t_loginlog")
    int count();

}