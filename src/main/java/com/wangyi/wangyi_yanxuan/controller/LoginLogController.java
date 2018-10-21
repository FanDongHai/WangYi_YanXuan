package com.wangyi.wangyi_yanxuan.controller;

import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.service.LoginLogService;
import com.wangyi.wangyi_yanxuan.vo.PageBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
public class LoginLogController {

    @Autowired
    private LoginLogService service;

    @GetMapping("/findAll.do")
    public Map<String, Object> findAll(int page, int limit) {
        Map<String, Object> map = new HashMap<>();
        PageBean<LoginLog> pageInfo = service.findAll(page, limit);

        map.put("code", 200);
        map.put("msg", "");
        map.put("count", pageInfo.getCount());
        map.put("data", pageInfo.getPageInfos());

        return map;
    }
}
