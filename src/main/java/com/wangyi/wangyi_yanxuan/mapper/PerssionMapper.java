package com.wangyi.wangyi_yanxuan.mapper;

import com.wangyi.wangyi_yanxuan.domain.Perssion;
import org.apache.ibatis.annotations.Delete;
import org.apache.ibatis.annotations.Insert;

import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface PerssionMapper {

    @Select("select DISTINCT p.title from t_perssion p left join t_perssionrole pr on p.fid=pr.fid left join t_user u on pr.rid=u.rid where uid=#{uid}")
    @ResultType(String.class)
    List<String> queryByUid(int uid);

    @Delete("delete from t_function where fid = #{fid,jdbcType=INTEGER}")
    @ResultType(Integer.class)
    int deleteById(Integer fid);

    @Insert("insert into t_function (url, parentid, title, icon) values ( #{url,jdbcType=VARCHAR}, #{parentid,jdbcType=INTEGER}, #{title,jdbcType=VARCHAR}, #{icon,jdbcType=VARCHAR})")
    int insert(Perssion record);

    @Select("select * from t_perssion")
    @ResultType(Perssion.class)
    List<Perssion> findAllPerssion();


}
