package com.example.study_year_design.controller;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/6  22:45
 *@description: 用户control
 */

import com.example.study_year_design.dao.EmployeeDao;
import com.example.study_year_design.dao.UserDao;
import com.example.study_year_design.mapper.UserMapper;
import com.example.study_year_design.pojo.Employee;
import com.example.study_year_design.pojo.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.Collection;
import java.util.List;

@Controller
public class UserController {


    @Autowired
    private UserMapper userMapper;

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    private UserDao userDao;


    @RequestMapping("/getUser")
    public String getUser(HttpServletRequest request, HttpServletResponse response, Model model)throws Exception{
        Object loginUser = request.getSession().getAttribute("loginUser");
        if(loginUser!=null){
            User user = userDao.selectUserByName((String) loginUser);
            Employee employee = employeeDao.getEmployeeById(user.getId());
            model.addAttribute("emp", employee);
            return "user/main";
        }
        else
            return "index";
    }



    @RequestMapping("/users")
    public String list(Model model) {
        Collection<User> users = userDao.getUserlist();
        model.addAttribute("users",users);
        return "user/list";
    }

    @GetMapping("/usersadd")
    public String toAddUserPage(Model model) {

        return "user/addUser";
    }

    @PostMapping("/usersadd")
    public String AddUser(User user) {
        //添加的操作
        System.out.println("post succeed");
        System.out.println(user.toString());
        userDao.addUser(user);
        return "redirect:/users";
    }

    //提交后台
    //前往user信息界面
    @GetMapping("/userupdate/{name}")
    public String toUpdateUser(@PathVariable("name")String  name, Model model){
        User user = userDao.selectUserByName(name);
        userDao.deleteUser(name);
        model.addAttribute("user_up", user);
        return "user/updateUser";
    }
    @PostMapping ("/userupdate")
    public String toUpdateUser(User user){
        userDao.addUser(user);
        return "redirect:/users";
    }

    @GetMapping("/DeleteUser/{name}")
    public String DeleteEmp(@PathVariable("name")String name){
        userDao.deleteUser(name);
        return "redirect:/users";
    }


    @GetMapping("/query")
    public List<User> queryUserList(){
        List<User> userList = userMapper.getUserlist();
        for (User user:userList
             ) {
            System.out.println(user);
        }
        return userList;
    }






}
