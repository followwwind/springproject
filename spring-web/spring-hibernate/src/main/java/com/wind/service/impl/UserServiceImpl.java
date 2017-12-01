package com.wind.service.impl;


import com.wind.service.UserService;
import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
/*@Transactional*/
public class UserServiceImpl implements UserService {

	@Autowired
	private UserDao userDao;


	@Override
	public void insert(User user) {
		userDao.insert(user);
	}

	@Override
	public User selectByPrimaryKey(String userId) {
		return userDao.selectByPrimaryKey(userId);
	}

	@Override
	public List<User> selectByCondition(User user) {
		return userDao.selectByCondition(user);
	}

	@Override
	public int deleteByPrimaryKey(String userId) {
		return userDao.deleteByPrimaryKey(userId);
	}

	@Override
	public int updateByPrimaryKeySelective(User user) {
		return userDao.updateByPrimaryKeySelective(user);
	}

	@Override
	public int countByCondition(User user) {
		return userDao.countByCondition(user);
	}
}
