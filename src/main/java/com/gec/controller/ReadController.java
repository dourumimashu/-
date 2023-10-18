package com.gec.controller;



import com.gec.entity.Admin;
import com.gec.entity.Reader;

import com.gec.entity.ResultCode;
import com.gec.service.impl.ReaderServiceImpl;
import com.github.pagehelper.PageInfo;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.List;
import java.util.*;

import static java.awt.SystemColor.info;

@Controller
public class ReadController {

    @Autowired
    ReaderServiceImpl readerService;

    @RequestMapping("/readerIndex")
    public String readerIndex(){
        return "/reader/readerIndex";
    }


    @RequestMapping("/readerAll")
    @ResponseBody
    public Map<String,Object> readerAll(Integer page, Integer limit){

        List<Reader> allReader=readerService.getAllReader(page,limit);

        PageInfo<Reader> pageInfo = new PageInfo<>(allReader);
        System.out.println("总共有"+pageInfo.getTotal()+"条数据");
        System.out.println("总共有"+pageInfo.getPages()+"页");
        System.out.println("当前为第"+pageInfo.getPageNum()+"页");
        Map<String,Object>map =new HashMap<>();
        map.put("data",pageInfo.getList());
        map.put("code",0);
        map.put("msg","获取成功！");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/readerAdd")
    public String readerAdd(){
        return "/reader/readerAdd";
    }

    @RequestMapping("/addReaderSubmit")
    @ResponseBody
    public Map<Object, Object> addReaderSubmit(String readerNumber,String username,String realName,String sex,String birthday,String tel,String email){

        System.out.println(birthday);

        Reader reader = new Reader();
        reader.setReaderNumber(readerNumber);
        reader.setUsername(username);
        reader.setRealName(realName);
        reader.setSex(sex);
        try {
            reader.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reader.setTel(tel);
        reader.setEmail(email);

        boolean result = readerService.addReaderSubmit(reader);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Add_OK);
        }else {map.put("code",ResultCode.Add_ERR);}
        return map;
    }

    @RequestMapping("/deleteReader")
    @ResponseBody
    public Map<Object, Object> deleteReader(String ids){

        List<String>idlist = Arrays.asList(ids.split(",")) ;
        Boolean result =  readerService.deleteReader(idlist);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Delete_OK);
        }else {map.put("code",ResultCode.Delete_ERR);}
        return map;
    }

    @RequestMapping("/queryReaderInfoById")
    public String toUpdatePwd(Integer id, Model model){

        Reader info=readerService.queryReaderInfoById(id);
        model.addAttribute("info",info);
        return "/reader/updateReader";
    }

    @RequestMapping("updateReaderSubmit")
    @ResponseBody
    public Map<Object, Object> updateReader(Integer id,String readerNumber,String username,String realName,String sex,String birthday,String tel,String email) {
        Reader reader = new Reader();
        reader.setId(id);
        reader.setReaderNumber(readerNumber);
        reader.setUsername(username);
        reader.setRealName(realName);
        reader.setSex(sex);
        try {
            reader.setBirthday(new SimpleDateFormat("yyyy-MM-dd").parse(birthday));
        } catch (ParseException e) {
            e.printStackTrace();
        }
        reader.setTel(tel);
        reader.setEmail(email);
        boolean result = readerService.updateReader(reader);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Update_OK);
        }else {map.put("code",ResultCode.Update_ERR);
            map.put("msg","修改失败请重新尝试");
        }
        return map;
    }

    @RequestMapping("searchReader")
    @ResponseBody
    public Map<String,Object>searchReader(String readerNumber,String username,String tel,Integer page ,Integer limit){
        List<Reader>readerList=readerService.searchReader(readerNumber,username,tel,page,limit);
        PageInfo<Reader>pageInfo=new PageInfo<>(readerList);
        Map map =new HashMap<>();
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
