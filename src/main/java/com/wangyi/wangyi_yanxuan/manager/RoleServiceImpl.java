package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.Role;
import com.wangyi.wangyi_yanxuan.mapper.RoleMapper;
import com.wangyi.wangyi_yanxuan.service.RoleService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
@Service
public class RoleServiceImpl implements RoleService {
    @Autowired
    private RoleMapper roleMapper;
    @Override
    public List<Role> findAllRole() {
        List<Role> list = null;
        try {
            list = roleMapper.findAllRole();
        } catch (Exception e) {
            throw new RuntimeException("查询角色异常，请刷新");
        }
        return list;
    }
}
