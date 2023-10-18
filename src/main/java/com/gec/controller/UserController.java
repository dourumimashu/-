package com.gec.controller;


import com.gec.entity.User;
import com.gec.service.impl.UserServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class UserController {
    @Autowired
    UserServiceImpl userService;


    @RequestMapping("getUser")
    public String getUser(Model model){
        List<User> userList = userService.getAllUser();

        model.addAttribute(userList);
        return "userList";
    }

    @RequestMapping("/goLogin")
    public String goLogin(){
        return "login";
    }

    @RequestMapping("/goIndex")
    public String goIndex(){
        return "index";
    }
}
