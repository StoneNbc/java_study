package com.example.study_year_design.dao;

import com.example.study_year_design.pojo.Context;
import com.example.study_year_design.pojo.Employee;
import org.springframework.stereotype.Repository;

import java.util.Collection;
import java.util.HashMap;
import java.util.Map;

/*
 *@program:Study_year_design
 *@author: nbc/stone
 *@Time: 2022/6/18  21:55
 *@description: context
 */
@Repository
public class ContextDao {
    private static Map<Employee, Context> contexts = new HashMap<Employee, Context>();


    //获取所有部门信息
    public Collection<Context> getContexts(){
        return contexts.values();
    }
}
