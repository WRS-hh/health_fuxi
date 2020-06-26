package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * @Description:
 * @Version: V1.0
 */
@RestController   // 组合注解：包含@Controller、@ResponseBody
public class CheckItemController {

    @Reference
    CheckItemService checkItemService;


    //@RequestMapping(value = "findAll", method = RequestMethod.GET)  // 支持的请求方式有几种？ 是否支持GET请求？
    @GetMapping("findAll")
    public List<CheckItem> findAll() {
        List<CheckItem> list = checkItemService.findAll();
        return list;
    }


}
