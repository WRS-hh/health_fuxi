package com.itheima.health.service;

import com.itheima.health.pojo.CheckItem;

import java.util.List;

/**
 * @Description:
 * @Version: V1.0
 */
public interface CheckItemService {

    /**
     * 查询所有
     * @return
     */
    public List<CheckItem> findAll();
}
