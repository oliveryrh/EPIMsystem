package com.epim.controller;

import com.epim.entity.Attendance;
import com.epim.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "get-attendance-list")
    public List<Attendance> getDeptList(){
        return attendanceService.findAll();
    }

    @RequestMapping(value = "get-attendance-info")
    public Attendance getDeptInfo(@RequestParam String id){
        return attendanceService.findById(id);
    }

    @RequestMapping(value = "new-attendance")
    public void newDept(@RequestParam Attendance dept){
        this.attendanceService.insert(dept);
    }

    @RequestMapping(value = "modify-attendance")
    public void modifyDept(@RequestParam Attendance department){
        this.attendanceService.update(department);
    }

}
