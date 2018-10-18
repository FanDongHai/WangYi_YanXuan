package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.Perssion;
import com.wangyi.wangyi_yanxuan.domain.Province;
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

    /**
     * \根据角色id获取角色对应的权限信息
     * @param id
     * @return
     */
    @Select("SELECT p.* FROM t_role r LEFT JOIN t_perssionrole pr ON r.rid = pr.rid LEFT JOIN t_perssion p ON p.fid = pr.fid WHERE r.rid = #{rid,jdbcType=INTEGER}")
    @ResultType(List.class)
    List<Province> findProvinceByRoleId(int id);

}