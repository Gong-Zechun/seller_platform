package com.seller.service;

import java.util.List;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import com.seller.extendEntity.dao.TaskExtendMapper;
import com.seller.extendEntity.vo.TaskVo;

/**
 * 类功能描述：任务service
 *
 * @author Allen Gong
 * @version 1.0
 * @history 2017-10-11 Allen Gong 创建
 */
@Service
public class TaskService {
    @Resource
    private TaskExtendMapper taskExtendMapper;

    /**
     * 获取待处理任务
     * @param taskVo
     */
    public List<TaskVo> getUnProcessTask(TaskVo taskVo) {
        return taskExtendMapper.getUnProcessTask(taskVo);
    }
}
