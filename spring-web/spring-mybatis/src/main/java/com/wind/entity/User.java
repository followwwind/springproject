package com.wind.entity;

import java.util.Date;

/**
 * 学生信息表
 * @author wind
 */
public class User {

    /**
     * userId
     */
    private String userId;

    /**
     * 姓名
     */
    private String username;

    /**
     * 账号密码
     */
    private String password;

    /**
     * 手机号
     */
    private String tel;


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

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public void setTel(String tel){
        this.tel = tel;
    }

    public String getTel(){
        return this.tel;
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

