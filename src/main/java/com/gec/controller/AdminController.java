package com.gec.controller;


import com.gec.entity.Admin;
import com.gec.entity.ResultCode;
import com.gec.service.impl.AdminServiceImpl;
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
public class AdminController {

    @Autowired
    AdminServiceImpl adminService;

    @RequestMapping("/adminIndex")
    public String adminIndex(){
        return "/admin/adminIndex";
    }


    /**
     data code msg count

     开启分页后
     page limit
     **/
    @RequestMapping("/getAllAdmin")
    @ResponseBody
    public Map<String,Object> getAllAdmin(Integer page,Integer limit){

        List<Admin>allAdmin=adminService.getAllAdmin(page,limit);

        PageInfo<Admin>pageInfo = new PageInfo<>(allAdmin);
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

    @RequestMapping("/adminAdd")
    public String adminAdd(){
        return "/admin/adminAdd";
    }



    @RequestMapping("/addAdminSubmit")
    @ResponseBody
    public Map<Object, Object> addAdminSubmit(Admin admin){

            boolean result = adminService.addAdminSubmit(admin);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Add_OK);
        }else {map.put("code",ResultCode.Add_ERR);}
        return map;
    }

    @RequestMapping("/deleteAdminByIds")
    @ResponseBody
    public Map<Object, Object> deleteAdminByIds(Integer ids){
        Boolean result =  adminService.deleteAdminByIds(ids);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Delete_OK);
        }else {map.put("code",ResultCode.Delete_ERR);}
        return map;
    }

    @RequestMapping("/deleteAdmin")
    @ResponseBody
    public Map<Object, Object> deleteAdmin(String ids){

    List<String>idlist = Arrays.asList(ids.split(",")) ;
        Boolean result =  adminService.deleteAdmin(idlist);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Delete_OK);
        }else {map.put("code",ResultCode.Delete_ERR);}
        return map;
    }

    @RequestMapping("/toUpdatePwd")
    public String toUpdatePwd(){
        return "/admin/updateAdmin";
    }

    @RequestMapping("updatePwdSubmit")
    @ResponseBody
    public Map<Object, Object> updateAdmin(Integer id, String newPwd) {
        boolean result = adminService.updateAdmin(id,newPwd);
        Map<Object, Object> map = new HashMap<>();
        if (result==true){
            map.put("code", ResultCode.Update_OK);
        }else {map.put("code",ResultCode.Update_ERR);
                map.put("msg","修改失败请重新尝试");
        }
        return map;
    }
    @RequestMapping("/queryAdminById")
    public String queryAdminById(Integer id,Model model){
        Admin admin = adminService.getPwdById(id);
        model.addAttribute("admin",admin);
        return "/admin/updateAdmin";
    }

    @RequestMapping("searchAdmin")
    @ResponseBody
    public Map<String,Object>searAdmin(String username,Integer adminType,Integer page,Integer limit){
        List<Admin>adminList=adminService.searchAdmin(username,adminType,page,limit);
        PageInfo<Admin>pageInfo=new PageInfo<>(adminList);
        Map map =new HashMap<>();
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        return map;
    }

}
