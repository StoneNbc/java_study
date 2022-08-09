package com.example.study_year_design.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/16  23:40
 *@description: 用户实体类
 */
@Data
@NoArgsConstructor
public class User {

    private Integer id;
    private String name;
    private String pwd;

    public User(int id, String name, String pwd) {
        this.id = id;
        this.name = name;
        this.pwd = pwd;
    }

    public Integer getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPwd() {
        return pwd;
    }

    public void setPwd(String pwd) {
        this.pwd = pwd;
    }
}
