package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.Order;

import java.util.List;
import java.util.Map;

public interface OrderService {

    List<Order> selectAllPage(int page, int linit);

    int countNumber();
}
