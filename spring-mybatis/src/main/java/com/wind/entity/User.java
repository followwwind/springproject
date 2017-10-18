package com.wind.entity;
/**
 * 用户账号信息
 * @author followwwind
 *
 */
public class User {
	String id;
	//账号
	String username;
	//密码
	String password;
	//邮箱
	String email;
	public String getId() {
		return id;
	}
	public void setId(String id) {
		this.id = id;
	}
	public String getUserName() {
		return username;
	}
	public void setUserName(String username) {
		this.username = username;
	}
	public String getPassword() {
		return password;
	}
	public void setPassword(String password) {
		this.password = password;
	}
	public String getEmail() {
		return email;
	}
	public void setEmail(String email) {
		this.email = email;
	}
	
}
