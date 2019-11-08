package com.epim.controller;

import com.epim.entity.Attendance;
import com.epim.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("atten")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "get-atten-list")
    public List<Attendance> getDeptList(){
        return attendanceService.findAll();
    }

    @RequestMapping(value = "get-atten-info")
    public Attendance getDeptInfo(@RequestParam String id){
        return attendanceService.findById(id);
    }

    @RequestMapping(value = "new-atten")
    public void newDept(@RequestParam Attendance dept){
        this.attendanceService.insert(dept);
    }

    @RequestMapping(value = "modify-atten")
    public void modifyDept(@RequestParam Attendance department){
        this.attendanceService.update(department);
    }

}
