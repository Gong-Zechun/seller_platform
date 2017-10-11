package com.seller.extendEntity.vo;

import java.math.BigDecimal;

import com.seller.entity.model.User;

/**
 * 类功能描述：User类拓展类
 * @author Allen Gong
 * @version 5.1.1
 * @history 2017-10-9 Allen Gong 创建
 */
public class UserVo extends User {

    private static final long serialVersionUID = -182051427034521564L;

    /**
     * 账户余额（账户余额=账户冻结资金+账户可用资金）（同Wallet类balance属性）
     */
    private BigDecimal balance;

    /**
     * 账户冻结资金（同Wallet类blockFund属性）
     */
    private BigDecimal blockFund;

    /**
     * 账户可用资金（同Wallet类activeFund属性）
     */
    private BigDecimal activeFund;

    public BigDecimal getBalance() {
        return balance;
    }

    public void setBalance(BigDecimal balance) {
        this.balance = balance;
    }

    public BigDecimal getBlockFund() {
        return blockFund;
    }

    public void setBlockFund(BigDecimal blockFund) {
        this.blockFund = blockFund;
    }

    public BigDecimal getActiveFund() {
        return activeFund;
    }

    public void setActiveFund(BigDecimal activeFund) {
        this.activeFund = activeFund;
    }
}
