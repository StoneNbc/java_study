package com.example.study_year_design.mapper;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/16  23:48
 *@description: 用户mapper
 */


import com.example.study_year_design.pojo.User;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

//注解这是一个mapper类

@Repository
@Mapper
public interface UserMapper {
    //查询全部用户
    List<User> getUserlist();
    //根据id查询用户
    User selectUserById(Integer id);
    //根据name查询用户
    User selectUserByName(String name);
    //根据pwd查用户
    //User selectUserByPwd(String pwd);
    //添加一个用户
    int addUser(User user);
    //更新一个用户
    int updateUser(User user);
    //根据id删除一个用户
    int deleteUser(Integer id);

}
