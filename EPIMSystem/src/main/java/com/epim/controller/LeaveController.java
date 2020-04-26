package com.epim.controller;

import com.epim.datatransport.Response;
import com.epim.entity.Leave;
import com.epim.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
@RequestMapping("/leave")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @RequestMapping(value = "/get-employee-lea-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Leave> getLeaveList(){
        return leaveService.findAll();
    }

    @RequestMapping(value = "/get-user-lea-list",method = RequestMethod.GET)
    @ResponseBody
    public List<Leave> getLeaveById(@RequestParam("employeeNumber") String id){
        List<Leave> leaveList=new ArrayList<Leave>();
        List<Leave> leaves=leaveService.findAll();
        for (Leave leave:leaves){
            String key=leave.getEmployeeNumber();
            if (key.equals(id)){
                leaveList.add(leave);
            }
        }
        return leaveList;
    }

    @RequestMapping(value = "/get-lea-list-status",method = RequestMethod.GET)
    @ResponseBody
    public List<Leave> getLeaveByStatus(@RequestParam("status") String status){
        List<Leave> leaveList=new ArrayList<Leave>();
        List<Leave> leaves=leaveService.findAll();
        for (Leave leave:leaves){
            String sta=leave.getStatus();
            if (sta.equals(status)){
                leaveList.add(leave);
            }
        }
        return leaveList;
    }

    @RequestMapping(value = "new-lea",method = RequestMethod.GET)
    @ResponseBody
    public void newLeave(@RequestParam("id") String id,@RequestParam("name") String name,@RequestParam("dept") String department,@RequestParam("start") String startDay,
                         @RequestParam("end") String endDay,@RequestParam("days") String days,@RequestParam("type") String type,@RequestParam("rea") String reason,@RequestParam("notes") String notes){
        Leave leave=new Leave();
        leave.setEmployeeNumber(id);
        leave.setName(name);
        leave.setDepartment(department);
        leave.setStartTime(startDay);
        leave.setEndTime(endDay);
        leave.setDays(days);
        leave.setType(type);
        leave.setReason(reason);
        leave.setStatus("n");
        leave.setNotes(notes);
        this.leaveService.insert(leave);
    }

    @RequestMapping(value = "modify-lea-status",method = RequestMethod.GET)
    @ResponseBody
    public String modifyLeaveByStatus(@RequestParam("id") String id){
        Leave leave=leaveService.find(id);
        if (leave!=null){
            leave.setStatus("y");
            this.leaveService.update(leave);
            return "1";
        }else {
            return "2";
        }
    }

    @RequestMapping(value = "modify-lea",method = RequestMethod.GET)
    @ResponseBody
    public void modifyLeave(@RequestParam("id") String id){
        Leave leave=leaveService.find(id);

    }
}
