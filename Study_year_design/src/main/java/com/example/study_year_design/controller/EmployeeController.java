package com.example.study_year_design.controller;

import com.example.study_year_design.dao.DepartmentDao;
import com.example.study_year_design.dao.EmployeeDao;
import com.example.study_year_design.pojo.Department;
import com.example.study_year_design.pojo.Employee;
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
 *@Time: 2022/5/7  22:00
 *@description: 员工管理
 */
@Controller
public class EmployeeController {

    @Autowired
    EmployeeDao employeeDao;
    @Autowired
    DepartmentDao departmentDao;

    @RequestMapping("/emps")
    public String list(Model model) {
        Collection<Employee> employees = employeeDao.getAll();
        model.addAttribute("emps",employees);
        return "emp/list";
    }

    //去员工添加页面
    @GetMapping("/empsadd")
    public String toAddEmpPage(Model model) {
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments_list", departments);
        return "emp/addEmp";
    }
    @PostMapping("/empsadd")
    public String AddEmp(Employee employee) {
        //添加的操作
        System.out.println("post succeed");
        System.out.println(employee.toString());
        employeeDao.AddEmployee(employee);
        return "redirect:/emps";
    }

    //去员工修改页面
    @GetMapping("/empupdate/{id}")
    public String toUpdateEmpPage(@PathVariable("id")Integer id, Model model) {
        //查出所有部门信息
        Collection<Department> departments = departmentDao.getDepartments();
        model.addAttribute("departments_list", departments);
        //查出原来数据
        Employee employeeById = employeeDao.getEmployeeById(id);
        model.addAttribute("emp_up", employeeById);
        return "emp/update";
    }
    //提交后台
    @PostMapping("/UpdateEmp")
    public  String UpdateEmp(Employee employee){
        employeeDao.AddEmployee(employee);
        return "redirect:/emps";
    }

    //删除员工
    @GetMapping("/DeleteEmp/{id}")
    public String DeleteEmp(@PathVariable("id")Integer id){
        employeeDao.deleteEmployee(id);
        return "redirect:/emps";
    }
}
