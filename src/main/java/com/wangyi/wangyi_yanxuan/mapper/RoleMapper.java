package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.Role;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface RoleMapper {
    /**
     * 查询所有角色
     * @param rid
     * @return
     */
    @Select("select * from t_role")
    @ResultType(Role.class)
    List<Role> findAllRole();

}