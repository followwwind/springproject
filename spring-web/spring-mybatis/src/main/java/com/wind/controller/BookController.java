package com.wind.controller;

import com.wind.entity.Book;
import com.wind.entity.base.Page;
import com.wind.service.BookService;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import net.sf.json.JSONObject;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;


/**
 * 图书信息表 controller
 * @author wind
 */
@RestController
@RequestMapping(value = "book")
@Api(value="book")
public class BookController{

    @Autowired
    private BookService bookService;

    /**
     * 添加记录接口
     * /book/save.json
     * @param r
     * @return
     */
    @RequestMapping(value = "save.json")
    @ApiOperation(value="Book 添加记录接口", notes="Book 添加记录接口")
    public String save(Book r) {
        int i = bookService.insert(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 删除记录接口
     * /book/delete.json
     * @param r
     * @return
     */
    @RequestMapping(value = "delete.json")
    @ApiOperation(value="Book 删除记录接口", notes="Book 删除记录接口")
    public String delete(Book r) {
        int i = bookService.deleteByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }

    /**
     * 单条记录查询接口
     * /book/findEntity.json
     * @param r
     * @return
     */
    @RequestMapping(value = "findEntity.json")
    @ApiOperation(value="Book 单条记录查询接口", notes="Book 单条记录查询接口")
    public Book findBook(Book r) {
        return bookService.findEntity(r);
    }

    /**
     * 批量查询记录接口
     * /book/findList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "findList.json")
    @ApiOperation(value="Book 批量查询记录接口", notes="Book 批量查询记录接口")
    public List<Book> findByCondition(Book r) {
        return bookService.findByCondition(r);
    }

    /**
     * 分页查询记录接口
     * /book/findPageList.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/findPageList.json")
    @ApiOperation(value="Book 分页查询记录接口", notes="Book 分页查询记录接口")
    public Page findPageList(Book r, Page page){
        return page;
    }

    /**
     * 修改记录接口
     * /book/update.json
     * @param r
     * @return
     */
    @RequestMapping(value = "/update.json")
    @ApiOperation(value="Book 修改记录接口", notes="Book 修改记录接口")
    public String updateByCondition(Book r) {
        int i = bookService.updateByCondition(r);
        JSONObject result = new JSONObject();
        result.put("msg", i > 0 ? "success" : "failure");
        return result.toString();
    }
}

