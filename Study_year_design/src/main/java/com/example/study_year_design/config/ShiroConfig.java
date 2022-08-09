package com.example.study_year_design.config;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/9  22:40
 *@description:
 */

import at.pollux.thymeleaf.shiro.dialect.ShiroDialect;
import org.apache.shiro.spring.web.ShiroFilterFactoryBean;
import org.apache.shiro.web.mgt.DefaultWebSecurityManager;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;

import java.util.LinkedHashMap;
import java.util.Map;

@Configuration
public class ShiroConfig {

    //shiro filter factory bean
    @Bean
    public ShiroFilterFactoryBean getfilterFactoryBean(@Qualifier("securityManager") DefaultWebSecurityManager defaultWebSecurityManager) {
        ShiroFilterFactoryBean shiroFilterFactoryBean = new ShiroFilterFactoryBean();
        //设置安全管理器
        shiroFilterFactoryBean.setSecurityManager(defaultWebSecurityManager);
        //添加shiro内置过滤器
        /*
        * anon: 无需认证可访问
        * authc: 需要认证
        * user: 记住我功能
        * perms: 拥有对某个资源权限
        * role: 拥有某个角色权限
        * */
        Map<String,String> filterMap =new LinkedHashMap<>();
        //授权
        filterMap.put("/users", "perms[user:add]");
        filterMap.put("/pro/**", "perms[project:add]");
        filterMap.put("/emps", "perms[emp:add]");
//        filterMap.put("/users", "authc");
        filterMap.put("/projects", "authc");
        filterMap.put("/getProject", "authc");

        shiroFilterFactoryBean.setFilterChainDefinitionMap(filterMap);
        //未登录跳转
        shiroFilterFactoryBean.setLoginUrl("/toLogin");

        //未授权跳转
        shiroFilterFactoryBean.setUnauthorizedUrl("/unAuthorized");
        return shiroFilterFactoryBean;
    }

    //default webSecurity Manager
    @Bean(name = "securityManager")
    public DefaultWebSecurityManager getDefaultWebSecurityManager(@Qualifier("userRealm") UserRealm userRealm) {
        DefaultWebSecurityManager defaultWebSecurityManager = new DefaultWebSecurityManager();
        defaultWebSecurityManager.setRealm(userRealm);
        return defaultWebSecurityManager;

    }


    //realm对象
    @Bean
    public UserRealm userRealm() {
        return new UserRealm();
    }

    //整合shiro thymeleaf
    @Bean
    public ShiroDialect getShiroDialect() {
        return new ShiroDialect();
    }
}
