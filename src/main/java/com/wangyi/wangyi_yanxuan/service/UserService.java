package com.wangyi.wangyi_yanxuan.service;

import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.domain.User;
import com.wangyi.wangyi_yanxuan.vo.R;

public interface UserService {

    //注册
    R save(User user);
    //校验是否存在
    R checkName(String no);
    //登录---账号是否存在临时无效
    User login(String no, String password);

    void saveLog(LoginLog loginLog);

    //List<LoginLog> findAll();

}
