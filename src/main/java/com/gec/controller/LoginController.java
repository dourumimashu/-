package com.gec.controller;


import com.gec.service.impl.AdminServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class LoginController {


    @Autowired
    AdminServiceImpl adminService;
    @RequestMapping("/toLogin")
    public String toLogin(){
        return "login";
    }

    @RequestMapping("/login")
    public String login(String username, String password, Integer adminType, Model model){
        boolean result = adminService.checkLogin(username, password, adminType);
        if (result==true){
            return "index";
        }else {
            model.addAttribute("msg","账号或密码错误,请重新输入");
            return "login";
        }
    }
}


