package com.epim.controller;

import com.alibaba.fastjson.JSONArray;
import com.alibaba.fastjson.JSONObject;
import com.epim.entity.Department;
import com.epim.service.DepartmentService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/get-dept-list")
    public List<Department> getDeptList(){
        return departmentService.findAll();
    }

    @RequestMapping(value = "get-dept-info")
    public Department getDeptInfo(@RequestParam String id){
        return departmentService.findById(id);
    }

    @RequestMapping(value = "new-dept")
    public void newDept(@RequestParam Department dept){
        this.departmentService.insert(dept);
    }

    @RequestMapping(value = "modify-dept")
    public void modifyDept(@RequestParam Department department){
        this.departmentService.update(department);
    }

    @RequestMapping(value = "delete-dept")
    public void deleteDept(@RequestParam String id){
        this.departmentService.delete(id);
    }
}
