package com.example.study_year_design.controller;

import com.example.study_year_design.dao.UserDao;
import com.example.study_year_design.mapper.UserMapper;
import org.apache.shiro.SecurityUtils;
import org.apache.shiro.authc.IncorrectCredentialsException;
import org.apache.shiro.authc.UnknownAccountException;
import org.apache.shiro.authc.UsernamePasswordToken;
import org.apache.shiro.subject.Subject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import javax.servlet.http.HttpSession;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/7  17:51
 *@description: 登录控制
 */
@Controller
public class LoginController {


    @Autowired
    private UserDao userDao;
    @Autowired
    private UserMapper userMapper;

    //登录控制
//    @RequestMapping("/login")
//    public String login(@RequestParam("username") String username, @RequestParam("password") String password, Model model, HttpSession session) {
//
//        User user_rec = userDao.selectUserByName(username);
//        System.out.println(user_rec);
//        if(user_rec== null){
//            model.addAttribute("msg", "用户名不存在");
//            return "index";
//        }else if (!StringUtils.isEmpty(username) && user_rec.getPwd().equals(password)) {
//            session.setAttribute("loginUser",username);
//            return "redirect:/main.html";
//        } else {
//            model.addAttribute("msg", "用户名密码错误");
//            return "index";
//        }
//    }
    @RequestMapping("/login")
    public String login(String username, String password, Model model) {
        //获取用户
        Subject subject = SecurityUtils.getSubject();
        //封装用户的登录数据
        UsernamePasswordToken token = new UsernamePasswordToken(username, password);

        try {
            subject.login(token);//执行登录方法
            System.out.println(token.getUsername());
//            session.setAttribute("loginUser",username);
            return "redirect:/main.html";
        } catch (UnknownAccountException e) {
            model.addAttribute("msg", "用户名不存在");
            return "index";
        } catch (IncorrectCredentialsException e) {
            model.addAttribute("msg", "密码错误");
            return "index";
        }

    }

    @RequestMapping("/unAuthorized")
    @ResponseBody
    public String unAuthorized() {

        return "无权限访问";
    }


    //注销
    @RequestMapping("/logout")
    public String logout(HttpSession session){
//        session.invalidate();
        return "redirect:/index.html";
    }
}
