package com.epim.controller;

import com.epim.datatransport.Response;
import com.epim.entity.Attendance;
import com.epim.entity.Salary;
import com.epim.service.AttendanceService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.ServletRequestBindingException;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

@Controller
@RequestMapping("/attendance")
public class AttendanceController {
    @Autowired
    AttendanceService attendanceService;

    @RequestMapping(value = "/get-user-attendance-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> getAttendanceList(@RequestParam("employeeNumber") String id){
        List<Attendance> attendances=new ArrayList<Attendance>();
        List<Attendance> attendancesList=attendanceService.findAll();
        for (Attendance attendance:attendancesList){
            if (attendance.getEmployeeNumber().equals(id)){
                attendances.add(attendance);
            }
        }
        return attendances;
    }

    @RequestMapping(value = "/get-attendance-info",method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> getAttendanceInfo(@RequestParam("employeeNumber") String id){
        return attendanceService.findByEmployeeId(id);
    }

    @RequestMapping(value = "/get-employee-attendance-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Attendance> getAttendanceList(){
        return attendanceService.findAll();
    }

    @RequestMapping(value = "/new-attendance-in",method = RequestMethod.GET)
    @ResponseBody
    public void checkIn(@RequestParam("id") String id,@RequestParam("name") String name){
        Attendance attendance=new Attendance();
        Date start=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("kk:mm:ss");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        attendance.setEmployeeNumber(id);
        attendance.setName(name);
        String day=format.format(start);
        attendance.setDay(day);
        attendance.setStartTime(simpleDateFormat.format(start));
        this.attendanceService.insert(attendance);
    }

    @RequestMapping(value = "/new-attendance-out",method = RequestMethod.GET)
    @ResponseBody
    public String checkOut(@RequestParam("id") String id,@RequestParam("name") String name) throws ParseException {
        Date end=new Date();
        SimpleDateFormat simpleDateFormat=new SimpleDateFormat("kk:mm:ss");
        SimpleDateFormat format=new SimpleDateFormat("yyyy-MM-dd");
        DateFormat df=new SimpleDateFormat("HH-mm-ss");
        String day=format.format(end);
        List<Attendance> attendances=this.attendanceService.findByEmployeeId(id);

        Attendance attendance=null;
        for (Attendance attend:attendances){
            if (attend.getDay().equals(day)){
                attendance=attend;
            }
        }
        if (attendance != null) {
            attendance.setEndTime(simpleDateFormat.format(end));
            Date startTime=df.parse(attendance.getStartTime());

//            long diff=end.getTime()-startTime.getTime();
//            attendance.setWorkType();
            this.attendanceService.update(attendance);
            return "1";
        }else {
            return "2";
        }
    }

    @RequestMapping(value = "/modify-attendance",method = RequestMethod.GET)
    @ResponseBody
    public void modifyAttendance(@RequestParam Attendance attendance){
        this.attendanceService.update(attendance);
    }

}
