package com.gec.controller;

import com.github.pagehelper.PageInfo;
import com.gec.entity.Type;
import com.gec.service.impl.TypeServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

@Controller
public class TypeController {
    @Autowired
    TypeServiceImpl typeService;
    @RequestMapping("/typeIndex")
    public String typeIndex(){
        return "/type/typeIndex";
    }
    @RequestMapping("/getAllType")
    @ResponseBody
    public Map<String,Object> getAllType(Integer page,Integer limit){
        List<Type> typeList = typeService.getAllType(page, limit);
        PageInfo<Type> pageInfo =  new PageInfo<>(typeList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("msg","查询数据成功！");
        map.put("count",pageInfo.getTotal());
        map.put("data",pageInfo.getList());
        return map;
    }
}
