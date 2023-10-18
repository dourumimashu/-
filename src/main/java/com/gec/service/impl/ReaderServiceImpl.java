package com.gec.service.impl;

import com.gec.dao.ReaderDao;
import com.gec.entity.Reader;
import com.gec.service.ReaderService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ReaderServiceImpl implements ReaderService {
    @Autowired
    ReaderDao readerDao;

    @Override
    public List<Reader> getAllReader(Integer page, Integer limit){

        PageHelper.startPage(page,limit);
        return readerDao.getAllReader();
    }
    @Override
    public Boolean addReaderSubmit(Reader reader) {

        int result= readerDao.addReaderSubmit(reader);
        if(result>0){
            return true;
        }else {
            return false;
        }

    }

    @Override
    public Boolean deleteReader(List<String> id){
        int result= readerDao.deleteReader(id);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Boolean updateReader(Reader reader) {
        int result= readerDao.updateReader(reader);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public Reader queryReaderInfoById(Integer id){
        return readerDao.queryReaderInfoById(id);
    }


    @Override
    public List<Reader>searchReader(String readerNumber,String username,String tel,Integer page ,Integer limit){

        if(readerNumber!=null&&readerNumber.trim().length()==0){
            readerNumber=null;
        }else {
            readerNumber="%"+readerNumber+"%";
        }
        if(username!=null&&username.trim().length()==0){
            username=null;
        }else {
            username="%"+username+"%";
        }
        if(tel!=null&&tel.trim().length()==0){
            tel=null;
        }else {
            tel="%"+tel+"%";
        }
        PageHelper.startPage(page,limit);
        return readerDao.searchReader(readerNumber,username,tel);
    }
}
