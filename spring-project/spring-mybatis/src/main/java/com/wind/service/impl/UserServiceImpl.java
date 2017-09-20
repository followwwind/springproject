package com.wind.service.impl;



import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import com.wind.service.UserService;

@Service
@Transactional
public class UserServiceImpl implements UserService{
	
	@Resource
	UserDao userDao;

	@Override
	public void addUser(User user) {	
		userDao.addUser(user);
	}

	@Override
	public List<User> findUserByCondition(Map<String, String> map) {
		List<User> users = userDao.findUserByCondition(map);
		return users;
	}

	@Override
	public void updateUser(User user) {	
		userDao.updateUser(user);
	}

	@Override
	public void deleteUser(String id) {
		userDao.deleteUser(id);
	}
	
}
