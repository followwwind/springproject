package com.wind.entity;

import java.util.Date;

/**
 * 结束还书记录表
 * @author wind
 */
public class Record{

    private String recordId;

    /**
     * 用户id
     */
    private String userId;

    /**
     * 图书id
     */
    private String bookId;

    /**
     * 借书日期
     */
    private Date borrowTime;

    /**
     * 还书日期
     */
    private Date returnTime;


    public void setRecordId(String recordId){
        this.recordId = recordId;
    }

    public String getRecordId(){
        return this.recordId;
    }
    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setBookId(String bookId){
        this.bookId = bookId;
    }

    public String getBookId(){
        return this.bookId;
    }
    public void setBorrowTime(Date borrowTime){
        this.borrowTime = borrowTime;
    }

    public Date getBorrowTime(){
        return this.borrowTime;
    }
    public void setReturnTime(Date returnTime){
        this.returnTime = returnTime;
    }

    public Date getReturnTime(){
        return this.returnTime;
    }

}

