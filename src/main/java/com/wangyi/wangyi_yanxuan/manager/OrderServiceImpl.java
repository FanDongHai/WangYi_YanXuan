package com.wangyi.wangyi_yanxuan.manager;

import com.sun.org.apache.xpath.internal.operations.Or;
import com.wangyi.wangyi_yanxuan.domain.Order;
import com.wangyi.wangyi_yanxuan.mapper.OrderMapper;
import com.wangyi.wangyi_yanxuan.service.OrderService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class OrderServiceImpl implements OrderService {

    @Autowired
    private OrderMapper orderMapper;

    @Override
    public List<Order> selectAllPage(int page, int limit) {


    int currPage = (page-1)*limit;

    List<Order> list = null;
        try {
            list = orderMapper.selectAllPage(currPage,limit);

        } catch (Exception e) {
            e.printStackTrace();
        }
        return list;


    }

    @Override
    public int countNumber() {
        int i = 0;
        try {
           i = orderMapper.countNumber();
        } catch (Exception e) {
            e.printStackTrace();
        }
        return i;
    }
}
