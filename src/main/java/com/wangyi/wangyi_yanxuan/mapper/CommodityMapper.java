package com.wangyi.wangyi_yanxuan.mapper;


import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.vo.Query;
import org.apache.ibatis.annotations.Insert;
import org.apache.ibatis.annotations.Options;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface CommodityMapper {
    int deleteByPrimaryKey(Integer cid);

    @Insert(" insert into t_commodity (cid, cname, price, intro, imgpath, gradeid ) values (#{cid}, #{cname}, #{price},#{intro}, #{imgpath}, #{gradeid} ")
   @Options(useGeneratedKeys = true,keyProperty = "id")
    int insert(Commodity record);


    @Select("select cid,cname,price,intro,imgpath,gradeid from t_commodity where cid ={cid}")
    @ResultType(Commodity.class)
    Commodity selectById(Integer cid);

    @Select("select g.*, c.cname from t_commodity as c left join t_grade as g on g.gid=c.gradeid limit #{index},#{count} ")
    @ResultType(Commodity.class)
    List<Commodity> selectByPages(Query query);

    @Select("select g.*, c.cname from t_commodity as c left join t_grade as g on g.gid=c.gradeid\n")
    @ResultType(Commodity.class)
    List<Commodity> selectAll();

    @Select("select COUNT(*) from t_goods")
     @ResultType(Long.class)
    Long selectCount();
}