package com.epim.controller;

import com.epim.entity.User;
import com.epim.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("check-login")
    @ResponseBody
    public String findById(@Param("userId") String employeeNumber,@Param("password")String passWord) {
        User userModel=this.userService.findById(employeeNumber);
        if (userModel!=null){
            if (userModel.getPassword().equals(passWord)){
                return userModel.getPower();
            }else {
                return "wrong-password";
            }
        }else {
            return "wrong-id";
        }
        //return this.userService.findById(employeeNumber);
    }

    @RequestMapping(value = "modify-password")
    @ResponseBody
    public String modifyPassWord(@Param("employeeNumber") String employeeNumber,@Param("oldpassword") String oldpassword,
                                  @Param("newpassword") String newpassword){
        User userModel=userService.findById(employeeNumber);
        if (userModel!=null){
            if (userModel.getPassword().equals(oldpassword)){
                userModel.setPassword(newpassword);
                userService.update(userModel);
                return "succeeded";
            }else {
                return "failed";
            }
        }else {
            return "done";
        }
    }

    @RequestMapping(value = "reset-password")
    @ResponseBody
    public String resetPassword(){
        return null;
    }
}
