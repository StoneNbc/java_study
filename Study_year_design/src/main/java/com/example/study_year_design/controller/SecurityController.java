//package com.example.study_year_design.controller;
//
//import org.springframework.context.annotation.Configuration;
//import org.springframework.security.config.annotation.authentication.builders.AuthenticationManagerBuilder;
//import org.springframework.security.config.annotation.web.builders.HttpSecurity;
//import org.springframework.security.config.annotation.web.configuration.EnableWebSecurity;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfiguration;
//import org.springframework.security.config.annotation.web.configuration.WebSecurityConfigurerAdapter;
//import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
//
///*
// *@program:Study_year_design
// *@author: nbc/stone
// *@Time: 2022/5/11  22:58
// *@description: 用户分级
// */
//@Configuration
//@EnableWebSecurity
//public class SecurityController extends WebSecurityConfigurerAdapter {
//
//    //授权
//    @Override
//    protected void configure(HttpSecurity http) throws Exception {
//        //请求授权规则
//        http.authorizeHttpRequests()
//                //页面"/" 和 全体访问权限
//                .antMatchers("/").permitAll()
//                .antMatchers("/main.html").permitAll()
//                //页面"/emp/**" （请求路径）和 normal访问权限
//                .antMatchers("/emp/**").hasRole("normal")
//                //页面"/users/**" （请求路径）和 admin访问权限
//                .antMatchers("/user/**").hasRole("normal");
//        //没有授权则返回登录界面
//        http.formLogin()
//                //跳转的页面
//                .loginPage("/index.html");
//        //开启注销功能
//        http.logout().logoutSuccessUrl("/index.html").and().csrf().disable();
//    }
//
//    //认证
//    @Override
//    protected void configure(AuthenticationManagerBuilder auth) throws Exception
//    {
//        auth.inMemoryAuthentication().passwordEncoder(new BCryptPasswordEncoder())
//                .withUser("stone").password(new BCryptPasswordEncoder().encode("1234")).roles("normal")
//                .and()
//                .withUser("root").password(new BCryptPasswordEncoder().encode("1234")).roles("admin");
//        System.out.println("认证");
//
//    }
//}
