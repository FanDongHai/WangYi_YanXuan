package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.Perssion;
import com.wangyi.wangyi_yanxuan.mapper.PerssionMapper;
import com.wangyi.wangyi_yanxuan.service.PerssionService;
import com.wangyi.wangyi_yanxuan.utils.ResultUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.util.StringUtils;

import java.util.List;
@Service
public class PerssionServiceImpl implements PerssionService {
    @Autowired
    private PerssionMapper perssionMapper;

    @Override
    public List<String> queryByUid(int uid) {
        return perssionMapper.queryByUid(uid);
    }

    @Override
    public R deletePerssionById(int id) {
        if (Integer.toString(id) == "") {
            throw new RuntimeException("请选择需要删除的权限");
        }
        try {
            return ResultUtil.setRes(perssionMapper.deleteById(id));
        } catch (Exception e) {
            return ResultUtil.setERROR("删除失败！");
        }
    }

    @Override
    public List<Perssion> findAllPerssion() {
        List<Perssion> list = null;
        try {
            list = perssionMapper.findAllPerssion();
        } catch (Exception e) {
            throw new RuntimeException("查询权限异常");
        }
        return list;
    }

    @Override
    public R addPerssion(Perssion perssion) {
        if (perssion == null) {
            throw new RuntimeException("添加信息为空，请重新填写");
        }
        if (StringUtils.isEmpty(perssion.getTitle())) {
            throw new RuntimeException("权限名称不能为空，请重新填写");
        }
        return ResultUtil.setRes(perssionMapper.insert(perssion));

    }
}