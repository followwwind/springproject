package com.wind.dao.impl;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.hibernate.Query;
import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;

@Repository
@Transactional
public class UserDaoImpl implements UserDao{

    @Autowired
    private SessionFactory sessionFactory;

    @Override
    public void insert(User user) {

    }

    @Override
    public User selectByPrimaryKey(String userId) {
        String hql = "from User u where u.userId=?";
        Query query = sessionFactory.openSession().createQuery(hql);
        query.setString(0, userId);
        return (User)query.uniqueResult();
    }

    @Override
    public List<User> selectByCondition(User user) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        return 0;
    }

    @Override
    public int countByCondition(User user) {
        return 0;
    }
}
