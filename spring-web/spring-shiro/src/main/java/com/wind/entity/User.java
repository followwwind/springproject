package com.wind.entity;

/**
 * @package com.wind.entity
 * @className User
 * @note 用户数据模型
 * @author wind
 * @date 2018/6/3 14:29
 */
public class User {

    private String userId;

    private String username;

    private String password;

    public String getUserId() {
        return userId;
    }

    public void setUserId(String userId) {
        this.userId = userId;
    }

    public String getUsername() {
        return username;
    }

    public void setUsername(String username) {
        this.username = username;
    }

    public String getPassword() {
        return password;
    }

    public void setPassword(String password) {
        this.password = password;
    }
}
