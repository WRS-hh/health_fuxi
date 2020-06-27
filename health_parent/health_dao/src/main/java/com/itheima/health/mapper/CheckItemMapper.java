package com.itheima.health.mapper;

import com.github.pagehelper.Page;
import com.itheima.health.pojo.CheckItem;

import java.util.List;


public interface CheckItemMapper {

    /**
     * 查询所有
     *
     * @return
     */
    public List<CheckItem> findAll();

    /**
     * 根据Id查询
     * @param id
     * @return
     */
    public CheckItem findById(Integer id);


    /**
     * 添加
     * @param checkItem
     */
    public void add(CheckItem checkItem);

    /**
     * 删除
     */
    public void delete(Integer id);

    /**
     * 更新
     */
    public void edit(CheckItem checkItem);

    /**
     * 根据条件查询
     * @return
     */
    public Page<CheckItem> search(CheckItem checkItem);

}
