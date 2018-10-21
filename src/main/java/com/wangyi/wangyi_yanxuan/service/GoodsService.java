package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.Commodity;

import java.util.List;
import java.util.Map;

public interface GoodsService {
     public  boolean save (Commodity commodity);
     public  List<Commodity> findByPage(int page,int limit) ;
     public  void  updateCommodityById(Commodity commodity);
     public  void  delete(int cid);
     public  List<Commodity> selectCommodity( );
     public int countToCommodity();
}
