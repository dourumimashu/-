package com.gec.service;

import com.gec.entity.Notice;
import com.gec.entity.Reader;

import java.util.List;

public interface NoticeService {

    public List<Notice> getAllNotice();
    public List<Notice> getAllNotice2(Integer page,Integer limit);
    public Boolean addNoticeSubmit(Notice notice);
    public Boolean deleteNotice(List<String> id);
    public Notice queryNoticeInfoById(Integer id);
    public List<Notice>searchNotice(String topic,Integer page ,Integer limit);
}
