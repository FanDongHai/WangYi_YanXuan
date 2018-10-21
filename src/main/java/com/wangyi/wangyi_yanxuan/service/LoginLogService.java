package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.vo.PageBean;

public interface LoginLogService {

    PageBean<LoginLog> findAll(int page, int limit);
}
