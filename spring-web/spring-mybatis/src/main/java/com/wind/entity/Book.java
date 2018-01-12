package com.wind.entity;

import java.util.Date;

/**
 * 图书信息表
 * @author wind
 */
public class Book{

    /**
     * 图书编号
     */
    private String bookId;

    /**
     * 图书名称
     */
    private String bookName;

    /**
     * 作者
     */
    private String author;

    /**
     * 出版社
     */
    private String publishers;

    /**
     * 价格
     */
    private Double price;

    /**
     * 创建日期
     */
    private Date createTime;

    /**
     * 图书状态，0表示空闲，1表示被占用，即被借用
     */
    private Integer status;


    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public String getBookId(){
        return this.bookId;
    }
    public void setBookName(String bookName){
        this.bookName = bookName;
    }

    public String getBookName(){
        return this.bookName;
    }
    public void setAuthor(String author){
        this.author = author;
    }

    public String getAuthor(){
        return this.author;
    }
    public void setPublishers(String publishers){
        this.publishers = publishers;
    }

    public String getPublishers(){
        return this.publishers;
    }
    public void setPrice(Double price){
        this.price = price;
    }

    public Double getPrice(){
        return this.price;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
    public void setStatus(Integer status){
        this.status = status;
    }

    public Integer getStatus(){
        return this.status;
    }

}

