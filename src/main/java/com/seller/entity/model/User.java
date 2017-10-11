package com.seller.entity.model;

import java.io.Serializable;
import java.util.Date;

/**
 * 类功能描述:实体Model
 * 
 * @history 2017-09-02 Allen Gong 创建
 * 
 * @author Allen Gong
 * @version 1.0 
 * [1.0] 2017-09-02 Allen Gong add 根据表结构生成Model<br>
 */
public class User extends com.seller.page.AbstractPageEntity implements Serializable {
    /**
     * 编号
     */
    private Integer id;

    /**
     * 商家编号（登录名）
     */
    private String sellerNo;

    /**
     * 密码
     */
    private String password;

    /**
     * 真实姓名
     */
    private String realName;

    /**
     * 手机号码
     */
    private String phone;

    /**
     * QQ号
     */
    private String qqNum;

    /**
     * 微信号
     */
    private String wechatNum;

    /**
     * 店铺掌柜ID1
     */
    private String sellerShopId1;

    /**
     * 店铺掌柜ID2（选填）
     */
    private String sellerShopId2;

    /**
     * 店铺掌柜ID3（选填）
     */
    private String sellerShopId3;

    /**
     * 用户类型：1:商家；2:买家；3:舵主
     */
    private String userType;

    /**
     * 商家是否VIP：0:否；1:是
     */
    private String vipFlag;

    /**
     * 商家VIP等级：0:V0；1:V1；2:V2；3:V3
     */
    private String vipGrade;

    /**
     * 最后登陆IP
     */
    private String lastLoginIp;

    /**
     * 最后登陆时间
     */
    private Date lastLoginDate;

    /**
     * 此商家编号是否被注册：0:否；1:是
     */
    private String registerFlag;

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
     * USER
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
     * 商家编号（登录名）
     * @return SELLER_NO 商家编号（登录名）
     */
    public String getSellerNo() {
        return sellerNo;
    }

    /**
     * 商家编号（登录名）
     * @param sellerNo 商家编号（登录名）
     */
    public void setSellerNo(String sellerNo) {
        this.sellerNo = sellerNo;
    }

    /**
     * 密码
     * @return PASSWORD 密码
     */
    public String getPassword() {
        return password;
    }

    /**
     * 密码
     * @param password 密码
     */
    public void setPassword(String password) {
        this.password = password;
    }

    /**
     * 真实姓名
     * @return REAL_NAME 真实姓名
     */
    public String getRealName() {
        return realName;
    }

    /**
     * 真实姓名
     * @param realName 真实姓名
     */
    public void setRealName(String realName) {
        this.realName = realName;
    }

    /**
     * 手机号码
     * @return PHONE 手机号码
     */
    public String getPhone() {
        return phone;
    }

    /**
     * 手机号码
     * @param phone 手机号码
     */
    public void setPhone(String phone) {
        this.phone = phone;
    }

    /**
     * QQ号
     * @return QQ_NUM QQ号
     */
    public String getQqNum() {
        return qqNum;
    }

    /**
     * QQ号
     * @param qqNum QQ号
     */
    public void setQqNum(String qqNum) {
        this.qqNum = qqNum;
    }

    /**
     * 微信号
     * @return WECHAT_NUM 微信号
     */
    public String getWechatNum() {
        return wechatNum;
    }

    /**
     * 微信号
     * @param wechatNum 微信号
     */
    public void setWechatNum(String wechatNum) {
        this.wechatNum = wechatNum;
    }

    /**
     * 店铺掌柜ID1
     * @return SELLER_SHOP_ID1 店铺掌柜ID1
     */
    public String getSellerShopId1() {
        return sellerShopId1;
    }

    /**
     * 店铺掌柜ID1
     * @param sellerShopId1 店铺掌柜ID1
     */
    public void setSellerShopId1(String sellerShopId1) {
        this.sellerShopId1 = sellerShopId1;
    }

