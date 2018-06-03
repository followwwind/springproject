package com.wind.dao;

import java.util.Date;
import java.util.List;

import com.wind.entity.User;
import com.wind.util.IdGenUtil;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 学生信息表 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class UserMapperTest {

    @Autowired
    UserMapper mapper;

    @Test
    public void insert() {
        User entity = new User();
        entity.setUserId(IdGenUtil.getUUID());
        entity.setUsername("18771933975");
        entity.setPassword("123456");
        entity.setCreateTime(new Date());
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void delete() {
        User entity = new User();
        int i = mapper.delete(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {

    }

    @Test
    public void findList() {
        User entity = new User();
        List<User> entitys = mapper.findList(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void update() {
        User entity = new User();
        int i = mapper.update(entity);
        System.out.println(i);
    }

    @Test
    public void count(){
        User entity = new User();
        int count = mapper.count(entity);
        System.out.println(count);
    }
}

