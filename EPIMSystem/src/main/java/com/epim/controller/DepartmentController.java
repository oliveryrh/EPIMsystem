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

    @RequestMapping(value = "/get-dept-list", method= RequestMethod.GET)
    public DepartmentResponse getDeptList(){
        DepartmentResponse response=new DepartmentResponse();
        List<Department> departmentList=departmentService.findAll();
        if (departmentList!=null&&departmentList.size()>0){
            for (Department department:departmentList) {
                System.out.println(department.getName());
                DepartmentResponse.Department rspDept=response.append();
                BeanUtils.copyProperties(department,rspDept);
            }
        }else {
            response.setCode("1000");
            response.setMessage("failed");
        }

        response.setCode("0");
        response.setMessage("succeeded");
        return response;
    }

    @RequestMapping(value = "/get-dept-info", method= RequestMethod.GET)
    public Department getDeptInfo(@RequestBody String id){
        DepartmentResponse response=new DepartmentResponse();

        Department department = departmentService.findById(id);
        if (department!=null){
            System.out.println(department.getName());
            DepartmentResponse.Department rspDept=response.new Department();
            BeanUtils.copyProperties(department,rspDept);
            System.out.println(rspDept.getDepartmentNumber());
        }else {
            response.setCode("1000");
            response.setMessage("failed");
        }

        response.setCode("200");
        response.setMessage("succeeded");
        return department;
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
    public void deleteDept(@RequestBody String id){
        this.departmentService.delete(id);
    }
}
