package com.gec.controller;


import com.gec.entity.Notice;
import com.gec.service.impl.NoticeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;

import java.util.List;

@Controller
public class GuideController {

    @Autowired
    NoticeServiceImpl noticeService;
    @RequestMapping("/welcome")
    public String welcome(Model model){

        List<Notice> allNotice = noticeService.getAllNotice();
        model.addAttribute("allNotice",allNotice);
        return "welcome";
    }
}
