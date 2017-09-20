package com.wind.service;

import java.util.List;
import java.util.Map;

import com.wind.entity.User;

public interface UserService {
	/**
	 * 添加用户
	 * @param user
	 */
	public void addUser(User user);
	
	/**
	 * 根据条件查询User信息
	 * @param map
	 * @return
	 */
	public List<User> findUserByCondition(Map<String, String> map);
	
	/**
	 * 修改User信息
	 * @param map
	 */
	public void updateUser(User user);
	
	/**
	 * 删除用户信息
	 * @param id
	 */
	public void deleteUser(String id);
}
