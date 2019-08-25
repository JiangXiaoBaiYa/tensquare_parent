package com.tensquare.base.controller;

/**
 * @Author: 姜光明
 * @Date: 2019/8/24 22:59
 */

import com.tensquare.base.pojo.Label;
import com.tensquare.base.service.LabelService;
import entity.PageResult;
import entity.Result;
import entity.StatusCode;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.web.bind.annotation.*;

import java.util.List;
import java.util.Map;

/**
 * 标签控制层
 */
@RestController
@RequestMapping("/label")
public class LabelController {
    @Autowired
    private LabelService labelService;

    /**
     * 查询全部列表
     */
    @RequestMapping(method = RequestMethod.GET)
    public Result<List> findAll() {
        return new Result<>(true, StatusCode.OK,"查询成功",labelService.findAll());
    }

    /**
     * 根据ID查询标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.GET)
    public Result<Label> findById(@PathVariable String id) {
        return new Result<>(true, StatusCode.OK, "查询成功", labelService.findById(id));
    }

    /**
     * 增加标签
     */
    @RequestMapping(method = RequestMethod.POST)
    public Result add(@RequestBody Label label) {
        labelService.add(label);
        return new Result(true, StatusCode.OK, "增加成功");
    }

    /**
     * 修改标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.PUT)
    public Result update(@RequestBody Label label, @PathVariable String id) {
        label.setId(id);
        labelService.update(label);
        return new Result(true, StatusCode.OK, "修改成功");
    }

    /**
     * 删除标签
     */
    @RequestMapping(value = "/{id}", method = RequestMethod.DELETE)
    public Result deleteById(@PathVariable String id) {
        labelService.deleteById(id);
        return new Result(true, StatusCode.OK, "删除成功");
    }

    /**
     * 根据条件查询
     */
    @RequestMapping(value = "/search", method = RequestMethod.GET)
    public Result<List> findSearch(@RequestBody Map searchmap) {
        return new Result<>(true, StatusCode.OK, "查询成功", labelService.findSearch(searchmap));
    }

    /**
     * 带分页的条件查询
     */
    public Result<List> findSearch(@RequestBody Map searchMap, @PathVariable int page, @PathVariable int size) {
        Page<Label> pageList = labelService.findSearch(searchMap, page, size);
        return new Result<>(true, StatusCode.OK, "查询成功", new PageResult<>(pageList.getTotalElements(), pageList.getContent()));
    }
}
