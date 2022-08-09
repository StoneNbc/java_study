package com.example.study_year_design.config;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/9  22:43
 *@description:
 */

import com.example.study_year_design.dao.UserDao;
import com.example.study_year_design.pojo.User;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.*;
import org.apache.shiro.authz.AuthorizationInfo;
import org.apache.shiro.authz.SimpleAuthorizationInfo;
import org.apache.shiro.realm.AuthorizingRealm;
import org.apache.shiro.session.Session;
import org.apache.shiro.subject.PrincipalCollection;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;


public class UserRealm extends AuthorizingRealm {

    @Autowired
    private UserDao userDao;

    /*授权*/
    @Override
    protected AuthorizationInfo doGetAuthorizationInfo(PrincipalCollection principalCollection) {
        System.out.println("执行授权");
        //授权
        SimpleAuthorizationInfo auth_info = new SimpleAuthorizationInfo();

//        auth_info.addStringPermission("user:add");

        //拿用户信息
        Subject subject = SecurityUtils.getSubject();
        User principalUser = (User) subject.getPrincipal();
        if (principalUser.getName() == "tester1") {
            auth_info.addStringPermission("tester1");
        }
        if (principalUser.getName() == "tester2") {
            auth_info.addStringPermission("tester2");
        }

        if(principalUser.getName() == "stone"){
            //员工管理权限
            auth_info.addStringPermission("emp:add");
            //project管理权限
            auth_info.addStringPermission("project:add");
            auth_info.addStringPermission("tester1");
            auth_info.addStringPermission("tester2");
        }
        //给用户名为root的用户授权
        if(principalUser.getName()=="root"){
            //project管理权限
            auth_info.addStringPermission("project:add");
            //用户管理权限
            auth_info.addStringPermission("user:add");
            //员工管理权限
            auth_info.addStringPermission("emp:add");

            auth_info.addStringPermission("tester1");
            auth_info.addStringPermission("tester2");
        }



        return auth_info;
    }

    /*认证*/
    @Override
    protected AuthenticationInfo doGetAuthenticationInfo(AuthenticationToken authenticationToken) throws AuthenticationException {
        System.out.println("执行认证");
        UsernamePasswordToken userToken = (UsernamePasswordToken) authenticationToken;
        User user_rec = userDao.selectUserByName(userToken.getUsername());
        if (user_rec == null) {
            return null;//UnknownAccountException 用户名不存在
        }
        Subject user_current = SecurityUtils.getSubject();
        Session session = user_current.getSession();
        //设置session
        session.setAttribute("loginUser",user_rec.getName());
        return new SimpleAuthenticationInfo(user_rec,user_rec.getPwd(),"");
    }
}
