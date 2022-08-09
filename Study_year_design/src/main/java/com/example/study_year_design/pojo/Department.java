package com.example.study_year_design.pojo;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/6  17:52
 *@description: 部门表
 */

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@Data
@AllArgsConstructor
@NoArgsConstructor
public class Department {
    private Integer id;
    private String departmentName;
}
