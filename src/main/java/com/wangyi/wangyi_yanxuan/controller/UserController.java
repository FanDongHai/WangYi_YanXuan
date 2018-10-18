package com.wangyi.wangyi_yanxuan.controller;


import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.domain.User;
import com.wangyi.wangyi_yanxuan.service.UserService;
import com.wangyi.wangyi_yanxuan.utils.ResultUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //后台登录
    @PostMapping("/userlogin.do")
    public R login(String no, String password, HttpServletRequest request){
        User user=userService.login(no, password);
        if(user!=null){

            LoginLog loginLog=new LoginLog();
            loginLog.setIp(request.getRemoteAddr());
            loginLog.setUid(user.getUid());
            userService.saveLog(loginLog);

//            // 设置token标记,存储账号和密码
//            UsernamePasswordToken token=new UsernamePasswordToken(no,password);
//            Subject subject = SecurityUtils.getSubject();
//
//            subject.login(token);
//            subject.getSession().setAttribute("user",user);


            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }
    }
    //注册
    @PostMapping("userregister.do")
    public R save(User user){
        return userService.save(user);
    }


}
