package com.epim.controller;

import com.epim.datatransport.Response;
import com.epim.datatransport.response.DepartmentResponse;
import com.epim.entity.Department;
import com.epim.service.DepartmentService;
import org.apache.ibatis.annotations.Param;
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
    public Department getDeptInfo(@RequestParam("deptNum") String id){
        return this.departmentService.findById(id);
    }

    @RequestMapping(value = "/new-dept",method = RequestMethod.GET)
    @ResponseBody
    public String newDept(@RequestParam("id") String deptNum,@RequestParam("name") String name,@RequestParam("manager") String manager,
                          @RequestParam("tele") String tele, @RequestParam("address") String address,@RequestParam("notes") String notes){
        Department department=this.departmentService.findById(deptNum);
        if (department!=null){
            return "2";
        }else {
            Department dept=new Department();
            dept.setDepartmentNumber(deptNum);
            dept.setName(name);
            dept.setManager(manager);
            dept.setTelephone(tele);
            dept.setAddress(address);
            dept.setNotes(notes);
            this.departmentService.insert(dept);
            return "1";
        }
    }

    @RequestMapping(value = "/modify-dept",method = RequestMethod.GET)
    @ResponseBody
    public String modifyDept(@RequestParam("id") String deptNum,@RequestParam("name") String name,@RequestParam("manager") String manager,
                             @RequestParam("tele") String tele, @RequestParam("address") String address,@RequestParam("notes") String notes){
        Department department=this.departmentService.findById(deptNum);
        if (department!=null){
            department.setDepartmentNumber(deptNum);
            department.setName(name);
            department.setManager(manager);
            department.setTelephone(tele);
            department.setAddress(address);
            department.setNotes(notes);
            this.departmentService.update(department);
            return "1";
        }else {
            return "2";
        }
    }

    @RequestMapping(value = "/delete-dept",method = RequestMethod.GET)
    @ResponseBody
    public String deleteDept(@RequestParam("deptNumber") String id){
        Department department=this.departmentService.findById(id);
        if (department!=null){
            this.departmentService.delete(id);
            return "1";
        }else {
            return "2";
        }
    }
}
