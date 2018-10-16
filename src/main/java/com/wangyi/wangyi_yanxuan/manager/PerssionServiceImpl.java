package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.mapper.PerssionMapper;
import com.wangyi.wangyi_yanxuan.service.PerssionService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class PerssionServiceImpl implements PerssionService {

    @Autowired
    private PerssionMapper perssionMapper;


    @Override
    public List<String> queryByUid(int uid) {
        return perssionMapper.selectUid(uid);
    }
}
