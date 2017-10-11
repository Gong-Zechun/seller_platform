package com.seller.entity.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 类功能描述:实体Model
 * 
 * @history 2017-09-01 Allen Gong 创建
 * 
 * @author Allen Gong
 * @version 1.0 
 * [1.0] 2017-09-01 Allen Gong add 根据表结构生成Model<br>
 */
public class Task extends com.seller.page.AbstractPageEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 任务组ID
     */
    private Integer taskGroupId;

    /**
     * 字典表的时间段ID
     */
    private Integer publishTimeId;

    /**
     * 发布数量
     */
    private Integer publishAmount;

    /**
     * 买手ID
     */
    private Integer buyerId;

    /**
     * 任务状态：
 0:进行中；1:等待收货；2:等待买手浏览；3:买手已完成，待商家确认；4:待调解；5:已驳回，待商家确认；6:超时失效；7:调解完成，已退款；8:完成
     */
    private String status;

    /**
     * 淘宝订单编号
     */
    private String taobaoOrderNo;

    /**
     * 买手接单时间
     */
    private Date acceptOrderTime;

    /**
     * 创建者
     */
    private Integer createBy;

    /**
     * 创建时间
     */
    private Date createTime;

    /**
     * 更新者
     */
    private Integer updateBy;

    /**
     * 更新时间
     */
    private Date updateTime;

    /**
     * 备注信息
     */
    private String remarks;

    /**
     * 删除标记
     */
    private String delFlag;

    /**
     * TASK
     */
    private static final long serialVersionUID = 1L;

    /**
     * 编号
     * @return ID 编号
     */
    public Integer getId() {
        return id;
    }

    /**
     * 编号
     * @param id 编号
     */
    public void setId(Integer id) {
        this.id = id;
    }

    /**
     * 任务组ID
     * @return TASK_GROUP_ID 任务组ID
     */
    public Integer getTaskGroupId() {
        return taskGroupId;
    }

    /**
     * 任务组ID
     * @param taskGroupId 任务组ID
     */
    public void setTaskGroupId(Integer taskGroupId) {
        this.taskGroupId = taskGroupId;
    }

    /**
     * 字典表的时间段ID
     * @return PUBLISH_TIME_ID 字典表的时间段ID
     */
    public Integer getPublishTimeId() {
        return publishTimeId;
    }

    /**
     * 字典表的时间段ID
     * @param publishTimeId 字典表的时间段ID
     */
    public void setPublishTimeId(Integer publishTimeId) {
        this.publishTimeId = publishTimeId;
    }

    /**
     * 发布数量
     * @return PUBLISH_AMOUNT 发布数量
     */
    public Integer getPublishAmount() {
        return publishAmount;
    }

    /**
     * 发布数量
     * @param publishAmount 发布数量
     */
    public void setPublishAmount(Integer publishAmount) {
        this.publishAmount = publishAmount;
    }

    /**
     * 买手ID
     * @return BUYER_ID 买手ID
     */
    public Integer getBuyerId() {
        return buyerId;
    }

    /**
     * 买手ID
     * @param buyerId 买手ID
     */
    public void setBuyerId(Integer buyerId) {
        this.buyerId = buyerId;
    }

    /**
     * 任务状态：
 0:进行中；1:等待收货；2:等待买手浏览；3:买手已完成，待商家确认；4:待调解；5:已驳回，待商家确认；6:超时失效；7:调解完成，已退款；8:完成
     * @return STATUS 任务状态：
 0:进行中；1:等待收货；2:等待买手浏览；3:买手已完成，待商家确认；4:待调解；5:已驳回，待商家确认；6:超时失效；7:调解完成，已退款；8:完成
     */
    public String getStatus() {
        return status;
    }

    /**
     * 任务状态：
 0:进行中；1:等待收货；2:等待买手浏览；3:买手已完成，待商家确认；4:待调解；5:已驳回，待商家确认；6:超时失效；7:调解完成，已退款；8:完成
     * @param status 任务状态：
 0:进行中；1:等待收货；2:等待买手浏览；3:买手已完成，待商家确认；4:待调解；5:已驳回，待商家确认；6:超时失效；7:调解完成，已退款；8:完成
     */
    public void setStatus(String status) {
        this.status = status;
    }

    /**
     * 淘宝订单编号
     * @return TAOBAO_ORDER_NO 淘宝订单编号
     */
    public String getTaobaoOrderNo() {
        return taobaoOrderNo;
    }

    /**
     * 淘宝订单编号
     * @param taobaoOrderNo 淘宝订单编号
     */
    public void setTaobaoOrderNo(String taobaoOrderNo) {
        this.taobaoOrderNo = taobaoOrderNo;
    }

    /**
     * 买手接单时间
     * @return ACCEPT_ORDER_TIME 买手接单时间
     */
    public Date getAcceptOrderTime() {
        return acceptOrderTime;
    }

    /**
     * 买手接单时间
     * @param acceptOrderTime 买手接单时间
     */
    public void setAcceptOrderTime(Date acceptOrderTime) {
        this.acceptOrderTime = acceptOrderTime;
    }

    /**
     * 创建者
     * @return CREATE_BY 创建者
     */
    public Integer getCreateBy() {
        return createBy;
    }

    /**
     * 创建者
     * @param createBy 创建者
     */
    public void setCreateBy(Integer createBy) {
        this.createBy = createBy;
    }

    /**
     * 创建时间
     * @return CREATE_TIME 创建时间
     */
    public Date getCreateTime() {
        return createTime;
    }

    /**
     * 创建时间
     * @param createTime 创建时间
     */
    public void setCreateTime(Date createTime) {
        this.createTime = createTime;
    }

    /**
     * 更新者
     * @return UPDATE_BY 更新者
     */
    public Integer getUpdateBy() {
        return updateBy;
    }

    /**
     * 更新者
     * @param updateBy 更新者
     */
    public void setUpdateBy(Integer updateBy) {
        this.updateBy = updateBy;
    }

    /**
     * 更新时间
     * @return UPDATE_TIME 更新时间
     */
    public Date getUpdateTime() {
        return updateTime;
    }

    /**
     * 更新时间
     * @param updateTime 更新时间
     */
    public void setUpdateTime(Date updateTime) {
        this.updateTime = updateTime;
    }

    /**
     * 备注信息
     * @return REMARKS 备注信息
     */
    public String getRemarks() {
        return remarks;
    }

    /**
     * 备注信息
     * @param remarks 备注信息
     */
    public void setRemarks(String remarks) {
        this.remarks = remarks;
    }

    /**
     * 删除标记
     * @return DEL_FLAG 删除标记
     */
    public String getDelFlag() {
        return delFlag;
    }

    /**
     * 删除标记
     * @param delFlag 删除标记
     */
    public void setDelFlag(String delFlag) {
        this.delFlag = delFlag;
    }

    /**
     *
     * @mbg.generated
     */
    @Override
    public boolean equals(Object that) {
        if (this == that) {
            return true;
        }
        if (that == null) {
            return false;
        }
        if (getClass() != that.getClass()) {
            return false;
        }
        Task other = (Task) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getTaskGroupId() == null ? other.getTaskGroupId() == null : this.getTaskGroupId().equals(other.getTaskGroupId()))
            && (this.getPublishTimeId() == null ? other.getPublishTimeId() == null : this.getPublishTimeId().equals(other.getPublishTimeId()))
            && (this.getPublishAmount() == null ? other.getPublishAmount() == null : this.getPublishAmount().equals(other.getPublishAmount()))
            && (this.getBuyerId() == null ? other.getBuyerId() == null : this.getBuyerId().equals(other.getBuyerId()))
            && (this.getStatus() == null ? other.getStatus() == null : this.getStatus().equals(other.getStatus()))
            && (this.getTaobaoOrderNo() == null ? other.getTaobaoOrderNo() == null : this.getTaobaoOrderNo().equals(other.getTaobaoOrderNo()))
            && (this.getAcceptOrderTime() == null ? other.getAcceptOrderTime() == null : this.getAcceptOrderTime().equals(other.getAcceptOrderTime()))
            && (this.getCreateBy() == null ? other.getCreateBy() == null : this.getCreateBy().equals(other.getCreateBy()))
            && (this.getCreateTime() == null ? other.getCreateTime() == null : this.getCreateTime().equals(other.getCreateTime()))
            && (this.getUpdateBy() == null ? other.getUpdateBy() == null : this.getUpdateBy().equals(other.getUpdateBy()))
            && (this.getUpdateTime() == null ? other.getUpdateTime() == null : this.getUpdateTime().equals(other.getUpdateTime()))
            && (this.getRemarks() == null ? other.getRemarks() == null : this.getRemarks().equals(other.getRemarks()))
            && (this.getDelFlag() == null ? other.getDelFlag() == null : this.getDelFlag().equals(other.getDelFlag()));
    }

    /**
     *
     * @mbg.generated
     */
    @Override
    public int hashCode() {
        final int prime = 31;
        int result = 1;
        result = prime * result + ((getId() == null) ? 0 : getId().hashCode());
        result = prime * result + ((getTaskGroupId() == null) ? 0 : getTaskGroupId().hashCode());
        result = prime * result + ((getPublishTimeId() == null) ? 0 : getPublishTimeId().hashCode());
        result = prime * result + ((getPublishAmount() == null) ? 0 : getPublishAmount().hashCode());
        result = prime * result + ((getBuyerId() == null) ? 0 : getBuyerId().hashCode());
        result = prime * result + ((getStatus() == null) ? 0 : getStatus().hashCode());
        result = prime * result + ((getTaobaoOrderNo() == null) ? 0 : getTaobaoOrderNo().hashCode());
        result = prime * result + ((getAcceptOrderTime() == null) ? 0 : getAcceptOrderTime().hashCode());
        result = prime * result + ((getCreateBy() == null) ? 0 : getCreateBy().hashCode());
        result = prime * result + ((getCreateTime() == null) ? 0 : getCreateTime().hashCode());
        result = prime * result + ((getUpdateBy() == null) ? 0 : getUpdateBy().hashCode());
        result = prime * result + ((getUpdateTime() == null) ? 0 : getUpdateTime().hashCode());
        result = prime * result + ((getRemarks() == null) ? 0 : getRemarks().hashCode());
        result = prime * result + ((getDelFlag() == null) ? 0 : getDelFlag().hashCode());
        return result;
    }

    /**
     *
     * @mbg.generated
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append(getClass().getSimpleName());
        sb.append(" [");
        sb.append("Hash = ").append(hashCode());
        sb.append(", id=").append(id);
        sb.append(", taskGroupId=").append(taskGroupId);
        sb.append(", publishTimeId=").append(publishTimeId);
        sb.append(", publishAmount=").append(publishAmount);
        sb.append(", buyerId=").append(buyerId);
        sb.append(", status=").append(status);
        sb.append(", taobaoOrderNo=").append(taobaoOrderNo);
        sb.append(", acceptOrderTime=").append(acceptOrderTime);
        sb.append(", createBy=").append(createBy);
        sb.append(", createTime=").append(createTime);
        sb.append(", updateBy=").append(updateBy);
        sb.append(", updateTime=").append(updateTime);
        sb.append(", remarks=").append(remarks);
        sb.append(", delFlag=").append(delFlag);
        sb.append(", serialVersionUID=").append(serialVersionUID);
        sb.append("]");
        return sb.toString();
    }
}