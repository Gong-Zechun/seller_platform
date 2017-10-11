package com.seller.service;

import com.seller.constants.Constants;
import com.seller.entity.dao.TaskGroupTemplateMapper;
import com.seller.entity.model.TaskGroupTemplate;
import com.seller.entity.model.TaskGroupTemplateExample;
import org.apache.commons.collections.CollectionUtils;
import org.springframework.stereotype.Service;

import javax.annotation.Resource;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述：任务组模板表Service
 *
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-9-5 Allen Gong 创建
 */
@Service
public class TaskGroupTemplateService {
    @Resource
    private TaskGroupTemplateMapper taskGroupTemplateMapper;

    /**
     * 获取模板名称List
     * @param userId
     * @return
     */
    public List<TaskGroupTemplate> getTemplateName(int userId) {
        List<TaskGroupTemplate> tempList = getTemplateByUserId(userId);
        if(CollectionUtils.isEmpty(tempList)) {
            return null;
        }
        List<TaskGroupTemplate> taskGroupTemplateList = new ArrayList<>();
        for(TaskGroupTemplate meta : tempList) {
            TaskGroupTemplate taskGroupTemplate = new TaskGroupTemplate();
            taskGroupTemplate.setTemplateName(meta.getTemplateName());
            taskGroupTemplateList.add(taskGroupTemplate);
        }
        return taskGroupTemplateList;
    }

    /**
     * 获取模板List
     * @param userId
     * @return
     */
    public List<TaskGroupTemplate> getTemplateByUserId(int userId) {
        TaskGroupTemplateExample example = new TaskGroupTemplateExample();
        TaskGroupTemplateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(userId).andDelFlagEqualTo(Constants.FLAG_FALSE);

        return taskGroupTemplateMapper.selectByExample(example);
    }

    /**
     * 获取模板详情
     * @param taskGroupTemplate
     * @return
     */
    public TaskGroupTemplate getTemplateDetail(TaskGroupTemplate taskGroupTemplate) {
        TaskGroupTemplateExample example = new TaskGroupTemplateExample();
        TaskGroupTemplateExample.Criteria criteria = example.createCriteria();
        criteria.andUserIdEqualTo(taskGroupTemplate.getUserId())
                .andTemplateNameEqualTo(taskGroupTemplate.getTemplateName())
                .andDelFlagEqualTo(Constants.FLAG_FALSE);

        List<TaskGroupTemplate> taskGroupTemplateList = taskGroupTemplateMapper.selectByExample(example);
        if(CollectionUtils.isEmpty(taskGroupTemplateList)) {
            return null;
        }
        return taskGroupTemplateList.get(0);
    }

    /**
     * 新增模板
     * @param taskGroupTemplate
     * @return
     */
    public int addNewTemplate(TaskGroupTemplate taskGroupTemplate) {
        return taskGroupTemplateMapper.insertSelective(taskGroupTemplate);
    }
}
