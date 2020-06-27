package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;

import com.github.pagehelper.Page;
import com.github.pagehelper.PageHelper;
import com.itheima.health.mapper.CheckItemMapper;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.response.PageResult;
import com.itheima.health.service.CheckItemService;
import lombok.extern.slf4j.Slf4j;
import org.apache.log4j.Logger;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;

import java.util.List;


@Service(interfaceClass = CheckItemService.class)
@Slf4j
@Transactional
public class CheckItemServiceImpl implements CheckItemService {

    private static final Logger LOGGER = Logger.getLogger(CheckItemServiceImpl.class);


    @Autowired
    CheckItemMapper checkItemMapper;

    /**
     * 查询所有
     *
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> list = checkItemMapper.findAll();
        return list;
    }

    /**
     * 根据ID查询
     *
     * @param id
     * @return
     */
    @Override
    public CheckItem findById(Integer id) {
        CheckItem item = checkItemMapper.findById(id);
        return item;
    }

    /**
     * 添加
     *
     * @param checkItem
     * @return
     */
    @Override
    public CheckItem add(CheckItem checkItem) {

        //无返回值.新增成功后封装到checkitem的id属性
        checkItemMapper.add(checkItem);

        //校验
        if (checkItem == null || checkItem.getId() == null) {
            log.error("CheckItemServiceImpl add is error checkItem={}", checkItem);
            /*LOGGER.error("");*/
            throw new RuntimeException("新增失败");
        }

        return checkItem;
    }

    /**
     * 删除
     *
     * @param id
     */
    @Override
    public void delete(Integer id) {
        checkItemMapper.delete(id);
    }

    /**
     * 更新
     *
     * @param id
     * @param checkItem
     */
    @Override
    public void edit(Integer id, CheckItem checkItem) {
        //尝试校验
        if (id == null) {
            log.error("CheckItemServiceImpl edit is error, casedBy id is null");
            throw new RuntimeException("主键不能为空");
        }

        //业务处理
        CheckItem byId = checkItemMapper.findById(id);
        if (byId == null) {
            log.error("CheckItemServiceImpl edit is error, findById is null,id={}", id);
            throw new RuntimeException("无当前检查项");
        }
        checkItem.setId(id);
        checkItemMapper.edit(checkItem);


    }

    /**
     * 根据条件查询,带分页
     *
     * @param checkItem
     * @param page
     * @param size
     * @return
     */
    @Override
    public PageResult<CheckItem> search(CheckItem checkItem, Integer page, Integer size) {
        //参数校验
        if (page == null) {
            page = 1;
        }
        if (size == null) {
            size = 10;
        }

        //业务处理
        PageHelper.startPage(page, size);
        Page<CheckItem> pageResult = (Page<CheckItem>) checkItemMapper.search(checkItem);

        //处理结果
        long total = pageResult.getTotal();

        if (pageResult.getTotal() == 0) {
            log.error("CheckItemServiceImpl edit is error, findById is null");
            throw new RuntimeException("无数据");
            /* LOGGER.error("无数据");*/
        }

        PageResult<CheckItem> result = new PageResult<>();
        result.setRows(pageResult.getResult());
        result.setTotal(pageResult.getTotal());
        result.setTotalPages(pageResult.getPages());

        return result;
    }
}
