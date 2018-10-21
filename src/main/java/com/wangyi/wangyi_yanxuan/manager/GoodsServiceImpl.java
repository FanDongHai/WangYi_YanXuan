package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.Commodity;
import com.wangyi.wangyi_yanxuan.mapper.CommodityMapper;
import com.wangyi.wangyi_yanxuan.service.GoodsService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Service
public class GoodsServiceImpl implements GoodsService {

    @Autowired
    private CommodityMapper mapper;


    @Override
    public boolean save(Commodity commodity) {
        if (null == commodity) {
            throw new RuntimeException("错");
        }  try {
                mapper.insert(commodity);
            } catch (Exception e) {
                e.printStackTrace();
            }
        return false;
    }

    @Override
    public List<Commodity> findByPage(int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        Map<String, Object> result = new HashMap<>();
        int cpage = (page-1)*limit;
        map.put("cpage", cpage);
        map.put("size", limit);


        List<Commodity> commodities =mapper.selectByPages(map);
        int i = mapper.selectCount();
        result.put("data", commodities);
        result.put("count", i);
        return  commodities;
    }


    @Override
    public void updateCommodityById(Commodity commodity) {
        if (null == commodity) {
            throw new RuntimeException("hah");
        }
        if (null == commodity.getCid()) {
            throw new RuntimeException("xixi");
        }
        mapper.update(commodity);

    }



    @Override
    public void delete(int cid) {
            mapper.deleteByid(cid);
    }

    @Override
    public List<Commodity> selectCommodity() {
        List<Commodity> list = null;
        return list = mapper.selectAll();

    }

    @Override
    public int countToCommodity() {
        return mapper.selectCount();
    }


}
