package com.seller.extendEntity.dao;

import java.util.List;

import com.seller.extendEntity.vo.TaskVo;

/**
 * 类功能描述：任务拓宽Mapper
 *
 * @author Allen Gong
 * @version 1.0
 * @history 2017-10-11 Allen Gong 创建
 */
public interface TaskExtendMapper {

    /**
     * 获取待处理任务
     * @param taskGroupVo
     * @return
     */
    List<TaskVo> getUnProcessTask(TaskVo taskGroupVo);
}
