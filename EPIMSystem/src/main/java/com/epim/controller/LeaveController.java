package com.epim.controller;

import com.epim.entity.Leave;
import com.epim.service.LeaveService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import java.util.List;

@Controller
@RequestMapping("lea")
public class LeaveController {
    @Autowired
    LeaveService leaveService;

    @RequestMapping(value = "get-lea-list")
    public List<Leave> getDeptList(){
        return leaveService.findAll();
    }

    @RequestMapping(value = "get-lea-info")
    public Leave getDeptInfo(@RequestParam String id){
        return leaveService.findById(id);
    }

    @RequestMapping(value = "new-lea")
    public void newDept(@RequestParam Leave dept){
        this.leaveService.insert(dept);
    }

    @RequestMapping(value = "modify-lea")
    public void modifyDept(@RequestParam Leave department){
        this.leaveService.update(department);
    }
}
