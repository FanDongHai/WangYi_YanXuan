package com.wangyi.wangyi_yanxuan.mapper;

import com.wangyi.wangyi_yanxuan.domain.User;
import org.apache.ibatis.annotations.*;

import java.util.List;

public interface UserMapper {

    @Insert(" insert into t_user (no, username, password, flag) values ( #{no,jdbcType=VARCHAR}, #{username,jdbcType=VARCHAR}, #{password,jdbcType=VARCHAR}, 1)")
    int insert(User record);
    @Select("select * from t_user where no=#{no}")
    @ResultType(User.class)
    User selectByName(String no);

    @Select("select * from t_user")
    @ResultType(User.class)
    List<User> findAll();

    @Delete("delete from t_user where uid=#{uid}")
    int deleteUser(int uid);

}