    /**
     * 店铺掌柜ID2（选填）
     * @return SELLER_SHOP_ID2 店铺掌柜ID2（选填）
     */
    public String getSellerShopId2() {
        return sellerShopId2;
    }

    /**
     * 店铺掌柜ID2（选填）
     * @param sellerShopId2 店铺掌柜ID2（选填）
     */
    public void setSellerShopId2(String sellerShopId2) {
        this.sellerShopId2 = sellerShopId2;
    }

    /**
     * 店铺掌柜ID3（选填）
     * @return SELLER_SHOP_ID3 店铺掌柜ID3（选填）
     */
    public String getSellerShopId3() {
        return sellerShopId3;
    }

    /**
     * 店铺掌柜ID3（选填）
     * @param sellerShopId3 店铺掌柜ID3（选填）
     */
    public void setSellerShopId3(String sellerShopId3) {
        this.sellerShopId3 = sellerShopId3;
    }

    /**
     * 用户类型：1:商家；2:买家；3:舵主
     * @return USER_TYPE 用户类型：1:商家；2:买家；3:舵主
     */
    public String getUserType() {
        return userType;
    }

    /**
     * 用户类型：1:商家；2:买家；3:舵主
     * @param userType 用户类型：1:商家；2:买家；3:舵主
     */
    public void setUserType(String userType) {
        this.userType = userType;
    }

    /**
     * 商家是否VIP：0:否；1:是
     * @return VIP_FLAG 商家是否VIP：0:否；1:是
     */
    public String getVipFlag() {
        return vipFlag;
    }

    /**
     * 商家是否VIP：0:否；1:是
     * @param vipFlag 商家是否VIP：0:否；1:是
     */
    public void setVipFlag(String vipFlag) {
        this.vipFlag = vipFlag;
    }

    /**
     * 商家VIP等级：0:V0；1:V1；2:V2；3:V3
     * @return VIP_GRADE 商家VIP等级：0:V0；1:V1；2:V2；3:V3
     */
    public String getVipGrade() {
        return vipGrade;
    }

    /**
     * 商家VIP等级：0:V0；1:V1；2:V2；3:V3
     * @param vipGrade 商家VIP等级：0:V0；1:V1；2:V2；3:V3
     */
    public void setVipGrade(String vipGrade) {
        this.vipGrade = vipGrade;
    }

    /**
     * 最后登陆IP
     * @return LAST_LOGIN_IP 最后登陆IP
     */
    public String getLastLoginIp() {
        return lastLoginIp;
    }

    /**
     * 最后登陆IP
     * @param lastLoginIp 最后登陆IP
     */
    public void setLastLoginIp(String lastLoginIp) {
        this.lastLoginIp = lastLoginIp;
    }

    /**
     * 最后登陆时间
     * @return LAST_LOGIN_DATE 最后登陆时间
     */
    public Date getLastLoginDate() {
        return lastLoginDate;
    }

    /**
     * 最后登陆时间
     * @param lastLoginDate 最后登陆时间
     */
    public void setLastLoginDate(Date lastLoginDate) {
        this.lastLoginDate = lastLoginDate;
    }

    /**
     * 此商家编号是否被注册：0:否；1:是
     * @return REGISTER_FLAG 此商家编号是否被注册：0:否；1:是
     */
    public String getRegisterFlag() {
        return registerFlag;
    }

