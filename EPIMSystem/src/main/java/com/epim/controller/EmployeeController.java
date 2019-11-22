package com.epim.controller;

import com.epim.entity.Employee;
import com.epim.service.EmployeeService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping(value = "employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;

    @RequestMapping(value = "get-employee-info")
    public Employee getEmployeeInfo(@RequestParam String id){
        return this.employeeService.findById(id);
    }

    @RequestMapping(value = "get-employee-list")
    public List<Employee> getEmployeeList(){
        return this.employeeService.findAll();
    }

    @RequestMapping(value = "new-employee")
    public void newEmployee(@RequestParam Employee employee){
        this.employeeService.insert(employee);
    }

    @RequestMapping(value = "modify-employee")
    public void modifyEmployee(@RequestParam Employee employee){
        this.employeeService.update(employee);
    }

    @RequestMapping(value = "delete-employee")
    public void deleteEmployee(@RequestParam String id){
        this.employeeService.delete(id);
    }
}
