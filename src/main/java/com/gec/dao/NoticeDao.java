package com.gec.dao;

import com.gec.entity.Admin;
import com.gec.entity.Notice;
import com.gec.entity.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface NoticeDao {

    public List<Notice>getAllNotice();
    public List<Notice>getAllNotice2();
    public int addNoticeSubmit(Notice notice);
    public int deleteNotice(List<String> id);
    public  List<Notice>searchNotice(@Param("topic") String topic);
    public Notice queryNoticeInfoById(Integer id);

}
