package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.mapper.CommodityMapper;
import com.wangyi.wangyi_yanxuan.service.GoodsService;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class GoodsServiceImpl implements GoodsService {

    private CommodityMapper mapper;
    @Override
    public boolean save(Commodity commodity) {
        return  mapper.insert(commodity)>0;
    }

    @Override
    public List<Commodity> queryByPage() {
       List<Commodity> commodities = mapper.selectAll();
        return commodities;
    }
}
