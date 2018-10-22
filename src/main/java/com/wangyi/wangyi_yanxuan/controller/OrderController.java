package com.wangyi.wangyi_yanxuan.controller;

import com.wangyi.wangyi_yanxuan.domain.Order;
import com.wangyi.wangyi_yanxuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
public class OrderController {

    @Autowired
    private OrderService orderService;


    @PostMapping("/selectPage.do")
    public Map<String,Object> selectAllPage(int page,int limit){

        Map<String,Object> map = new HashMap<String, Object>();
        List<Order> list=null;
        int count = 0;
        try {
            list = orderService.selectAllPage(page,limit);
            count = orderService.countNumber();
            map.put("code",0);
            map.put("count",count);
            map.put("data",list);
            return map;
        } catch (Exception e) {
            e.printStackTrace();

            map.put("code",1);
            map.put("msg",e.getMessage());

            return map;
        }

    }



}
