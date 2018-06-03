package com.wind.service.impl;

import java.util.List;
import com.wind.dao.UserMapper;
import com.wind.entity.User;
import com.wind.service.UserService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生信息表 service接口实现
 * @author wind
 */
@Service
public class UserServiceImpl extends BaseServiceImpl<User, String> implements UserService {

    @Autowired
    private UserMapper mapper;


    @Override
    public int insert(User user) {
        return 0;
    }

    @Override
    public int delete(User user) {
        return 0;
    }

    @Override
    public User findEntity(String id) {
        return null;
    }

    @Override
    public List<User> findList(User user) {
        return mapper.findList(user);
    }

    @Override
    public void findPageList(User user, Page page) {

    }

    @Override
    public int update(User user) {
        return 0;
    }

    @Override
    public int count(User user) {
        return 0;
    }
}

