package com.wind.controller;

import java.util.List;
import net.sf.json.JSONObject;
import com.wind.entity.Record;
import com.wind.service.RecordService;
import com.wind.entity.base.Page;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiImplicitParam;
import io.swagger.annotations.ApiOperation;


/**
 * 结束还书记录表 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "/record")
@Api(value="record")
public class RecordController{

    @Autowired
    private RecordService recordService;

    /**
     * 添加记录接口
     * /record/save.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/save.json")
    @ApiOperation(value="Record 添加记录接口", notes="Record 添加记录接口")
    public String save(Record r) {
        int i = recordService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 删除记录接口
     * /record/delete.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/delete.json")
    @ApiOperation(value="Record 删除记录接口", notes="Record 删除记录接口")
    public String delete(Record r) {
        int i = recordService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * /record/findEntity.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findEntity.json")
    @ApiOperation(value="Record 单条记录查询接口", notes="Record 单条记录查询接口")
    public Record findRecord(Record r) {
        return recordService.findEntity(r);
    }

    /**
     * 批量查询记录接口
     * /record/findList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findList.json")
    @ApiOperation(value="Record 批量查询记录接口", notes="Record 批量查询记录接口")
    public List<Record> findByCondition(Record r) {
        return recordService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * /record/findPageList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findPageList.json")
    @ApiOperation(value="Record 分页查询记录接口", notes="Record 分页查询记录接口")
    public Page findPageList(Record r, Page page){
        return page;
    }

    /**
     * 修改记录接口
     * /record/update.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/update.json")
    @ApiOperation(value="Record 修改记录接口", notes="Record 修改记录接口")
    public String updateByCondition(Record r) {
        int i = recordService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

