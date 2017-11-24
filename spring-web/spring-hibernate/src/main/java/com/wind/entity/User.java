package com.wind.entity;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.Date;

/**
 * 
 */
@Entity
@Table(name = "user" )
public class User {
    /**
     * 用户ID
     */
    @Id
    @Column(name="user_id")
    private String userId;
    /**
     * 账号
     */
    @Column(name="username")
    private String username;
    /**
     * 密码
     */
    @Column(name="password")
    private String password;
    /**
     * 邮箱
     */
    @Column(name="email")
    private String email;
    /**
     * 年龄
     */
    @Column(name="age")
    private Integer age;
    /**
     * 时间
     */
    @Column(name="time")
    private Date time;

    public void setUserId(String userId){
        this.userId = userId;
    }

    public String getUserId(){
        return this.userId;
    }
    public void setUsername(String username){
        this.username = username;
    }

    public String getUsername(){
        return this.username;
    }
    public void setPassword(String password){
        this.password = password;
    }

    public String getPassword(){
        return this.password;
    }
    public void setEmail(String email){
        this.email = email;
    }

    public String getEmail(){
        return this.email;
    }
    public void setAge(Integer age){
        this.age = age;
    }

    public Integer getAge(){
        return this.age;
    }
    public void setTime(Date time){
        this.time = time;
    }

    public Date getTime(){
        return this.time;
    }
}

