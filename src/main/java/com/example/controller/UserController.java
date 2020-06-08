package com.example.controller;

import com.example.entity.User;
import com.example.mapper.UserMapper;
import com.example.service.UserService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.EnableAutoConfiguration;
import org.springframework.web.bind.annotation.*;

import javax.servlet.http.HttpServletRequest;

@RestController
@RequestMapping("/users")
public class UserController {

    @Autowired
    private UserMapper userMapper;
    @Autowired
    private UserService userService;

    @RequestMapping("getUser/{id}")
    public String GetUser(@PathVariable int id){
        return userMapper.getUserInfo(id).toString();
    }

    @RequestMapping("getName/{id}")
    public String GetName(@PathVariable int id){
        return userMapper.getUserInfo(id).getUserName() + userMapper.getUserInfo(id).getRealName();
    }

    @RequestMapping("giveNum/{id}")
    public String giveNum(@PathVariable int id){
        int max=100,min=1;
        long randomNum = System.currentTimeMillis();
        int ran3 = (int) (randomNum%(max-min)+min);
        return userMapper.getUserInfo(id).getUserName() + ran3;
    }

    @RequestMapping("loginGet/{name}/{pwd}")
    public String userLoginGet(@PathVariable String name, @PathVariable String pwd){
        return userService.userLogin(name, pwd);
    }

    @CrossOrigin(origins = "*")
    @RequestMapping(value="login", method = RequestMethod.POST)
    public String userLoginPost(HttpServletRequest request){
        System.out.println(request.getRemoteAddr());
        System.out.println(request.getRemotePort());
        String userName = request.getParameter("username");
        String userPwd = request.getParameter("password");
        return userService.userLogin(userName, userPwd);
    }

    @RequestMapping("registion/{name}/{pwd}/{realName}")
    public String userReg(@PathVariable String name, @PathVariable String pwd, @PathVariable String realName){
        return userService.userReg(name, pwd, realName);
    }

    @RequestMapping("changePwd/{name}/{pwd}/{newPwd}")
    public String changePwd(@PathVariable String name, @PathVariable String pwd, @PathVariable String newPwd){
        return userService.changePwd(name, pwd, newPwd);
    }
}
