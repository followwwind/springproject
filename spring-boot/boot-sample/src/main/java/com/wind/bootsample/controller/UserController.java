package com.wind.bootsample.controller;

import com.wind.bootsample.entity.UserInfo;
import com.wind.bootsample.service.IUserInfoService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "userInfo")
public class UserController {

    @Autowired
    private IUserInfoService userInfoService;

    @PostMapping(value = "getUserInfos")
    public List<UserInfo> getUserInfos(UserInfo userInfo){
        return userInfoService.selectByCondition(userInfo);
    }

    @GetMapping(value = "getUserInfo/{id}")
    public UserInfo getUserInfo(@PathVariable Long id){
        return userInfoService.selectByPrimaryKey(id);
    }

}
