package com.gec.service.impl;

import com.github.pagehelper.PageHelper;
import com.gec.dao.BookDao;
import com.gec.entity.Book;
import com.gec.entity.Type;
import com.gec.service.BookService;
import org.apache.ibatis.annotations.Param;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.ui.Model;

import java.util.Date;
import java.util.List;

@Service
public class BookServiceImpl implements BookService {
    @Autowired
    BookDao bookDao;


    @Override
    public List<Book> getAllBook(Integer page, Integer limit) {
        PageHelper.startPage(page,limit);
        return bookDao.getAllBook();
    }

    @Override
    public List<Type> getType() {
        return bookDao.getType();
    }

    @Override
    public boolean addBookSubmit(String name, Integer isbn, Integer type_id, String author, String publish, String language, Integer price, Date publish_date, String introduction) {
        int result = bookDao.addBookSubmit(name, isbn, type_id, author, publish, language, price, publish_date, introduction);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean deleteBook(List<String> ids) {
        int result = bookDao.deleteBook(ids);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }

    @Override
    public boolean updateBook(Integer id,String name, Integer isbn, Integer type_id, String author, String publish, String language, Integer price, Date publish_date, String introduction) {

        int result = bookDao.updateBook(id,name, isbn, type_id, author, publish, language, price, publish_date, introduction);
        if (result>0){
            return true;
        }else {
            return false;
        }
    }
    @Override
    public Book queryBookById(Integer id){
       return bookDao.queryBookById(id);

    }

    @Override
    public List<Book> searchBook(Integer isbn, String name, Integer type_id, Integer page, Integer limit) {
        if (name!=null&&name.trim().length()==0){
            name=null;
        }else{
            name = "%"+name+"%";
        }
        PageHelper.startPage(page,limit);
        return bookDao.searchBook(isbn,name,type_id);
    }


}
