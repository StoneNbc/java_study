package com.example.study_year_design.dao;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/5/6  18:24
 *@description: 员工dao
 */

import com.example.study_year_design.pojo.Department;
import com.example.study_year_design.pojo.Employee;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

@Repository
public class EmployeeDao {
    //模拟数据
    private static Map<Integer, Employee> employees = null;
    @Autowired
    private DepartmentDao departmentDao;

    static {
        employees = new HashMap<Integer, Employee>(); //创建部门表
        employees.put(2002, new Employee(2002, "tester2", "A2602449682@qq.com", 1, new Department(101, "教学部")));
        employees.put(2001, new Employee(2001, "tester1", "B2602449682@qq.com", 1, new Department(102, "市场部")));
//        employees.put(1001, new Employee(1001, "stone", "C2602449682@qq.com", 1, new Department(103, "教研部")));
//        employees.put(001, new Employee(2004, "root", "D2602449682@qq.com", 1, new Department(104, "运营部")));
        employees.put(2005, new Employee(2005, "EE", "E2602449682@qq.com", 1, new Department(105, "开发部")));
    }

    private static Integer initId = 2000;

    public void AddEmployee(Employee employee) {
        if (employee.getId() == null) {
            employee.setId(initId+employees.size()+1);
        }
        employee.setDepartment(departmentDao.getDepartmentById(employee.getDepartment().getId()));
        employees.put(employee.getId(), employee);
    }

    //查询

    public Collection<Employee> getAll() {
        return employees.values();
    }

    public Employee getEmployeeById(Integer id) {
        return employees.get(id);
    }

    public void deleteEmployee(Integer id) {
        employees.remove(id);
    }

}
