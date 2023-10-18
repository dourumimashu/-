package com.gec.service;


import com.gec.entity.Book;
import com.gec.entity.Type;
import org.apache.ibatis.annotations.Param;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;


public interface BookService {
    public List<Book> getAllBook(Integer page, Integer limit);
    public List<Type> getType();
    public boolean addBookSubmit(String name, Integer isbn, Integer type_id, String author, String publish, String language, Integer price, Date publish_date, String introduction);
    public boolean deleteBook(List<String> ids);
    public boolean updateBook(Integer id, String name, Integer isbn, Integer type_id, String author, String publish, String language, Integer price, Date publish_date, String introduction);
    public Book queryBookById(@Param("id") Integer id);
    public List<Book> searchBook(Integer isbn, String name, Integer type_id, Integer page, Integer limit);
}
