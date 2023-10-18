package com.gec.controller;

import com.gec.entity.Admin;
import com.gec.entity.Notice;
import com.gec.entity.Reader;
import com.gec.entity.ResultCode;
import com.gec.service.impl.NoticeServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.Arrays;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class NoticeController {

    @Autowired
    NoticeServiceImpl noticeService;
    @RequestMapping("noticeIndexOfBack")
    public String noticeIndexOfBack(){
        return "/notice/noticeIndexOfBack";
    }


    @RequestMapping("/noticeAll")
    @ResponseBody
    public Map<String, Object> noticeAll(Integer page, Integer limit){

        List<Notice>allNotice=noticeService.getAllNotice2(page,limit);

        PageInfo<Notice> pageInfo = new PageInfo<>(allNotice);
        Map<String,Object> map =new HashMap<>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","获取成功！");
        map.put("count",pageInfo.getTotal());
        return map;
    }
    @RequestMapping("/noticeAdd")
    public String adminAdd(){
        return "/notice/noticeAdd";
    }

    @RequestMapping("/addNoticeSubmit")
    @ResponseBody
    public Map<Object, Object> addNoticeSubmit(Notice notice){

        boolean result =noticeService.addNoticeSubmit(notice);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Add_OK);
        }else {map.put("code",ResultCode.Add_ERR);}
        return map;
    }

    @RequestMapping("/deleteNoticeByIds")
    @ResponseBody
    public Map<Object, Object> deleteNotice(String ids){

        List<String>idlist = Arrays.asList(ids.split(",")) ;
        Boolean result =  noticeService.deleteNotice(idlist);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Delete_OK);
        }else {map.put("code",ResultCode.Delete_ERR);}
        return map;
    }

    @RequestMapping("queryNoticeById")
    public String queryNoticeInfoById(Integer id,Model model){

        Notice info=noticeService.queryNoticeInfoById(id);
        model.addAttribute("info",info);
        return "/notice/updateNotice";
    }

    @RequestMapping("searchNotice")
    @ResponseBody
    public Map<String,Object>searchNotice(String topic,Integer page,Integer limit){
        List<Notice>noticeList=noticeService.searchNotice(topic,page,limit);
        PageInfo<Notice>pageInfo=new PageInfo<>(noticeList);
        Map map =new HashMap<>();
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
