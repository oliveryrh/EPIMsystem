package com.epim.controller;

import com.epim.datatransport.Request;
import com.epim.datatransport.Response;
import com.epim.entity.User;
import com.epim.service.UserService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

@Controller
@RequestMapping("/user")
public class UserController {
    @Autowired
    UserService userService;

    @PostMapping("/check-login")
    @ResponseBody
    public Response<User> findById(@RequestBody Request<User> userRequest) {
        Response<User> userResponse=new Response<User>();
        User userModel=this.userService.findById(userRequest.getObject().getEmployeeNumber());
        if (userModel!=null){
            if (userModel.getPassword().equals(userRequest.getObject().getPassword())){
                userResponse.setObject(userModel);
                userResponse.setMessage("success");
            }
        }else {
            userResponse.setMessage("wrong");
        }
        return userResponse;
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
