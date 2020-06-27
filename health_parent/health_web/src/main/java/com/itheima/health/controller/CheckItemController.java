package com.itheima.health.controller;

import com.alibaba.dubbo.config.annotation.Reference;
import com.itheima.health.pojo.CheckItem;
import com.itheima.health.response.PageResult;
import com.itheima.health.response.Result;
import com.itheima.health.response.constant.CodeConstant;
import com.itheima.health.response.constant.MessageConstant;
import com.itheima.health.service.CheckItemService;
import org.springframework.web.bind.annotation.*;

import java.util.List;


@RestController// 组合注解：包含@Controller、@ResponseBody
@RequestMapping("checkItem")
public class CheckItemController {

    @Reference
    CheckItemService checkItemService;

    /**
     * 查询所有
     *
     * @return
     */
    @GetMapping
    public List<CheckItem> findAll() {
        List<CheckItem> list = checkItemService.findAll();
        return list;
    }

    /**
     * 根据id查询
     *
     * @param id
     * @return
     */
    @GetMapping("/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        CheckItem checkItem = checkItemService.findById(id);
        return new Result(checkItem);
    }

    /**
     * 添加
     */
    @PostMapping
    public Result add(@RequestBody CheckItem checkItem) {
        CheckItem item = checkItemService.add(checkItem);
        return new Result(item);
    }

    /**
     * 删除
     */
    @DeleteMapping("/{id}")
    public Result delete(@PathVariable("id") Integer id) {
        checkItemService.delete(id);
        return new Result(null);
    }

    /**
     * 更新
     */
    @PutMapping("/{id}")
    public Result edit(@PathVariable("id") Integer id, @RequestBody CheckItem checkItem) {
        checkItemService.edit(id, checkItem);
        return new Result(null);
    }

    /**
     * 根据条件查询
     * 分页
     */
    @PostMapping("/{page}{size}")
    public Result search(@RequestBody CheckItem checkItem,
                         @PathVariable("page") Integer page,
                         @PathVariable("size") Integer size) {
        PageResult<CheckItem> result = checkItemService.search(checkItem, page, size);
        //封装结果
        return new Result(CodeConstant.CHECKITEM_CODE_SUCCESS,
                MessageConstant.QUERY_CHECKITEM_SUCCESS, true, result);
    }

}
