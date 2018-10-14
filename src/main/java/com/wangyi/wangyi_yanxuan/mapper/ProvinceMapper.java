package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.Province;

public interface ProvinceMapper {
    int deleteByPrimaryKey(Integer pid);

    int insert(Province record);

    int insertSelective(Province record);

    Province selectByPrimaryKey(Integer pid);

    int updateByPrimaryKeySelective(Province record);

    int updateByPrimaryKey(Province record);
}