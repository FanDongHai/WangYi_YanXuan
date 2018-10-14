package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.UserTemp;

public interface UserTempMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(UserTemp record);

    int insertSelective(UserTemp record);

    UserTemp selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(UserTemp record);

    int updateByPrimaryKey(UserTemp record);
}