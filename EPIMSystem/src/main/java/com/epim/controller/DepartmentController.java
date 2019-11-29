package com.epim.controller;

import com.epim.datatransport.Response;
import com.epim.datatransport.response.DepartmentResponse;
import com.epim.entity.Department;
import com.epim.service.DepartmentService;
import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@Controller
@RequestMapping("/dept")
public class DepartmentController {
    @Autowired
    DepartmentService departmentService;

    @RequestMapping(value = "/get-dept-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Department> getDeptList(){
        return this.departmentService.findAll();
    }

    @RequestMapping(value = "/get-dept-info", method= RequestMethod.GET)
    @ResponseBody
    public Department getDeptInfo(@RequestParam("deptNumber") String id){
//        Response<Department> response=new Response<Department>();
//
//        Department department = departmentService.findById(id);
//        if (department!=null){
//            System.out.println(department.getName());
//            response.setMessage("succeeded");
//            response.setObject(department);
//        }else {
//            response.setMessage("failed");
//        }
//
//        return response;

        return this.departmentService.findById(id);
    }

    @RequestMapping(value = "/new-dept",method = RequestMethod.POST)
    public void newDept(@RequestBody Department dept){
        this.departmentService.insert(dept);
    }

    @RequestMapping(value = "/modify-dept",method = RequestMethod.POST)
    public void modifyDept(@RequestBody Department department){
        this.departmentService.update(department);
    }

    @RequestMapping(value = "/delete-dept",method = RequestMethod.POST)
    public void deleteDept(@RequestParam("deptNumber") String id){
        this.departmentService.delete(id);
    }
}
