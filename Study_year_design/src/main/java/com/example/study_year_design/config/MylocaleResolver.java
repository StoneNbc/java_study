package com.example.study_year_design.config;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/7  17:33
 *@description: 语言解析器
 */

import org.springframework.web.servlet.LocaleResolver;
import org.thymeleaf.util.StringUtils;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Locale;

public class MylocaleResolver implements LocaleResolver {
    //解析请求
    @Override
    public Locale resolveLocale(HttpServletRequest request) {
        String language = request.getParameter("lang");
        Locale locale = Locale.getDefault();//默认值
        if (!StringUtils.isEmpty(language)) {
            //分离参数
            String[] split = language.split("-");
            //国家 地区
            locale = new Locale(split[0], split[1]);
        }
        return locale;
    }

    @Override
    public void setLocale(HttpServletRequest request, HttpServletResponse response, Locale locale) {

    }
}
