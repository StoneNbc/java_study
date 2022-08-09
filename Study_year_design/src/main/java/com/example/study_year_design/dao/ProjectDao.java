package com.example.study_year_design.dao;
/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/9  10:26
 *@description: project date access
 */

import com.example.study_year_design.pojo.Project;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class ProjectDao {
    private static Map<Integer, Project> projects = null;

    private static Integer initID = 1000;

    static {
        projects = new HashMap<Integer, Project>();
        projects.put(1001,new Project(1001,"年终审查"));
        projects.put(1002,new Project(1002,"开会"));
        projects.put(1003, new Project(1003, "招聘"));

    }



    public void AddProject(Project project) {
        //设置id
        if (project.getProjectId() == null) {
            project.setProjectId(initID + projects.size() + 1);
        }

        projects.put(project.getProjectId(), project);
    }

    public Collection<Project> getAllProjects() {
        return projects.values();
    }

    public Project getProjectById(Integer id) {
        return projects.get(id);
    }

    public void deleteProject(Integer id) {
        projects.remove(id);
    }

    public void updateProject(Project project) {
        projects.replace(project.getProjectId(), project);
    }


}
