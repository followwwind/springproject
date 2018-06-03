package com.wind.dao.base;

import java.util.List;

/**
 * 数据库dao通用接口
 * @author wind
 * @param <R> 数据库表关联的实体类
 * @param <PK> 主键类型
 */
public interface BaseMapper<R, PK> {
    /**
     * 添加纪录
     * @param r
     * @return
     */
    int insert(R r);

    /**
     * 通过id删除记录
     * @param r
     * @return
     */
    int delete(R r);

    /**
     * 通过id查询单条记录
     * @param id
     * @return
     */
    R findEntity(PK id);

    /**
     * 条件批量查询记录
     * @param r
     * @return
     */
    List<R> findList(R r);

    /**
     * 通过id更新记录
     * @param r
     * @return
     */
    int update(R r);

    /**
     * 查询批量记录条数
     * @param r
     * @return
     */
    int count(R r);
}
