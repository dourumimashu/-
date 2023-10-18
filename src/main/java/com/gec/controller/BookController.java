package com.gec.controller;


import com.github.pagehelper.PageInfo;
import com.gec.entity.Book;
import com.gec.entity.ResultCode;
import com.gec.entity.Type;
import com.gec.service.impl.BookServiceImpl;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.*;

import static java.awt.SystemColor.info;

@Controller
public class BookController {
    @Autowired
    BookServiceImpl bookService;

    @RequestMapping("/bookIndex")
    public String bookIndex(){
        return "/book/bookIndex";
    }

    @RequestMapping("/getAllBook")
    @ResponseBody
    public Map<String,Object> getAllBook(Integer page,Integer limit){
        List<Book> bookList = bookService.getAllBook(page, limit);
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);
        Map<String,Object> map = new HashMap<>();
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","获取数据成功！");
        map.put("count",pageInfo.getTotal());
        return map;
    }

    @RequestMapping("/bookAdd")
    public String bookAdd(){
        return "/book/bookAdd";
    }

    @RequestMapping("/findAllList")
    @ResponseBody
    public List<Type> getType(){
        return bookService.getType();
    }



    @RequestMapping("/addBookSubmit")
    @ResponseBody
    Map<String,Object> addBookSubmit(String name, Integer isbn, Integer typeId, String author, String publish, String language, Integer price, String pubDate, String introduction){

        Date publish_date = null;
        //把日期字符串转换成日期对象
        try {
             publish_date = new SimpleDateFormat("yyyy-MM-dd").parse(pubDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }

        boolean result = bookService.addBookSubmit(name, isbn, typeId, author, publish, language, price, publish_date, introduction);
        Map<String,Object> map = new HashMap<>();
        if (result == true){
            map.put("code", ResultCode.Add_OK);
        }else {
            map.put("code", ResultCode.Add_ERR);
        }
        return map;
    }

    @RequestMapping("/deleteBook")
    @ResponseBody
    public Map<String,Object> deleteBook(String ids){
        List<String> idList = Arrays.asList(ids.split(","));
        boolean result = bookService.deleteBook(idList);
        Map<String,Object> map = new HashMap<>();
        if (result == true){
            map.put("code",ResultCode.Delete_OK);
        }else {
            map.put("code",ResultCode.Delete_ERR);
        }
        return map;
    }

    @RequestMapping("/updateBook")
    public String queryAdminById(Integer id ,Model model){
        Book info =bookService.queryBookById(id);
        model.addAttribute("info",info);

        return ("/book/updateBook");
    }

    @RequestMapping("/updateBookSubmit")
    @ResponseBody
    public Map<String,Object> updateBookSubmit(Integer id,String name, Integer isbn, Integer typeId, String author, String publish, String language, Integer price, String publishDate, String introduction){
        Date publish_date = null;
        //把日期字符串转换成日期对象
        try {
            publish_date = new SimpleDateFormat("yyyy-MM-dd").parse(publishDate);
        } catch (ParseException e) {
            e.printStackTrace();
        }
        Map<String,Object> map = new HashMap<>();
        boolean result = bookService.updateBook(id,name, isbn, typeId, author, publish, language, price, publish_date, introduction);
        if(result == true){
            map.put("code",ResultCode.Update_OK);
        }else{
            map.put("code",ResultCode.Update_ERR);
            map.put("msg","修改失败，请重新尝试！");
        }
        System.out.println(id);
        return map;
    }

    @RequestMapping("/searchBook")
    @ResponseBody
    public Map<String,Object> searchBook(Integer isbn,String name,Integer type_id,Integer page,Integer limit){
        Map<String,Object> map = new HashMap<>();
        List<Book> bookList = bookService.searchBook(isbn,name,type_id,page,limit);
        PageInfo<Book> pageInfo = new PageInfo<>(bookList);
        map.put("code",0);
        map.put("data",pageInfo.getList());
        map.put("msg","查询成功");
        map.put("count",pageInfo.getTotal());
        return map;
    }
}
