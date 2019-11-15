package com.epim.controller;

import com.epim.entity.Salary;
import com.epim.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
@RequestMapping(value = "salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;

    public List<Salary> getSalaryList(){
        return this.salaryService.findAll();
    }
}
