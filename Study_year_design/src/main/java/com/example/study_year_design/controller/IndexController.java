package com.example.study_year_design.controller;

//import com.example.study_year_design.config.LoginHandlerInterceptor;

import com.example.study_year_design.config.MylocaleResolver;
import org.springframework.context.annotation.Bean;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.LocaleResolver;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/7  0:09
 *@description: 首页控制
 */
@Controller
public class IndexController implements WebMvcConfigurer {
    @RequestMapping({"/","/index.html","/toLogin"})/*登录页面*/
    public String index() {
        return "index";
    }

    @RequestMapping("/main.html")/*主页*/
    public String dashboard() {
        return "dashboard";
    }

    @Bean
    public LocaleResolver localeResolver() {
        return new MylocaleResolver();
    }

//    @Override
//    public void addInterceptors(InterceptorRegistry registry) {
//        registry.addInterceptor(new LoginHandlerInterceptor())
//                /*对所有请求过滤*/
//                .addPathPatterns("/**")
//                /*不过滤的资源*/
//                .excludePathPatterns("/index.html", "/","/error/**", "/login/**","/css/**","/js/**","/img/**","/main.html","/dashboard");
//    }
}
