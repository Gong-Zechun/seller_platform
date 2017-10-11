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
public class Wallet extends com.seller.page.AbstractPageEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 用户ID
     */
    private Integer userId;

    /**
     * 账户余额（账户余额=账户冻结资金+账户可用资金）
     */
    private BigDecimal balance;

    /**
     * 账户冻结资金
     */
    private BigDecimal blockFund;

    /**
     * 账户可用资金
     */
    private BigDecimal activeFund;

    /**
     * 商家保证金
     */
    private BigDecimal deposit;

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
     * WALLET
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
     * 用户ID
     * @return USER_ID 用户ID
     */
    public Integer getUserId() {
        return userId;
    }

    /**
     * 用户ID
     * @param userId 用户ID
     */
    public void setUserId(Integer userId) {
        this.userId = userId;
    }

    /**
     * 账户余额（账户余额=账户冻结资金+账户可用资金）
     * @return BALANCE 账户余额（账户余额=账户冻结资金+账户可用资金）
     */
    public BigDecimal getBalance() {
        return balance;
    }

    /**
     * 账户余额（账户余额=账户冻结资金+账户可用资金）
     * @param balance 账户余额（账户余额=账户冻结资金+账户可用资金）
     */
    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    /**
     * 账户冻结资金
     * @return BLOCK_FUND 账户冻结资金
     */
    public BigDecimal getBlockFund() {
        return blockFund;
    }

    /**
     * 账户冻结资金
     * @param blockFund 账户冻结资金
     */
    public void setBlockFund(BigDecimal blockFund) {
        this.blockFund = blockFund;
    }

    /**
     * 账户可用资金
     * @return ACTIVE_FUND 账户可用资金
     */
    public BigDecimal getActiveFund() {
        return activeFund;
    }

    /**
     * 账户可用资金
     * @param activeFund 账户可用资金
     */
    public void setActiveFund(BigDecimal activeFund) {
        this.activeFund = activeFund;
    }

    /**
     * 商家保证金
     * @return DEPOSIT 商家保证金
     */
    public BigDecimal getDeposit() {
        return deposit;
    }

    /**
     * 商家保证金
     * @param deposit 商家保证金
     */
    public void setDeposit(BigDecimal deposit) {
        this.deposit = deposit;
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
        Wallet other = (Wallet) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getUserId() == null ? other.getUserId() == null : this.getUserId().equals(other.getUserId()))
            && (this.getBalance() == null ? other.getBalance() == null : this.getBalance().equals(other.getBalance()))
            && (this.getBlockFund() == null ? other.getBlockFund() == null : this.getBlockFund().equals(other.getBlockFund()))
            && (this.getActiveFund() == null ? other.getActiveFund() == null : this.getActiveFund().equals(other.getActiveFund()))
            && (this.getDeposit() == null ? other.getDeposit() == null : this.getDeposit().equals(other.getDeposit()))
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
        result = prime * result + ((getBalance() == null) ? 0 : getBalance().hashCode());
        result = prime * result + ((getBlockFund() == null) ? 0 : getBlockFund().hashCode());
        result = prime * result + ((getActiveFund() == null) ? 0 : getActiveFund().hashCode());
        result = prime * result + ((getDeposit() == null) ? 0 : getDeposit().hashCode());
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
        sb.append(", balance=").append(balance);
        sb.append(", blockFund=").append(blockFund);
        sb.append(", activeFund=").append(activeFund);
        sb.append(", deposit=").append(deposit);
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