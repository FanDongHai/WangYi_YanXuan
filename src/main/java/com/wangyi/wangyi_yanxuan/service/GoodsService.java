package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.domain.Grade;

import java.util.List;

public interface GoodsService {
    boolean save (Commodity commodity);
    List<Commodity> queryByPage();
}
