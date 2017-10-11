package com.seller.service;

import com.seller.entity.dao.TaskGroupMapper;
import com.seller.entity.model.TaskGroup;
import com.seller.entity.model.TaskGroupExample;
import com.util.DateUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;

/**
 * 类功能描述：任务组Service
 *
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-9-5 Allen Gong 创建
 */
@Service
public class TaskGroupService {
    @Resource
    private TaskGroupMapper taskGroupMapper;

    public int publishTaskGroup(TaskGroup taskGroup) {
        taskGroup.setUpdateTime(DateUtils.getCurrentDateTime());
        taskGroup.setCreateTime(DateUtils.getCurrentDateTime());
        return taskGroupMapper.insertSelective(taskGroup);
    }
}
