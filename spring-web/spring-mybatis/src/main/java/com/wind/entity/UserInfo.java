package com.wind.entity;

import java.util.Date;

/**
 * 学生信息表
 * @author wind
 */
public class UserInfo{

    /**
     * 学号
     */
    private String userId;

    /**
     * 姓名
     */
    private String name;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 手机号
     */
    private String phone;

    /**
     * 借书本数
     */
    private Integer count;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 账户类型，1为系统账户，2为普通用户
     */
    private Integer type;


    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setName(String name){
        this.name = name;
    }

    public String getName(){
        return this.name;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public void setPhone(String phone){
        this.phone = phone;
    }

    public String getPhone(){
        return this.phone;
    }
    public void setCount(Integer count){
        this.count = count;
    }

    public Integer getCount(){
        return this.count;
    }
    public void setCreateTime(Date createTime){
        this.createTime = createTime;
    }

    public Date getCreateTime(){
        return this.createTime;
    }
    public void setType(Integer type){
        this.type = type;
    }

    public Integer getType(){
        return this.type;
    }

}

