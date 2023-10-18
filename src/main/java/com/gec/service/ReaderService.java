package com.gec.service;

import com.gec.entity.Admin;
import com.gec.entity.Reader;

import java.util.List;

public interface ReaderService {
    public List<Reader> getAllReader(Integer page,Integer limit);
    public Boolean addReaderSubmit(Reader reader);
    public Boolean deleteReader(List<String> id);
    public Boolean updateReader(Reader reader);
    public Reader queryReaderInfoById(Integer id);
    public List<Reader>searchReader(String readerNumber,String username,String tel,Integer page ,Integer limit);
}
