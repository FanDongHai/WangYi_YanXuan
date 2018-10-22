package com.wangyi.wangyi_yanxuan.controller;


import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.domain.User;
import com.wangyi.wangyi_yanxuan.service.UserService;
import com.wangyi.wangyi_yanxuan.utils.ResultUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.servlet.http.HttpServletRequest;
import java.util.Date;
import java.util.List;


@RestController
public class UserController {

    @Autowired
    private UserService userService;

    //后台登录
    @PostMapping("/userlogin.do")
    public R login(String no, String password, HttpServletRequest request){
        User user=userService.login(no, password);

        if(user!=null){
            request.getSession().setAttribute("uno", no);
            // 登录成功，创建时间对象
            Date createtime = new Date();
            request.getSession().setAttribute("createtime", createtime);
            // 登录日志
            LoginLog loginLog=new LoginLog();
            loginLog.setNo(no);
            loginLog.setIp(request.getRemoteAddr());
            loginLog.setCreatetime(createtime);
            userService.saveLog(loginLog);

            return ResultUtil.setOK("登录成功");
        }else {
            return ResultUtil.setERROR("用户名或密码错误");
        }
    }
    //注册
    @PostMapping("/userregister.do")
    public R save(User user){
        return userService.save(user);
    }

    // 查询所有用户
    @PostMapping("/findAllUser.do")
    public R findAllUser() {
        R r = new R();
        List<User> list = null;
        try {
            list = userService.findAllUser();
            r.setCode(200);
            r.setData(list);
            return r;
        } catch (Exception e) {
            r.setCode(400);
            r.setMsg(e.getMessage());
            return r;
        }
    }

    // 退出
    @GetMapping("/loginOut.do")
    public R loginOut(HttpServletRequest request) {
        request.getSession().invalidate();
        return ResultUtil.setRes(200);
    }

    @PostMapping("/delete.do")
    public R deleteUser(int uid) {
        try {
            userService.deleteUser(uid);
            return ResultUtil.setOK("删除成功");
        } catch (Exception e) {
            return ResultUtil.setERROR("删除失败");
        }
    }
}
