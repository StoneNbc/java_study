package com.example.study_year_design.dao;
/*
 *@program:medical_back
 *@author: nbc/stone
 *@Time: 2022/6/8  15:51
 *@description: userdao
 */


import com.example.study_year_design.pojo.User;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class UserDao {

    private static Map<String, User> users = null;

    private static Integer initID = 2000;

    static {

        users = new HashMap<String, User>();//用户表
        users.put("stone", new User(1001, "stone","1234"));
        users.put("tester1", new User(2001, "tester1","1234"));
        users.put("tester2", new User(2002, "tester2", "1234"));
        users.put("root", new User(001, "root", "1234"));
    }

    public Collection<User> getUserlist() {
        return users.values();
    }

    //根据id查询用户
    public User selectUserByName(String name) {
        System.out.println(name);
        System.out.println(users.get(name));
        return users.get(name);
    }

    //添加一个用户
    public void addUser(User user) {

        if(users.containsKey(user.getName())){
            updateUser(user);//用户名已存在
            users.put(user.getName(), user);

        }else if (user.getId() == null) {//id是否存在
            user.setId(users.size() + initID + 1);
        }
        users.put(user.getName(), user);

    }

    //更新一个用户
    public void updateUser(User user) {
        users.replace(user.getName(), user);
    }

    //根据id删除一个用户
    public void deleteUser(String name) {
        users.remove(name);
    }

}
