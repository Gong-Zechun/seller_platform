package com.seller.entity.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 类功能描述:实体Model
 * 
 * @history 2017-09-05 Allen Gong 创建
 * 
 * @author Allen Gong
 * @version 1.0 
 * [1.0] 2017-09-05 Allen Gong add 根据表结构生成Model<br>
 */
public class TaskGroupTemplate extends com.seller.page.AbstractPageEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 商家用户ID
     */
    private Integer userId;

    /**
     * 模板名称
     */
    private String templateName;

    /**
     * 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务
     */
    private String taskType;

    /**
     * 做单入口：1:手机淘宝；2:手机天猫；3:手机直通车；
 4:电脑淘宝；5:电脑天猫；6:电脑直通车
     */
    private String taskEntrance;

    /**
     * 宝贝链接
     */
    private String goodsUrl;

    /**
     * 宝贝标题
     */
    private String goodsTitle;

    /**
     * 店铺掌柜ID
     */
    private String sellerShopId;

    /**
     * 搜索关键词
     */
    private String searchKeyword;

    /**
     * 上传卡条件图
     */
    private String conditionImgUrl;

    /**
     * 搜索截图
     */
    private String searchImgUrl;

    /**
     * 停留时间：0:没有要求；1:1分钟；2:2分钟；3:3分钟
     */
    private String stayTime;

    /**
     * 是否与客服聊天：0:不聊；1:聊
     */
    private String customServiceChatFlag;

    /**
     * 要求买手性别：0:女；1:男；
     */
    private String conditionSexual;

    /**
     * 要求买手年龄：1:18-24；1:25-30；
     */
    private String conditionAge;

    /**
     * 附加选项：1:浏览后收藏宝贝；2:浏览后加入购物车(需上传SKU)；3:浏览后收藏店铺；
 4:浏览后分享二维码；5:浏览后分享淘口令(可以多选)
     */
    private String additionalChoose;

    /**
     * 发布时间(例：2017-01-01)
     */
    private Date publishDate;

    /**
     * 发布数量
     */
    private Integer publishAmount;

    /**
     * 发布时段:
 3:4|5:1（表示03:00有4个任务，05:00有1个任务）
     */
    private String publishTimePeriod;

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
     * TASK_GROUP_TEMPLATE
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
     * 商家用户ID
     * @return USER_ID 商家用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 商家用户ID
     * @param userId 商家用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 模板名称
     * @return TEMPLATE_NAME 模板名称
     */
    public String getTemplateName() {
        return templateName;
    }

    /**
     * 模板名称
     * @param templateName 模板名称
     */
    public void setTemplateName(String templateName) {
        this.templateName = templateName;
    }

    /**
     * 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务
     * @return TASK_TYPE 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务
     */
    public String getTaskType() {
        return taskType;
    }

    /**
     * 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务
     * @param taskType 任务组类型：1:浏览任务；2:定向回购；3:普通付款任务
     */
    public void setTaskType(String taskType) {
        this.taskType = taskType;
    }

    /**
     * 做单入口：1:手机淘宝；2:手机天猫；3:手机直通车；
 4:电脑淘宝；5:电脑天猫；6:电脑直通车
     * @return TASK_ENTRANCE 做单入口：1:手机淘宝；2:手机天猫；3:手机直通车；
 4:电脑淘宝；5:电脑天猫；6:电脑直通车
     */
    public String getTaskEntrance() {
        return taskEntrance;
    }

    /**
     * 做单入口：1:手机淘宝；2:手机天猫；3:手机直通车；
 4:电脑淘宝；5:电脑天猫；6:电脑直通车
     * @param taskEntrance 做单入口：1:手机淘宝；2:手机天猫；3:手机直通车；
 4:电脑淘宝；5:电脑天猫；6:电脑直通车
     */
    public void setTaskEntrance(String taskEntrance) {
        this.taskEntrance = taskEntrance;
    }

    /**
     * 宝贝链接
     * @return GOODS_URL 宝贝链接
     */
    public String getGoodsUrl() {
        return goodsUrl;
    }

    /**
     * 宝贝链接
     * @param goodsUrl 宝贝链接
     */
    public void setGoodsUrl(String goodsUrl) {
        this.goodsUrl = goodsUrl;
    }

    /**
     * 宝贝标题
     * @return GOODS_TITLE 宝贝标题
     */
    public String getGoodsTitle() {
        return goodsTitle;
    }

    /**
     * 宝贝标题
     * @param goodsTitle 宝贝标题
     */
    public void setGoodsTitle(String goodsTitle) {
        this.goodsTitle = goodsTitle;
    }

    /**
     * 店铺掌柜ID
     * @return SELLER_SHOP_ID 店铺掌柜ID
     */
    public String getSellerShopId() {
        return sellerShopId;
    }

    /**
     * 店铺掌柜ID
     * @param sellerShopId 店铺掌柜ID
     */
    public void setSellerShopId(String sellerShopId) {
        this.sellerShopId = sellerShopId;
    }

    /**
     * 搜索关键词
     * @return SEARCH_KEYWORD 搜索关键词
     */
    public String getSearchKeyword() {
        return searchKeyword;
    }

    /**
     * 搜索关键词
     * @param searchKeyword 搜索关键词
     */
    public void setSearchKeyword(String searchKeyword) {
        this.searchKeyword = searchKeyword;
    }

    /**
     * 上传卡条件图
     * @return CONDITION_IMG_URL 上传卡条件图
     */
    public String getConditionImgUrl() {
        return conditionImgUrl;
    }

    /**
     * 上传卡条件图
     * @param conditionImgUrl 上传卡条件图
     */
    public void setConditionImgUrl(String conditionImgUrl) {
        this.conditionImgUrl = conditionImgUrl;
    }

    /**
     * 搜索截图
     * @return SEARCH_IMG_URL 搜索截图
     */
    public String getSearchImgUrl() {
        return searchImgUrl;
    }

    /**
     * 搜索截图
     * @param searchImgUrl 搜索截图
     */
    public void setSearchImgUrl(String searchImgUrl) {
        this.searchImgUrl = searchImgUrl;
    }

    /**
     * 停留时间：0:没有要求；1:1分钟；2:2分钟；3:3分钟
     * @return STAY_TIME 停留时间：0:没有要求；1:1分钟；2:2分钟；3:3分钟
     */
    public String getStayTime() {
        return stayTime;
    }

    /**
     * 停留时间：0:没有要求；1:1分钟；2:2分钟；3:3分钟
     * @param stayTime 停留时间：0:没有要求；1:1分钟；2:2分钟；3:3分钟
     */
    public void setStayTime(String stayTime) {
        this.stayTime = stayTime;
    }

    /**
     * 是否与客服聊天：0:不聊；1:聊
     * @return CUSTOM_SERVICE_CHAT_FLAG 是否与客服聊天：0:不聊；1:聊
     */
    public String getCustomServiceChatFlag() {
        return customServiceChatFlag;
    }

    /**
     * 是否与客服聊天：0:不聊；1:聊
     * @param customServiceChatFlag 是否与客服聊天：0:不聊；1:聊
     */
    public void setCustomServiceChatFlag(String customServiceChatFlag) {
        this.customServiceChatFlag = customServiceChatFlag;
    }

    /**
     * 要求买手性别：0:女；1:男；
     * @return CONDITION_SEXUAL 要求买手性别：0:女；1:男；
     */
    public String getConditionSexual() {
        return conditionSexual;
    }

    /**
     * 要求买手性别：0:女；1:男；
     * @param conditionSexual 要求买手性别：0:女；1:男；
     */
    public void setConditionSexual(String conditionSexual) {
        this.conditionSexual = conditionSexual;
    }

    /**
     * 要求买手年龄：1:18-24；1:25-30；
     * @return CONDITION_AGE 要求买手年龄：1:18-24；1:25-30；
     */
    public String getConditionAge() {
        return conditionAge;
    }

    /**
     * 要求买手年龄：1:18-24；1:25-30；
     * @param conditionAge 要求买手年龄：1:18-24；1:25-30；
     */
    public void setConditionAge(String conditionAge) {
        this.conditionAge = conditionAge;
    }

    /**
     * 附加选项：1:浏览后收藏宝贝；2:浏览后加入购物车(需上传SKU)；3:浏览后收藏店铺；
 4:浏览后分享二维码；5:浏览后分享淘口令(可以多选)
     * @return ADDITIONAL_CHOOSE 附加选项：1:浏览后收藏宝贝；2:浏览后加入购物车(需上传SKU)；3:浏览后收藏店铺；
 4:浏览后分享二维码；5:浏览后分享淘口令(可以多选)
     */
    public String getAdditionalChoose() {
        return additionalChoose;
    }

    /**
     * 附加选项：1:浏览后收藏宝贝；2:浏览后加入购物车(需上传SKU)；3:浏览后收藏店铺；
 4:浏览后分享二维码；5:浏览后分享淘口令(可以多选)
     * @param additionalChoose 附加选项：1:浏览后收藏宝贝；2:浏览后加入购物车(需上传SKU)；3:浏览后收藏店铺；
 4:浏览后分享二维码；5:浏览后分享淘口令(可以多选)
     */
    public void setAdditionalChoose(String additionalChoose) {
        this.additionalChoose = additionalChoose;
    }

    /**
     * 发布时间(例：2017-01-01)
     * @return PUBLISH_DATE 发布时间(例：2017-01-01)
     */
    public Date getPublishDate() {
        return publishDate;
    }

    /**
     * 发布时间(例：2017-01-01)
     * @param publishDate 发布时间(例：2017-01-01)
     */
    public void setPublishDate(Date publishDate) {
        this.publishDate = publishDate;
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
     * 发布时段:
 3:4|5:1（表示03:00有4个任务，05:00有1个任务）
     * @return PUBLISH_TIME_PERIOD 发布时段:
 3:4|5:1（表示03:00有4个任务，05:00有1个任务）
     */
    public String getPublishTimePeriod() {
        return publishTimePeriod;
    }

    /**
     * 发布时段:
 3:4|5:1（表示03:00有4个任务，05:00有1个任务）
     * @param publishTimePeriod 发布时段:
 3:4|5:1（表示03:00有4个任务，05:00有1个任务）
     */
    public void setPublishTimePeriod(String publishTimePeriod) {
        this.publishTimePeriod = publishTimePeriod;
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
        TaskGroupTemplate other = (TaskGroupTemplate) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getTemplateName() == null ? other.getTemplateName() == null : this.getTemplateName().equals(other.getTemplateName()))
            && (this.getTaskType() == null ? other.getTaskType() == null : this.getTaskType().equals(other.getTaskType()))
            && (this.getTaskEntrance() == null ? other.getTaskEntrance() == null : this.getTaskEntrance().equals(other.getTaskEntrance()))
            && (this.getGoodsUrl() == null ? other.getGoodsUrl() == null : this.getGoodsUrl().equals(other.getGoodsUrl()))
            && (this.getGoodsTitle() == null ? other.getGoodsTitle() == null : this.getGoodsTitle().equals(other.getGoodsTitle()))
            && (this.getSellerShopId() == null ? other.getSellerShopId() == null : this.getSellerShopId().equals(other.getSellerShopId()))
            && (this.getSearchKeyword() == null ? other.getSearchKeyword() == null : this.getSearchKeyword().equals(other.getSearchKeyword()))
            && (this.getConditionImgUrl() == null ? other.getConditionImgUrl() == null : this.getConditionImgUrl().equals(other.getConditionImgUrl()))
            && (this.getSearchImgUrl() == null ? other.getSearchImgUrl() == null : this.getSearchImgUrl().equals(other.getSearchImgUrl()))
            && (this.getStayTime() == null ? other.getStayTime() == null : this.getStayTime().equals(other.getStayTime()))
            && (this.getCustomServiceChatFlag() == null ? other.getCustomServiceChatFlag() == null : this.getCustomServiceChatFlag().equals(other.getCustomServiceChatFlag()))
            && (this.getConditionSexual() == null ? other.getConditionSexual() == null : this.getConditionSexual().equals(other.getConditionSexual()))
            && (this.getConditionAge() == null ? other.getConditionAge() == null : this.getConditionAge().equals(other.getConditionAge()))
            && (this.getAdditionalChoose() == null ? other.getAdditionalChoose() == null : this.getAdditionalChoose().equals(other.getAdditionalChoose()))
            && (this.getPublishDate() == null ? other.getPublishDate() == null : this.getPublishDate().equals(other.getPublishDate()))
            && (this.getPublishAmount() == null ? other.getPublishAmount() == null : this.getPublishAmount().equals(other.getPublishAmount()))
            && (this.getPublishTimePeriod() == null ? other.getPublishTimePeriod() == null : this.getPublishTimePeriod().equals(other.getPublishTimePeriod()))
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
        result = prime * result + ((getUserId() == null) ? 0 : getUserId().hashCode());
        result = prime * result + ((getTemplateName() == null) ? 0 : getTemplateName().hashCode());
        result = prime * result + ((getTaskType() == null) ? 0 : getTaskType().hashCode());
        result = prime * result + ((getTaskEntrance() == null) ? 0 : getTaskEntrance().hashCode());
        result = prime * result + ((getGoodsUrl() == null) ? 0 : getGoodsUrl().hashCode());
        result = prime * result + ((getGoodsTitle() == null) ? 0 : getGoodsTitle().hashCode());
        result = prime * result + ((getSellerShopId() == null) ? 0 : getSellerShopId().hashCode());
        result = prime * result + ((getSearchKeyword() == null) ? 0 : getSearchKeyword().hashCode());
        result = prime * result + ((getConditionImgUrl() == null) ? 0 : getConditionImgUrl().hashCode());
        result = prime * result + ((getSearchImgUrl() == null) ? 0 : getSearchImgUrl().hashCode());
        result = prime * result + ((getStayTime() == null) ? 0 : getStayTime().hashCode());
        result = prime * result + ((getCustomServiceChatFlag() == null) ? 0 : getCustomServiceChatFlag().hashCode());
        result = prime * result + ((getConditionSexual() == null) ? 0 : getConditionSexual().hashCode());
        result = prime * result + ((getConditionAge() == null) ? 0 : getConditionAge().hashCode());
        result = prime * result + ((getAdditionalChoose() == null) ? 0 : getAdditionalChoose().hashCode());
        result = prime * result + ((getPublishDate() == null) ? 0 : getPublishDate().hashCode());
        result = prime * result + ((getPublishAmount() == null) ? 0 : getPublishAmount().hashCode());
        result = prime * result + ((getPublishTimePeriod() == null) ? 0 : getPublishTimePeriod().hashCode());
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
        sb.append(", userId=").append(userId);
        sb.append(", templateName=").append(templateName);
        sb.append(", taskType=").append(taskType);
        sb.append(", taskEntrance=").append(taskEntrance);
        sb.append(", goodsUrl=").append(goodsUrl);
        sb.append(", goodsTitle=").append(goodsTitle);
        sb.append(", sellerShopId=").append(sellerShopId);
        sb.append(", searchKeyword=").append(searchKeyword);
        sb.append(", conditionImgUrl=").append(conditionImgUrl);
        sb.append(", searchImgUrl=").append(searchImgUrl);
        sb.append(", stayTime=").append(stayTime);
        sb.append(", customServiceChatFlag=").append(customServiceChatFlag);
        sb.append(", conditionSexual=").append(conditionSexual);
        sb.append(", conditionAge=").append(conditionAge);
        sb.append(", additionalChoose=").append(additionalChoose);
        sb.append(", publishDate=").append(publishDate);
        sb.append(", publishAmount=").append(publishAmount);
        sb.append(", publishTimePeriod=").append(publishTimePeriod);
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