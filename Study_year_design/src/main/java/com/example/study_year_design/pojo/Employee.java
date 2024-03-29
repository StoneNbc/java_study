package com.example.study_year_design.pojo;

import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/6  18:06
 *@description: 员工表
 */
@Data
@NoArgsConstructor
public class Employee {

    private Integer id;
    private String lastName;
    private String email;
    private Integer gender;/*0:女 1:男*/
    private Department department;
    private Date birth;


    public Employee(Integer id, String lastName, String email, Integer gender, Department department) {
        this.id = id;
        this.lastName = lastName;
        this.email = email;
        this.gender = gender;
        this.department = department;
        //默认日期
        this.birth = new Date();
    }

}
