package com.example.study_year_design.pojo;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.Date;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/9  10:22
 *@description: projects
 */
@Data
@AllArgsConstructor
@NoArgsConstructor
public class Project {
    private Integer projectId;
    private String name;
    private Date date;
    private String Text1;
    private String Text2;

    public Project(Integer projectId, String name) {
        this.projectId = projectId;
        this.name = name;
        this.date = new Date();
        this.Text1 = "tester1's content";
        this.Text2 = "tester2's content";
    }

}
