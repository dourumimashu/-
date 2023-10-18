package com.gec.entity;

import java.util.Date;

public class Lend {

    private int id;
    private int bookId;
    private int readerId;
    private Date lendDate;
    private Date backDate;
    private int backType;
    private String exceptRemarks;
    private Book bookInfo;
    private Reader readerInfo;

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public int getBookId() {
        return bookId;
    }

    public void setBookId(int bookId) {
        this.bookId = bookId;
    }

    public int getReaderId() {
        return readerId;
    }

    public void setReaderId(int readerId) {
        this.readerId = readerId;
    }

    public Date getLendDate() {
        return lendDate;
    }

    public void setLendDate(Date lendDate) {
        this.lendDate = lendDate;
    }

    public Date getBackDate() {
        return backDate;
    }

    public void setBackDate(Date backDate) {
        this.backDate = backDate;
    }

    public int getBackType() {
        return backType;
    }

    public void setBackType(int backType) {
        this.backType = backType;
    }

    public String getExceptRemarks() {
        return exceptRemarks;
    }

    public void setExceptRemarks(String exceptRemarks) {
        this.exceptRemarks = exceptRemarks;
    }

    public Book getBookInfo() {
        return bookInfo;
    }

    public void setBookInfo(Book bookInfo) {
        this.bookInfo = bookInfo;
    }

    public Reader getReaderInfo() {
        return readerInfo;
    }

    public void setReaderInfo(Reader readerInfo) {
        this.readerInfo = readerInfo;
    }
}
