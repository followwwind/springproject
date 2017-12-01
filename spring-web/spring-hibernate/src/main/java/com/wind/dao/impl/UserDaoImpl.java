package com.wind.dao.impl;

import com.wind.dao.UserDao;
import com.wind.entity.User;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.orm.hibernate5.HibernateTemplate;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
/*@Transactional*/
public class UserDaoImpl implements UserDao {

    @Autowired
    private HibernateTemplate hibernateTemplate;

    @Override
    public void insert(User user) {
        hibernateTemplate.save(user);
    }

    @Override
    public User selectByPrimaryKey(String userId) {
        return hibernateTemplate.get(User.class, userId);
    }

    @Override
    public List<User> selectByCondition(User user) {
        return null;
    }

    @Override
    public int deleteByPrimaryKey(String userId) {
        User user = new User();
        user.setUserId(userId);
        hibernateTemplate.delete(user);
        return 0;
    }

    @Override
    public int updateByPrimaryKeySelective(User user) {
        hibernateTemplate.update(user);
        return 0;
    }

    @Override
    public int countByCondition(User user) {
        return 0;
    }
}
