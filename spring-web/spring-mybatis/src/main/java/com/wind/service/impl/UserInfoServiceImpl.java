package com.wind.service.impl;

import java.util.List;
import com.wind.dao.UserInfoMapper;
import com.wind.entity.UserInfo;
import com.wind.service.UserInfoService;
import com.wind.service.base.BaseServiceImpl;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

/**
 * 学生信息表 service接口实现
 * @author wind
 */
@Service
//@Transactional
public class UserInfoServiceImpl extends BaseServiceImpl<UserInfo, String> implements UserInfoService{

    @Autowired
    private UserInfoMapper mapper;


    @Override
    public int insert(UserInfo r) {
        int i = mapper.insert(r);
        return i;
    }

    @Override
    public int deleteByCondition(UserInfo r) {
        return mapper.deleteByCondition(r);
    }

    @Override
    public UserInfo findEntity(UserInfo r) {
        List<UserInfo> entitys = mapper.findByCondition(r);
        return entitys.size() == 1 ? entitys.get(0) : null;
    }

    @Override
    public List<UserInfo> findByCondition(UserInfo r) {
        return mapper.findByCondition(r);
    }

    @Override
    public void findPageList(UserInfo r, Page page){

    }

    @Override
    public int updateByCondition(UserInfo r) {
        return mapper.updateByCondition(r);
    }

    @Override
    public int countByCondition(UserInfo r){
        return mapper.countByCondition(r);
    }
}

