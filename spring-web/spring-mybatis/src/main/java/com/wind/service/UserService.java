package com.wind.service;

import java.util.List;
import java.util.Map;

import com.wind.entity.User;

public interface UserService {
	/**
	 *
	 */
	void insert(User user);

	/**
	 *
	 */
	User selectByPrimaryKey(String userId);

	/**
	 *
	 */
	List<User> selectByCondition(User user);

	/**
	 *
	 */
	int deleteByPrimaryKey(String userId);

	/**
	 *
	 */
	int updateByPrimaryKeySelective(User user);

	/**
	 *
	 */
	int countByCondition(User user);
}
