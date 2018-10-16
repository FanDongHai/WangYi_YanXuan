package com.wangyi.wangyi_yanxuan.mapper;


import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PerssionMapper {

    @Select("select DISTINCT p.title from t_perssion p left join t_perssionrole pr on p.fid=pr.fid left join t_user u on u.rid=pr.rid where uid=#{uid}")
    @ResultType(String.class)
    List<String> selectUid(int uid);
}