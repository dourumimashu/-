package com.gec.dao;

import com.gec.entity.Admin;
import org.apache.ibatis.annotations.Param;
import org.apache.ibatis.annotations.Select;

import java.util.List;

public interface AdminDao {

    public Admin getAdminByUP(@Param("username") String username, @Param("password")String password);
    public List<Admin>getAllAdmin();
    public int addAdminSubmit(Admin admin);
    public int deleteAdminByIds(Integer id);

    public int updateAdmin(@Param("id") Integer id,@Param("newPwd") String newPwd);

    public int deleteAdmin(List<String> id);

    @Select("select * from admin where id=#{id}")
    public Admin getPwdById(Integer id);

    public  List<Admin>searchAdmin(@Param("username") String username,@Param("adminType") Integer adminType);
}
