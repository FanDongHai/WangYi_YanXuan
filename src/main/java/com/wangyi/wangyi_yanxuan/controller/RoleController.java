package com.wangyi.wangyi_yanxuan.controller;

import com.wangyi.wangyi_yanxuan.domain.Role;
import com.wangyi.wangyi_yanxuan.service.RoleService;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

@RestController
public class RoleController {
    @Autowired
    private RoleService roleService;
    R r = new R();

    @GetMapping({"/userrole.do"})
    public R findAllRole (){
        List<Role> list = null;
        try {
            list = roleService.findAllRole();
            r.setCode(200);
            r.setData(list);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }
    }


}
