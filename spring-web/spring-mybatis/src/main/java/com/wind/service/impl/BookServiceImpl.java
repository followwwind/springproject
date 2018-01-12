package com.wind.service.impl;

import java.util.List;
import com.wind.dao.BookMapper;
import com.wind.entity.Book;
import com.wind.service.BookService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 图书信息表 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class BookServiceImpl extends BaseServiceImpl<Book, String> implements BookService{

    @Autowired
    private BookMapper mapper;


    @Override
    public int insert(Book r) {
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(Book r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public Book findEntity(Book r) {
        List<Book> entitys = mapper.findByCondition(r);
        return entitys.size() == 1 ? entitys.get(0) : null;
    }

    @Override
    public List<Book> findByCondition(Book r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(Book r, Page page){

    }

    @Override
    public int updateByCondition(Book r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(Book r){
        return mapper.countByCondition(r);
    }
}

