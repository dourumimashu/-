package com.gec.entity;

import lombok.Data;

import java.util.Date;

@Data
public class Book {
    private int id;
    private String name;
    private String author;
    private String publish;
    private int isbn;
    private String introduction;
    private String language;
    private int price;
    private Date publish_date;
    private int type_id;
    private int status;

    private Type typeInfo;
}
