package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.Commodity;

import org.apache.ibatis.annotations.*;

import java.util.List;
import java.util.Map;

public interface CommodityMapper {

  @Delete("delete from t_commodity where cid=#{cid}")
  int deleteByid(Integer cid);

  @Insert("insert into t_commodity (cname,price,intro,imgpath,gradeid) values (#{cname},#{price},#{intro},#{imgpath},#{gradeid})")
    int insert(Commodity commodity);


    @Select("select cid,cname,price,intro,imgpath,gradeid from t_commodity where cid ={cid}")
    @ResultType(Commodity.class)
    Commodity selectById(Integer cid);

    @Select("select g.*, c.cname from t_commodity as c left join t_grade as g on g.gid=c.gradeid limit #{cpage},#{size}")
    @ResultType(Commodity.class)
    List<Commodity> selectByPages(Map<String,Object> map);

    @Select("select * from t_commodity")
    @ResultType(Commodity.class)
    List<Commodity> selectAll();

    @Select("select COUNT(*) from t_commodity")
     @ResultType(int.class)
    int selectCount();

    @Update("update t_commodity set cname = #{cname},price = #{price},intro=#{intro},imgpath=#{imgpath}, gradeid=#{gradeid} where cid = #{cid}")
    public void  update(Commodity commodity);
}