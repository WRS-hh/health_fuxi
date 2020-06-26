package com.itheima.health.service.impl;

import com.alibaba.dubbo.config.annotation.Service;
import com.itheima.health.mapper.CheckItemMapper;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.beans.factory.annotation.Autowired;

import java.util.List;

/**
 * @Description:
 * @Version: V1.0
 */
@Service(interfaceClass = CheckItemService.class)
public class CheckItemServiceImpl implements CheckItemService {

    @Autowired
    CheckItemMapper checkItemMapper;

    /**
     * 查询所有
     * @return
     */
    @Override
    public List<CheckItem> findAll() {
        List<CheckItem> list = checkItemMapper.findAll();
        return list;
    }
}
