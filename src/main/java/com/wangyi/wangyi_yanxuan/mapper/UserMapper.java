package com.wangyi.wangyi_yanxuan.mapper;

import com.wangyi.wangyi_yanxuan.domain.User;
import org.apache.ibatis.annotations.*;

public interface UserMapper {

    @Insert(" insert into t_user (no, username, password, flag) values ( #{no,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, 1)")
    int insert(User record);
    @Select("select * from t_user where no=#{no}")
    @ResultType(User.class)
    User selectByName(String no);


}