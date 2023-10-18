package com.gec.service.impl;

import com.gec.dao.AdminDao;
import com.gec.dao.LendDao;
import com.gec.entity.Lend;
import com.gec.service.LendService;
import com.github.pagehelper.PageHelper;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.Date;
import java.util.List;

@Service
public class LendServiceImpl implements LendService {

    @Autowired
    LendDao lendDao;

    @Override
    public List<Lend> getAllLend(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return lendDao.getAllLend();

    }
    @Override
    public boolean addLend(@Param("bookId") String ids,@Param("readerId")String readerNumber,@Param("lendDate") Date lendDate,@Param("backDate") Date backDate,@Param("backType") Integer backType,@Param("exceptRemarks") String exceptRemarks){

        int result =lendDao.addLend(ids,readerNumber,lendDate,backDate,backType,exceptRemarks);

        if (result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean deleteLendListByIds(List<String> id){
        int result= lendDao.deleteLendListByIds(id);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Boolean backLendListByIds(@Param("backDate") Date backDate){
        int result= lendDao.backLendListByIds(backDate);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

}
