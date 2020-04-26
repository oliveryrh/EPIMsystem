package com.epim.controller;

import com.epim.datatransport.Response;
import com.epim.entity.Employee;
import com.epim.entity.User;
import com.epim.service.EmployeeService;
import com.epim.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.math.BigDecimal;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.List;

@Controller
@RequestMapping(value = "/employee")
public class EmployeeController {
    @Autowired
    EmployeeService employeeService;
    @Autowired
    UserService userService;

    @RequestMapping(value = "/get-employee-info",method = RequestMethod.GET)
    @ResponseBody
    public Employee getEmployeeInfo(@RequestParam("employeeNumber") String id){
        return this.employeeService.findById(id);
    }

    @RequestMapping(value = "/get-employee-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Employee> getEmployeeList(){
        return this.employeeService.findAll();
    }

    @RequestMapping(value = "/new-employee",method = RequestMethod.GET)
    @ResponseBody
    public String newEmployee(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("pwd") String pwd,@RequestParam("gen") String gen,
                              @RequestParam("bir") String bir,@RequestParam("tele") String tele,@RequestParam("email") String email,@RequestParam("native") String na,
                              @RequestParam("edu") String edu,@RequestParam("dept") String dept,@RequestParam("notes") String notes,@RequestParam("address") String address,
                              @RequestParam("posi") String position,@RequestParam("power") String power,@RequestParam("basic") String basic){

        Employee employee=new Employee();
        employee.setEmployeeNumber(id);
        employee.setName(name);
        employee.setPassword(pwd);
        employee.setGender(gen);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setEducation(edu);
        employee.setEmail(email);
        employee.setTelephone(tele);
        employee.setBirthday(bir);
        employee.setDepartmentNumber(dept);
        employee.setNativeLand(na);
        employee.setNotes(notes);
        employee.setPower(power);
        employee.setBasicSalary(String.valueOf(new BigDecimal(Double.parseDouble(basic)).setScale(4,BigDecimal.ROUND_UP)));
        Date inTime=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("yyyy-MM-dd");
        employee.setInTime(simpleDateFormat.format(inTime));

        User user=new User();
        user.setEmployeeNumber(id);
        user.setName(name);
        user.setPassword(pwd);
        user.setPower(power);
        this.employeeService.insert(employee);

        this.userService.insert(user);
        return "1";
    }

    @RequestMapping(value = "/modify-employee",method = RequestMethod.GET)
    @ResponseBody
    public void modifyEmployee(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("gen") String gen,
                               @RequestParam("bir") String bir,@RequestParam("tele") String tele,@RequestParam("email") String email,@RequestParam("native") String na,
                               @RequestParam("edu") String edu,@RequestParam("dept") String dept,@RequestParam("notes") String notes,@RequestParam("address") String address,
                               @RequestParam("posi") String position,@RequestParam("power") String power){

        Employee employee=this.employeeService.findById(id);
        employee.setEmployeeNumber(id);
        employee.setName(name);
        employee.setGender(gen);
        employee.setAddress(address);
        employee.setPosition(position);
        employee.setEducation(edu);
        employee.setEmail(email);
        employee.setTelephone(tele);
        employee.setBirthday(bir);
        employee.setDepartmentNumber(dept);
        employee.setNativeLand(na);
        employee.setNotes(notes);
        employee.setPower(power);

        User user=this.userService.findById(id);
        user.setName(name);
        user.setPower(power);
        this.employeeService.update(employee);
    }

    @RequestMapping(value = "/modify-user-info",method = RequestMethod.GET)
    @ResponseBody
    public void modifyUserInfo(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("gen") String gen,
                               @RequestParam("bir") String bir,@RequestParam("tele") String tele,@RequestParam("email") String email,
                               @RequestParam("native") String na, @RequestParam("edu") String edu,
                               @RequestParam("notes") String notes,@RequestParam("address") String address){

        Employee employee=this.employeeService.findById(id);
        employee.setEmployeeNumber(id);
        employee.setName(name);
        employee.setGender(gen);
        employee.setAddress(address);
        employee.setEducation(edu);
        employee.setEmail(email);
        employee.setTelephone(tele);
        employee.setBirthday(bir);
        employee.setNativeLand(na);
        employee.setNotes(notes);

        User user=this.userService.findById(id);
        user.setName(name);
        this.employeeService.update(employee);
    }

    @RequestMapping(value = "/delete-employee")
    @ResponseBody
    public void deleteEmployee(@RequestParam("id") String id){
        this.employeeService.delete(id);
    }
}
