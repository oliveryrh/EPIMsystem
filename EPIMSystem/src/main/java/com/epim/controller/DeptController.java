package com.epim.controller;

import com.epim.entity.Department;
import com.epim.service.DeptService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.servlet.mvc.method.annotation.JsonViewResponseBodyAdvice;

import java.util.List;

@Controller
@RequestMapping("department")
public class DeptController {
    @Autowired
    private DeptService deptService;

    @RequestMapping(value = "get-dept-list")
    public JsonViewResponseBodyAdvice getDeptList(){

        List<Department> departmentList=deptService.findAll();

        return null;
    }

    @RequestMapping(value = "get-dept-info")
    public void getDeptInfo(String id){
        Department department=deptService.findById(id);
    }
}
