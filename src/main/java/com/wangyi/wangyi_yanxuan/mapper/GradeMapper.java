package com.wangyi.wangyi_yanxuan.mapper;


import com.sun.org.glassfish.gmbal.ParameterNames;
import com.wangyi.wangyi_yanxuan.domain.Grade;
import org.apache.ibatis.annotations.*;

import javax.annotation.PreDestroy;
import java.util.List;
import java.util.Map;

public interface GradeMapper {
    //按id 删除
    @Delete("DELETE from t_grade where gid=#{gid,jdbcType=INTEGER}")
    void deleteByPrimaryKey(Integer gid);
    @Select("select g.grade from t_grade g where g.gid=#{gid,jdbcType=INTEGER}")
    @ResultType(Integer.class)
    int selectdj(Integer gid);
    //查询上级下方是否包含下级
    @Select("select COUNT(DISTINCT r.parentid)or COUNT(DISTINCT r.kindid) from t_grade g LEFT JOIN t_grade r on g.gid=r.parentid or r.kindid where g.gid=#{gid,jdbcType=INTEGER}")
    @ResultType(Integer.class)
    int selectByAll( Integer gid);
    //查询三级是否有对应的数据
    @Select("select COUNT(DISTINCT c.cname) from t_grade g INNER JOIN t_commodity c on g.gid=c.gradeid where g.gid=#{gid,jdbcType=INTEGER}")
    @ResultType(Integer.class)
    int selectComAll(Integer gid);

    //查询所有分页
    @Select("select * from t_grade limit #{currPage,jdbcType=INTEGER},#{limit,jdbcType=INTEGER}")
    @ResultType(Grade.class)
    List<Grade> selectAllPage(@Param("currPage") int currpage ,@Param("limit") int limit);
    //查询总数
    @Select("select COUNT(1) from t_grade")
   @ResultType(Integer.class)
    int conutTologin();

    //按id修改
    @Update("UPDATE t_grade set gradename=#{gradename} where gid=#{gid}")
    void updateByPrimaryKey(Grade grade);

    //添加时查询等级
    @Select("select gid,gradename from t_grade where grade=#{grade,jdbcType=INTEGER}")
    @ResultType(Grade.class)
    List<Grade> selectNumber(int grade);

    //商品种类添加操作
   @Insert("insert into t_grade(gradename,grade,parentid,kindid) values(#{gradename,jdbcType=VARCHAR}, #{grade,jdbcType=INTEGER}, #{parentid,jdbcType=INTEGER}, #{kindid,jdbcType=INTEGER})")
    void insertGrade(Grade grade);


    //模糊搜索
    @Select("select * from t_grade where gradename like CONCAT('%',#{gradename,jdbcType=VARCHAR},'%')")
    @ResultType(Grade.class)
    List<Grade> countNumber(String gradename);


}