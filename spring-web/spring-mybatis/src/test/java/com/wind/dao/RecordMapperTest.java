package com.wind.dao;

import java.util.List;
import com.wind.dao.RecordMapper;
import com.wind.entity.Record;
import com.wind.entity.base.Page;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


/**
 * 结束还书记录表 dao测试
 * @author wind
 */
@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration({"classpath:/spring/applicationContext.xml"})
public class RecordMapperTest{

    @Autowired
    RecordMapper mapper;

    @Test
    public void insert() {
        Record entity = new Record();
        int i = mapper.insert(entity);
        System.out.println(i);
    }

    @Test
    public void deleteByCondition() {
        Record entity = new Record();
        int i = mapper.deleteByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void findEntity() {
        Record entity = new Record();
        List<Record> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void findByCondition() {
        Record entity = new Record();
        List<Record> entitys = mapper.findByCondition(entity);
        System.out.println(entitys.size());
    }

    @Test
    public void updateByCondition() {
        Record entity = new Record();
        int i = mapper.updateByCondition(entity);
        System.out.println(i);
    }

    @Test
    public void countByCondition(){
        Record entity = new Record();
        int count = mapper.countByCondition(entity);
        System.out.println(count);
    }
}

