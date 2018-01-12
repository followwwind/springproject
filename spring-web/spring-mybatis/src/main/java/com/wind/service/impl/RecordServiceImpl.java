package com.wind.service.impl;

import java.util.List;
import com.wind.dao.RecordMapper;
import com.wind.entity.Record;
import com.wind.service.RecordService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 结束还书记录表 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class RecordServiceImpl extends BaseServiceImpl<Record, String> implements RecordService{

    @Autowired
    private RecordMapper mapper;


    @Override
    public int insert(Record r) {
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(Record r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public Record findEntity(Record r) {
        List<Record> entitys = mapper.findByCondition(r);
        return entitys.size() == 1 ? entitys.get(0) : null;
    }

    @Override
    public List<Record> findByCondition(Record r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(Record r, Page page){

    }

    @Override
    public int updateByCondition(Record r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(Record r){
        return mapper.countByCondition(r);
    }
}

