package com.gec.dao;


import com.gec.entity.Admin;
import com.gec.entity.Reader;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ReaderDao {
    public List<Reader> getAllReader();
    public int addReaderSubmit(Reader reader);
    public int deleteReader(List<String> id);
    public int updateReader(Reader reader);
    public Reader queryReaderInfoById(Integer id);
    public  List<Reader>searchReader(@Param("readerNumber") String readerNumber,@Param("username") String username,@Param("tel") String tel);
}
