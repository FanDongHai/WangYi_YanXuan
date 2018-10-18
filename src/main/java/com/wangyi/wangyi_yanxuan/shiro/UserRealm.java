package com.wangyi.wangyi_yanxuan.shiro;

import com.wangyi.wangyi_yanxuan.service.PerssionService;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.subject.PrincipalCollection;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;


@Service
public class UserRealm extends AuthorizingRealm {
    @Autowired
    private PerssionService perssionService;
    //权限或者角色
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        //获取登录用户
//        User user = (User)SecurityUtils.getSubject().getSession().getAttribute("user");
//        //查询当前用户的权限
//        List<String> title = perssionService.queryByUid(user.getUid());
//        SimpleAuthorizationInfo info = new SimpleAuthorizationInfo();
//        info.addStringPermissions(title);
//        return info;
       return null;
    }

    //认证   登录校验
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {

        UsernamePasswordToken token = (UsernamePasswordToken)authenticationToken;
        if(token.getUsername() != null && token.getUsername().length()>0){
            return new SimpleAuthenticationInfo(token,getName(),token.getUsername());
        }
        return null;
    }
}
