package com.gec.service;

import com.gec.entity.Admin;

import java.util.List;

public interface AdminService {

    public boolean checkLogin(String username,String password,Integer adminType);
    public List<Admin> getAllAdmin(Integer page,Integer limit);
    public Boolean addAdminSubmit(Admin admin);
    public Boolean deleteAdminByIds(Integer id);
    public Boolean deleteAdmin(List<String> id);
    public Boolean updateAdmin(Integer id,String newPwd);
    public Admin getPwdById(Integer id);

    public List<Admin>searchAdmin(String username,Integer adminType,Integer page ,Integer limit);
}
