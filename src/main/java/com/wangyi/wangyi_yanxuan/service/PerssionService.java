package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.Perssion;
import com.wangyi.wangyi_yanxuan.vo.R;

import java.util.List;

public interface PerssionService {
    /**
     * 根据id删除Perssion对象
     * @param id
     * @return
     */
    public R deletePerssionById(int id);

    /**
     * 展示所有资源
     * @return
     */
    public List<Perssion> findAllPerssion();

    /**
     * 增加一个资源
     * @param perssion
     * @return
     */
    public R addPerssion(Perssion perssion);

}
