package com.example.study_year_design.controller;

import com.example.study_year_design.dao.ProjectDao;
import com.example.study_year_design.pojo.Project;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.Collection;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/9  14:35
 *@description: 项目管理跳转
 */
@Controller
public class ProjectController {

    @Autowired
    private ProjectDao projectDao;

    @RequestMapping("/projects")
    public String list(Model model) throws NullPointerException{
        Collection<Project> allProjects = projectDao.getAllProjects();
        model.addAttribute("projects", allProjects);

        return "project/project_list";
    }

    @RequestMapping("/getProject/{id}")
    public String toGetProjectPage(@PathVariable("id")Integer id, Model model) {
        //查出原来数据
        Project project = projectDao.getProjectById(id);
        model.addAttribute("projectde", project);
        return "project/proj_detail";
    }

    @GetMapping("/pro/projectadd")
    public String toAddUserPage(Model model) {
        return "project/addproject";
    }
    @PostMapping("/projectadd")
    public String AddUser(Project project) {
        //添加的操作
        System.out.println("post succeed");
        System.out.println(project.toString());
        projectDao.AddProject(project);
        return "redirect:/projects";
    }



    //提交后台

    @GetMapping("/pro/proj_update/{id}")
    public String toUpdateUser(@PathVariable("id")Integer  id, Model model){
        Project project = projectDao.getProjectById(id);
        model.addAttribute("proj_up", project);
//        projectDao.deleteProject(id);

        return "project/updateproject";
    }
    @PostMapping("/proj_update")
    public String toUpdateUser(Project project) {
        projectDao.updateProject(project);
        System.out.println(project.getText1());
        return "redirect:/projects";
    }

    @GetMapping("/pro/proj_delete/{id}")
    public String DeleteEmp(@PathVariable("id")Integer id){
        projectDao.deleteProject(id);
        return "redirect:/projects";
    }

}
