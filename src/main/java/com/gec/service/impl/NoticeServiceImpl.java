package com.gec.service.impl;

import com.gec.dao.NoticeDao;
import com.gec.entity.Admin;
import com.gec.entity.Notice;
import com.gec.entity.Reader;
import com.gec.service.NoticeService;
import com.github.pagehelper.PageHelper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class NoticeServiceImpl implements NoticeService {
    @Autowired
    NoticeDao noticeDao;

    @Override
    public List<Notice>getAllNotice(){
        return noticeDao.getAllNotice();
    }
    @Override
    public List<Notice>getAllNotice2(Integer page,Integer limit){

        PageHelper.startPage(page,limit);
        return noticeDao.getAllNotice2();
    }
    @Override
    public Boolean addNoticeSubmit(Notice notice) {

        int result= noticeDao.addNoticeSubmit(notice);
        if(result>0){
            return true;
        }else {
            return false;
        }

    }
    @Override
    public Boolean deleteNotice(List<String> id){
        int result= noticeDao.deleteNotice(id);
        if(result>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Notice queryNoticeInfoById(Integer id){
        return noticeDao.queryNoticeInfoById(id);
    }

    @Override
    public List<Notice>searchNotice(String topic,Integer page ,Integer limit){

        if(topic!=null&&topic.trim().length()==0){
            topic=null;
        }else {
            topic="%"+topic+"%";
        }

        PageHelper.startPage(page,limit);
        return noticeDao.searchNotice(topic);
    }
}
