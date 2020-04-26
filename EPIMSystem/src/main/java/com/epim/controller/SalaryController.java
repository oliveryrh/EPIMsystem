package com.epim.controller;

import com.epim.entity.Employee;
import com.epim.entity.Salary;
import com.epim.service.AttendanceService;
import com.epim.service.EmployeeService;
import com.epim.service.SalaryService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.awt.image.ShortLookupTable;
import java.beans.SimpleBeanInfo;
import java.math.BigDecimal;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.regex.Pattern;

@Controller
@RequestMapping(value = "/salary")
public class SalaryController {
    @Autowired
    SalaryService salaryService;
    @Autowired
    EmployeeService employeeService;
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/get-employee-salary-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Salary> getEmployeeSalaryList(){
        return this.salaryService.findAll();
    }

    @RequestMapping(value = "/get-user-salary-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Salary> getUserSalaryList(@RequestParam("employeeNumber") String id){
        List<Salary> salaryList=this.salaryService.findAll();
        List<Salary> salaries=new ArrayList<Salary>();
        for (Salary salary:salaryList){
            if (salary.getEmployeeNumber().equals(id)){
                salaries.add(salary);
            }
        }
        return salaries;
    }

    @RequestMapping(value = "/new-salary",method = RequestMethod.GET)
    @ResponseBody
    public String newSalary(@RequestParam("id") String id, @RequestParam("deduct") String deduct,@RequestParam("sub") String subsidy){
        Salary salary=new Salary();
        salary.setEmployeeNumber(id);
        Date month=new Date();
        SimpleDateFormat sdf=new SimpleDateFormat("yyyy-MM");
        salary.setMonth(sdf.format(month));
        salary.setDeduct(deduct);
        salary.setSubsidy(subsidy);

        Employee employee=employeeService.findById(id);
        if(employee.getBasicSalary()==null){
            return "2";
        }
        salary.setBasicSalary(employee.getBasicSalary());
        salary.setPosition(employee.getPosition());
        salary.setName(employee.getName());
        salary.setAttendanceDays("22");

        double basic=Double.parseDouble(employee.getBasicSalary());
        double de=Double.parseDouble(deduct);
        double sub=Double.parseDouble(subsidy);
        double total=de+sub+basic;
        double need=0.77*total;
        double tax=0.00;
        double insurance=0.00;
        double finalSalary=0.00;
        double fee=0.00;
        if (total<=5000){
            fee=0.00;
        }
        if(need>0&&need<=3000) {
            fee=need*0.03;
        } else if (need>3000&&need<=12000){
            fee=need*0.1-210;
        }else if (need>12000&&need<=25000){
            fee=need*0.2-1410;
        }else if (need>25000&&need<=35000){
            fee=need*0.25-2660;
        }else if (need>35000&&need<=55000){
            fee=need*0.3-4410;
        }else if(need>55000&&need<=80000){
            fee=need*0.35-7160;
        }else if (need>80000){
            fee=need*0.45-15160;
        }
        tax=fee;
        insurance=0.23*total;
        finalSalary=total-tax-insurance;

        salary.setTax(String.valueOf(new BigDecimal(tax).setScale(4,BigDecimal.ROUND_UP)));
        salary.setInsurance(String.valueOf(new BigDecimal(insurance).setScale(4,BigDecimal.ROUND_UP)));
        salary.setFinalSalary(String.valueOf(new BigDecimal(finalSalary).setScale(4,BigDecimal.ROUND_UP)));
        this.salaryService.insert(salary);
        return "1";
    }
}
