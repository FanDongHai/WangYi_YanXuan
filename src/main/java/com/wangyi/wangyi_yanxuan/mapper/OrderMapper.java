package com.wangyi.wangyi_yanxuan.mapper;


import com.sun.org.apache.xpath.internal.operations.Or;
import com.wangyi.wangyi_yanxuan.domain.Order;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.ResultType;
import org.apache.ibatis.annotations.Select;

import java.util.List;
import java.util.Map;

public interface OrderMapper {


    @Select("select * from t_order limit #{currPage,jdbcType=INTEGER},#{limit,jdbcType=INTEGER}")
    @ResultType(Order.class)
    List<Order> selectAllPage(@Param("currPage") int currPage,@Param("limit") int limit);


    @Select("select COUNT(1) from t_order")
    @ResultType(Integer.class)
    int countNumber();
}