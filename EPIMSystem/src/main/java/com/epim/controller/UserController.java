package com.epim.controller;

import com.epim.datatransport.Request;
import com.epim.datatransport.Response;
import com.epim.datatransport.request.UserRequest;
import com.epim.entity.User;
import com.epim.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.io.Serializable;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @RequestMapping(value = "/check-login", method= RequestMethod.GET)
    @ResponseBody
    public User checkLogin(@RequestParam("employeeNumber")String employeeNumber,@RequestParam("password")String password) {
        User userModel=this.userService.findById(employeeNumber);
        return userModel;
    }

    @RequestMapping(value = "/modify-password", method= RequestMethod.GET)
    @ResponseBody
    public String modifyPassWord(@RequestParam("id") String employeeNumber,@RequestParam("newPwd") String newPassword){
        User userModel=userService.findById(employeeNumber);
        if (userModel!=null){
            userModel.setPassword(newPassword);
            userService.update(userModel);
            return "1";
        }
        else {
            return "2";
        }
    }

    @RequestMapping(value = "/reset-password", method= RequestMethod.GET)
    @ResponseBody
    public String resetPassword(@RequestParam("id")String employeeNumber,@RequestParam("pwd")String password ){
        User user=this.userService.findById(employeeNumber);
        if (user!=null){
            user.setPassword(password);
            userService.update(user);
            return "1";
        }else {
            return "2";
        }
    }
}
