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
    public List<Attendance> getAttendanceList(){
        return attendanceService.findAll();
    }

    @RequestMapping(value = "get-attendance-info")
    public Attendance getAttendanceInfo(@RequestParam String id){
        return attendanceService.findById(id);
    }

    @RequestMapping(value = "new-attendance")
    public void newAttendance(@RequestParam Attendance attendance){
        this.attendanceService.insert(attendance);
    }

    @RequestMapping(value = "modify-attendance")
    public void modifyAttendance(@RequestParam Attendance attendance){
        this.attendanceService.update(attendance);
    }

}
