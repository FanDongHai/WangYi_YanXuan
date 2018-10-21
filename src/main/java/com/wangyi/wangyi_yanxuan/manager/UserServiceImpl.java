package com.wangyi.wangyi_yanxuan.manager;

import com.wangyi.wangyi_yanxuan.domain.LoginLog;
import com.wangyi.wangyi_yanxuan.domain.User;
import com.wangyi.wangyi_yanxuan.mapper.LoginLogMapper;
import com.wangyi.wangyi_yanxuan.mapper.UserMapper;
import com.wangyi.wangyi_yanxuan.service.UserService;
import com.wangyi.wangyi_yanxuan.utils.PassUtil;
import com.wangyi.wangyi_yanxuan.utils.ResultUtil;
import com.wangyi.wangyi_yanxuan.vo.R;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;


@Service
public class UserServiceImpl implements UserService {
    @Autowired
    private UserMapper userMapper;
    @Autowired
    private LoginLogMapper loginLogMapper;

    @Override
    public R save(User user) {
        user.setPassword(PassUtil.md5(user.getPassword()));
        return ResultUtil.setRes(userMapper.insert(user));
    }

    @Override
    public R checkName(String no) {
        User user=userMapper.selectByName(no);
        if(user==null){
            //可用
            return ResultUtil.setOK("用户名可用");
        }else{
            return ResultUtil.setERROR("用户名不可用");
        }
    }

    @Override
    public User login(String no, String password) {
        if (no == null) {
            throw new RuntimeException("用户名不能为空");
        }
        if (password == null) {
            throw new RuntimeException("密码不能为空");
        }
        User user=userMapper.selectByName(no);

        if(user != null){
            //校验密码
            if(Objects.equals(user.getPassword(), password)){
                return user;
            }
        }
        return null;

    }

    @Override
    public void saveLog(LoginLog loginLog) {
        loginLogMapper.insert(loginLog);
    }

    @Override
    public List<User> findAllUser() {
        List<User> list = userMapper.findAll();
        return list;
    }

    @Override
    public R deleteUser(int uid) {
        return ResultUtil.setRes(userMapper.deleteUser(uid));
    }
}
