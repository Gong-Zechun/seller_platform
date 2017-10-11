package com.seller.entity.model;

import java.io.Serializable;
import java.math.BigDecimal;
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
public class RechargeRecord extends com.seller.page.AbstractPageEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 收款账户姓名
     */
    private String receiptAccountName;

    /**
     * 转账人电话
     */
    private String transferPersonPhone;

    /**
     * 转账金额
     */
    private BigDecimal transferAmount;

    /**
     * 转账截图URL
     */
    private String transferImgUrl;

    /**
     * 是否转账成功：0:未成功；1:成功；
     */
    private String finishFlag;

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
     * RECHARGE_RECORD
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
     * 收款账户姓名
     * @return RECEIPT_ACCOUNT_NAME 收款账户姓名
     */
    public String getReceiptAccountName() {
        return receiptAccountName;
    }

    /**
     * 收款账户姓名
     * @param receiptAccountName 收款账户姓名
     */
    public void setReceiptAccountName(String receiptAccountName) {
        this.receiptAccountName = receiptAccountName;
    }

    /**
     * 转账人电话
     * @return TRANSFER_PERSON_PHONE 转账人电话
     */
    public String getTransferPersonPhone() {
        return transferPersonPhone;
    }

    /**
     * 转账人电话
     * @param transferPersonPhone 转账人电话
     */
    public void setTransferPersonPhone(String transferPersonPhone) {
        this.transferPersonPhone = transferPersonPhone;
    }

    /**
     * 转账金额
     * @return TRANSFER_AMOUNT 转账金额
     */
    public BigDecimal getTransferAmount() {
        return transferAmount;
    }

    /**
     * 转账金额
     * @param transferAmount 转账金额
     */
    public void setTransferAmount(BigDecimal transferAmount) {
        this.transferAmount = transferAmount;
    }

    /**
     * 转账截图URL
     * @return TRANSFER_IMG_URL 转账截图URL
     */
    public String getTransferImgUrl() {
        return transferImgUrl;
    }

    /**
     * 转账截图URL
     * @param transferImgUrl 转账截图URL
     */
    public void setTransferImgUrl(String transferImgUrl) {
        this.transferImgUrl = transferImgUrl;
    }

    /**
     * 是否转账成功：0:未成功；1:成功；
     * @return FINISH_FLAG 是否转账成功：0:未成功；1:成功；
     */
    public String getFinishFlag() {
        return finishFlag;
    }

    /**
     * 是否转账成功：0:未成功；1:成功；
     * @param finishFlag 是否转账成功：0:未成功；1:成功；
     */
    public void setFinishFlag(String finishFlag) {
        this.finishFlag = finishFlag;
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
        RechargeRecord other = (RechargeRecord) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getReceiptAccountName() == null ? other.getReceiptAccountName() == null : this.getReceiptAccountName().equals(other.getReceiptAccountName()))
            && (this.getTransferPersonPhone() == null ? other.getTransferPersonPhone() == null : this.getTransferPersonPhone().equals(other.getTransferPersonPhone()))
            && (this.getTransferAmount() == null ? other.getTransferAmount() == null : this.getTransferAmount().equals(other.getTransferAmount()))
            && (this.getTransferImgUrl() == null ? other.getTransferImgUrl() == null : this.getTransferImgUrl().equals(other.getTransferImgUrl()))
            && (this.getFinishFlag() == null ? other.getFinishFlag() == null : this.getFinishFlag().equals(other.getFinishFlag()))
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
        result = prime * result + ((getReceiptAccountName() == null) ? 0 : getReceiptAccountName().hashCode());
        result = prime * result + ((getTransferPersonPhone() == null) ? 0 : getTransferPersonPhone().hashCode());
        result = prime * result + ((getTransferAmount() == null) ? 0 : getTransferAmount().hashCode());
        result = prime * result + ((getTransferImgUrl() == null) ? 0 : getTransferImgUrl().hashCode());
        result = prime * result + ((getFinishFlag() == null) ? 0 : getFinishFlag().hashCode());
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
        sb.append(", receiptAccountName=").append(receiptAccountName);
        sb.append(", transferPersonPhone=").append(transferPersonPhone);
        sb.append(", transferAmount=").append(transferAmount);
        sb.append(", transferImgUrl=").append(transferImgUrl);
        sb.append(", finishFlag=").append(finishFlag);
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