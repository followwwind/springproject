package com.wind.dao;

import java.util.List;
import com.wind.dao.BookMapper;
import com.wind.entity.Book;
import com.wind.entity.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 图书信息表 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class BookMapperTest{

    @Autowired
    BookMapper mapper;

    @Test
    public void insert() {
        Book entity = new Book();
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void deleteByCondition() {
        Book entity = new Book();
        int i = mapper.deleteByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {
        Book entity = new Book();
        List<Book> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findByCondition() {
        Book entity = new Book();
        List<Book> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void updateByCondition() {
        Book entity = new Book();
        int i = mapper.updateByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void countByCondition(){
        Book entity = new Book();
        int count = mapper.countByCondition(entity);
        System.out.println(count);
    }
}

