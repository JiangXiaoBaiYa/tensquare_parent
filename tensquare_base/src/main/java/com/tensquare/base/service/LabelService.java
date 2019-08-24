package com.tensquare.base.service;

/**
 * @Author: 姜光明
 * @Date: 2019/8/24 22:12
 */

import com.tensquare.base.dao.LabelDao;
import com.tensquare.base.pojo.Label;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import util.IdWorker;

import java.util.List;

/**
 * 标签业务逻辑类
 */
@Service
public class LabelService {
    @Autowired
    private LabelDao labelDao;
    @Autowired
    private IdWorker idWorker;

    /**
     * 查询全部标签
     */
    public List<Label> findAll() {
        return labelDao.findAll();
    }

    /**
     * 根据ID查询标签
     */
    public Label findById(String id) {
        return labelDao.findById(id).get();
    }

    /**
     * 增加标签
     */
    public void add(Label label) {
        label.setId(idWorker.nextId() + "");
        labelDao.save(label);
    }

    /**
     * 修改标签
     */
    public void update(Label label) {
        labelDao.save(label);
    }

    /**
     * 删除标签
     */
    public void deleteById(String id) {
        labelDao.deleteById(id);
    }
}
