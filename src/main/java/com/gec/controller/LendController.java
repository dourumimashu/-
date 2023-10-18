package com.gec.controller;


import com.gec.entity.Lend;
import com.gec.entity.ResultCode;
import com.gec.service.impl.LendServiceImpl;
import com.github.pagehelper.PageInfo;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.HashMap;
import java.util.List;
import java.util.*;

@Controller
public class LendController {

    @Autowired
    LendServiceImpl lendService;

    @RequestMapping("lendListIndex")
    public String lendListIndex(){
        return "/lend/lendListIndex";
    }

    @RequestMapping("/lendListAll")
    @ResponseBody
    public Map<String,Object> getAllLend(Integer page, Integer limit){
        List<Lend> lendList =lendService.getAllLend(page, limit);
        PageInfo<Lend> pageInfo = new PageInfo<>(lendList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","获取数据成功！");
        map.put("count",pageInfo.getTotal());
        System.out.println(lendList);
        return map;
    }

    @RequestMapping("/addLendList")
    public String addLendList(){
        return "lend/addLendList";
    }


    @RequestMapping("/addLend")
    @ResponseBody
    Map<String,Object> addLend(@Param("bookId") String ids,@Param("readerId")String readerNumber,@Param("lendDate") Date lendDate,@Param("backDate") Date backDate,@Param("backType") Integer backType,@Param("exceptRemarks") String exceptRemarks){

        Date lend_date = new Date();
        Date back_date = null;
        //把日期字符串转换成日期对象
        try {
            lend_date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(lendDate));
            back_date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(backDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean result = lendService.addLend(ids,readerNumber, lend_date,back_date,backType,exceptRemarks);
        Map<String,Object> map = new HashMap<>();
        if (result == true){
            map.put("code", ResultCode.Add_OK);
        }else {
            map.put("code", ResultCode.Add_ERR);
        }
        return map;
    }

    @RequestMapping("deleteLendListByIds")
    @ResponseBody
    public Map<Object, Object> deleteLendListByIds(String ids){

        List<String>idlist = Arrays.asList(ids.split(",")) ;
        Boolean result =  lendService.deleteLendListByIds(idlist);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Delete_OK);
        }else {map.put("code",ResultCode.Delete_ERR);}
        return map;
    }

    @RequestMapping("backLendListByIds")
    @ResponseBody
    Map<String,Object> backLendListByIds(@Param("backDate") Date backDate) {


        Date back_date = new Date();
        //把日期字符串转换成日期对象
        try {
            back_date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(backDate));
//            back_date = new SimpleDateFormat("yyyy-MM-dd").parse(String.valueOf(backDate));
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean result = lendService.backLendListByIds(back_date);
        Map<String, Object> map = new HashMap<>();
        if (result == true) {
            map.put("code", ResultCode.Add_OK);
        } else {
            map.put("code", ResultCode.Add_ERR);
        }
        return map;
    }
}
