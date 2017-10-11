package com.seller.extendEntity.vo;

import java.util.Date;

import com.seller.entity.model.Task;
import com.seller.entity.model.TaskGroup;

/**
 * 类功能描述：Task类拓展类
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-10-9 Allen Gong 创建
 */
public class TaskVo extends Task {

    private static final long serialVersionUID = 1372596422015229707L;

    /**
     * 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务（同TaskGroup类taskType属性）
     */
    private String taskType;

    /**
     * 店铺掌柜ID（同TaskGroup类sellerShopId属性）
     */
    private String sellerShopId;

    /**
     * 接单开始时间
     */
    public Date acceptOrderTimeStart;

    /**
     * 接单结束时间
     */
    public Date acceptOrderTimeEnd;

    public Date getAcceptOrderTimeStart() {
        return acceptOrderTimeStart;
    }

    public void setAcceptOrderTimeStart(Date acceptOrderTimeStart) {
        this.acceptOrderTimeStart = acceptOrderTimeStart;
    }

    public Date getAcceptOrderTimeEnd() {
        return acceptOrderTimeEnd;
    }

    public void setAcceptOrderTimeEnd(Date acceptOrderTimeEnd) {
        this.acceptOrderTimeEnd = acceptOrderTimeEnd;
    }

    public String getTaskType() {
        return taskType;
    }

    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    public String getSellerShopId() {
        return sellerShopId;
    }

    public void setSellerShopId(String sellerShopId) {
        this.sellerShopId = sellerShopId;
    }
}
