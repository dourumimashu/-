package com.gec.service.impl;

import com.gec.dao.AdminDao;
import com.gec.entity.Admin;
import com.gec.service.AdminService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;


@Service
public class AdminServiceImpl implements AdminService {
    @Autowired
    AdminDao adminDao;

    @Override
    public boolean checkLogin(String username,String password,Integer adminType){

        if(adminType==0||adminType==1){
            Admin admin = adminDao.getAdminByUP(username, password);
            if (admin!=null){
                return true;
            }
            else {
                return false;
            }
    }
        else {

        }
        return false;
    }

    @Override
    public List<Admin>getAllAdmin(Integer page,Integer limit){
        PageHelper.startPage(page,limit);
        return adminDao.getAllAdmin();
    }

    @Override
    public Boolean addAdminSubmit(Admin admin) {

        int result= adminDao.addAdminSubmit(admin);
        if(result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean deleteAdminByIds(Integer id){
        int result= adminDao.deleteAdminByIds(id);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean deleteAdmin(List<String> id){
        int result= adminDao.deleteAdmin(id);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Boolean updateAdmin(Integer id,String newPwd) {
        int result= adminDao.updateAdmin(id,newPwd);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

    public Admin getPwdById(Integer id){
        return adminDao.getPwdById(id);
    }

    public List<Admin>searchAdmin(String username,Integer adminType,Integer page,Integer limit){
        if(username!=null&&username.trim().length()==0){
            username=null;
        }else {
            username="%"+username+"%";
        }
        PageHelper.startPage(page,limit);
        return adminDao.searchAdmin(username,adminType);
    }
}
