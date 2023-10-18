package com.gec.dao;


import com.gec.entity.Book;
import com.gec.entity.Type;
import org.apache.ibatis.annotations.Param;

import java.util.Date;
import java.util.List;

public interface BookDao {
    public List<Book> getAllBook();
    public List<Type> getType();
    public int addBookSubmit(@Param("name") String name, @Param("isbn") Integer isbn, @Param("type_id") Integer type_id, @Param("author") String author, @Param("publish") String publish, @Param("language") String language, @Param("price") Integer price, @Param("publish_date") Date publish_date, @Param("introduction") String introduction);
    public int deleteBook(List<String> id);
    public int updateBook(@Param("id") Integer id, @Param("name") String name, @Param("isbn") Integer isbn, @Param("type_id") Integer type_id, @Param("author") String author, @Param("publish") String publish, @Param("language") String language, @Param("price") Integer price, @Param("publish_date") Date publish_date, @Param("introduction") String introduction);
    public Book queryBookById(Integer id);
    public List<Book> searchBook(@Param("isbn") Integer isbn, @Param("name") String name, @Param("type_id") Integer type_id);
}
