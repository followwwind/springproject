package com.wind.controller;

import java.util.List;
import net.sf.json.JSONObject;
import com.wind.entity.UserInfo;
import com.wind.service.UserInfoService;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * 学生信息表 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "/userInfo")
@Api(value="userInfo")
public class UserInfoController{

    @Autowired
    private UserInfoService userInfoService;

    /**
     * 添加记录接口
     * /userInfo/save.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/save.json")
    @ApiOperation(value="UserInfo 添加记录接口", notes="UserInfo 添加记录接口")
    public String save(UserInfo r) {
        int i = userInfoService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 删除记录接口
     * /userInfo/delete.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/delete.json")
    @ApiOperation(value="UserInfo 删除记录接口", notes="UserInfo 删除记录接口")
    public String delete(UserInfo r) {
        int i = userInfoService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * /userInfo/findEntity.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findEntity.json")
    @ApiOperation(value="UserInfo 单条记录查询接口", notes="UserInfo 单条记录查询接口")
    public UserInfo findUserInfo(UserInfo r) {
        return userInfoService.findEntity(r);
    }

    /**
     * 批量查询记录接口
     * /userInfo/findList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findList.json")
    @ApiOperation(value="UserInfo 批量查询记录接口", notes="UserInfo 批量查询记录接口")
    public List<UserInfo> findByCondition(UserInfo r) {
        return userInfoService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * /userInfo/findPageList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findPageList.json")
    @ApiOperation(value="UserInfo 分页查询记录接口", notes="UserInfo 分页查询记录接口")
    public Page findPageList(UserInfo r, Page page){
        return page;
    }

    /**
     * 修改记录接口
     * /userInfo/update.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/update.json")
    @ApiOperation(value="UserInfo 修改记录接口", notes="UserInfo 修改记录接口")
    public String updateByCondition(UserInfo r) {
        int i = userInfoService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