    /**
     * 此商家编号是否被注册：0:否；1:是
     * @param registerFlag 此商家编号是否被注册：0:否；1:是
     */
    public void setRegisterFlag(String registerFlag) {
        this.registerFlag = registerFlag;
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
        User other = (User) that;
        return (this.getId() == null ? other.getId() == null : this.getId().equals(other.getId()))
            && (this.getSellerNo() == null ? other.getSellerNo() == null : this.getSellerNo().equals(other.getSellerNo()))
            && (this.getPassword() == null ? other.getPassword() == null : this.getPassword().equals(other.getPassword()))
            && (this.getRealName() == null ? other.getRealName() == null : this.getRealName().equals(other.getRealName()))
            && (this.getPhone() == null ? other.getPhone() == null : this.getPhone().equals(other.getPhone()))
            && (this.getQqNum() == null ? other.getQqNum() == null : this.getQqNum().equals(other.getQqNum()))
            && (this.getWechatNum() == null ? other.getWechatNum() == null : this.getWechatNum().equals(other.getWechatNum()))
            && (this.getSellerShopId1() == null ? other.getSellerShopId1() == null : this.getSellerShopId1().equals(other.getSellerShopId1()))
            && (this.getSellerShopId2() == null ? other.getSellerShopId2() == null : this.getSellerShopId2().equals(other.getSellerShopId2()))
            && (this.getSellerShopId3() == null ? other.getSellerShopId3() == null : this.getSellerShopId3().equals(other.getSellerShopId3()))
            && (this.getUserType() == null ? other.getUserType() == null : this.getUserType().equals(other.getUserType()))
            && (this.getVipFlag() == null ? other.getVipFlag() == null : this.getVipFlag().equals(other.getVipFlag()))
            && (this.getVipGrade() == null ? other.getVipGrade() == null : this.getVipGrade().equals(other.getVipGrade()))
            && (this.getLastLoginIp() == null ? other.getLastLoginIp() == null : this.getLastLoginIp().equals(other.getLastLoginIp()))
            && (this.getLastLoginDate() == null ? other.getLastLoginDate() == null : this.getLastLoginDate().equals(other.getLastLoginDate()))
            && (this.getRegisterFlag() == null ? other.getRegisterFlag() == null : this.getRegisterFlag().equals(other.getRegisterFlag()))
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
        result = prime * result + ((getSellerNo() == null) ? 0 : getSellerNo().hashCode());
        result = prime * result + ((getPassword() == null) ? 0 : getPassword().hashCode());
        result = prime * result + ((getRealName() == null) ? 0 : getRealName().hashCode());
        result = prime * result + ((getPhone() == null) ? 0 : getPhone().hashCode());
        result = prime * result + ((getQqNum() == null) ? 0 : getQqNum().hashCode());
        result = prime * result + ((getWechatNum() == null) ? 0 : getWechatNum().hashCode());
        result = prime * result + ((getSellerShopId1() == null) ? 0 : getSellerShopId1().hashCode());
        result = prime * result + ((getSellerShopId2() == null) ? 0 : getSellerShopId2().hashCode());
        result = prime * result + ((getSellerShopId3() == null) ? 0 : getSellerShopId3().hashCode());
        result = prime * result + ((getUserType() == null) ? 0 : getUserType().hashCode());
        result = prime * result + ((getVipFlag() == null) ? 0 : getVipFlag().hashCode());
        result = prime * result + ((getVipGrade() == null) ? 0 : getVipGrade().hashCode());
        result = prime * result + ((getLastLoginIp() == null) ? 0 : getLastLoginIp().hashCode());
        result = prime * result + ((getLastLoginDate() == null) ? 0 : getLastLoginDate().hashCode());
        result = prime * result + ((getRegisterFlag() == null) ? 0 : getRegisterFlag().hashCode());
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
        sb.append(", sellerNo=").append(sellerNo);
        sb.append(", password=").append(password);
        sb.append(", realName=").append(realName);
        sb.append(", phone=").append(phone);
        sb.append(", qqNum=").append(qqNum);
        sb.append(", wechatNum=").append(wechatNum);
        sb.append(", sellerShopId1=").append(sellerShopId1);
        sb.append(", sellerShopId2=").append(sellerShopId2);
        sb.append(", sellerShopId3=").append(sellerShopId3);
        sb.append(", userType=").append(userType);
        sb.append(", vipFlag=").append(vipFlag);
        sb.append(", vipGrade=").append(vipGrade);
        sb.append(", lastLoginIp=").append(lastLoginIp);
        sb.append(", lastLoginDate=").append(lastLoginDate);
        sb.append(", registerFlag=").append(registerFlag);
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