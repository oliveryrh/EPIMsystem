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
    public Response<User> checkLogin(@RequestParam("employeeNumber")String employeeNumber,@RequestParam("password")String password) {
        Response<User> userResponse=new Response<User>();
        User userModel=this.userService.findById(employeeNumber);
        if (userModel!=null){
            if (userModel.getPassword().equals(password)){
                userResponse.setObject(userModel);
                userResponse.setMessage("succeeded");
            }
        }else {
            userResponse.setMessage("failed");
        }
        return userResponse;
    }

    @RequestMapping(value = "/modify-password", method= RequestMethod.POST)
    @ResponseBody
    public Response<User> modifyPassWord(@Param("employeeNumber") String employeeNumber,
                                 @Param("oldPassword") String oldPassword, @Param("newPassword") String newPassword){
        Response<User> response=new Response<User>();
        User userModel=userService.findById(employeeNumber);
        if (userModel!=null){
            if (userModel.getPassword().equals(oldPassword)){
                userModel.setPassword(newPassword);
                userService.update(userModel);
                response.setMessage("succeeded");
            }else {
                response.setMessage("failed");
            }
        }

        return response;
    }

    @RequestMapping(value = "/reset-password", method= RequestMethod.POST)
    @ResponseBody
    public Response<User> resetPassword(@RequestParam("employeeNumber")String employeeNumber,@RequestParam("password")String password ){
        Response<User> response=new Response<User>();
        User user=this.userService.findById(employeeNumber);
        if (user!=null){
            user.setPassword(password);
            userService.update(user);
            response.setMessage("succeeded");
        }else {
            response.setMessage("failed");
        }

        return response;
    }
}
