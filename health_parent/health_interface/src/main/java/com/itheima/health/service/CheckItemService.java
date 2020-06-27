package com.itheima.health.service;

import com.itheima.health.pojo.CheckItem;
import com.itheima.health.response.PageResult;

import java.util.List;


public interface CheckItemService {

    /**
     * 查询所有
     *
     * @return
     */
    public List<CheckItem> findAll();

    /**
     * 根据ID查询
     */
    public CheckItem findById(Integer id);

    /**
     * 添加
     */
    public CheckItem add(CheckItem checkItem);

    /**
     * 删除
     */
    public void delete(Integer id);

    /**
     * 更新
     */
    public void edit(Integer id, CheckItem checkItem);

    /**
     * 根据条件查询
     * 分页
     */
    public PageResult<CheckItem> search(CheckItem checkItem, Integer page, Integer size);

}
