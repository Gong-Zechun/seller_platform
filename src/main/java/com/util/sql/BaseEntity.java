/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:AbstractPageEntity.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.util.sql;

import java.io.Serializable;

/**
 * 类功能描述:分页用的实体及接口错误码信息基础类， 实体Bean将继承
 *
 * @history 2017-03-31 Allen Gong 创建BaseEntity.java
 *
 * @author Allen Gong
 * @version 1.0.0
 * [1.0.0] 2017-03-31 Allen Gong add<br>
 */
public class BaseEntity implements Serializable {
    private static final long serialVersionUID = 7804371273488110630L;
    //===================================分页信息开始=========================
    /**
     * 起始页，默认为第一页
     */
    private Integer pageNum;
    /**
     * 每页显示条数，默认每页显示10条
     */
    private Integer pageSize;
    /**
     * 排序语句，例如：create_time desc
     */
    private String orderBy;

    public Integer getPageNum() {
        return pageNum;
    }
    public void setPageNum(Integer pageNum) {
        this.pageNum = pageNum;
    }
    public Integer getPageSize() {
        return pageSize;
    }
    public void setPageSize(Integer pageSize) {
        this.pageSize = pageSize;
    }
    public String getOrderBy() {
        return orderBy;
    }
    public void setOrderBy(String orderBy) {
        this.orderBy = orderBy;
    }
    //===================================分页信息结束=========================

    //===================================接口请求基础信息开始===================
    /**
     * 错误代码
     */
    public Integer result;
    /**
     * 错误具体原因错误码
     */
    public Integer code;
    /**
     * 错误信息
     */
    public String msg;
    /**
     * 返回数据
     */
    public Object data;

    /**
     * 返回数据总条数
     */
    public int total;
    public Integer getResult() {
        return result;
    }
    public void setResult(Integer result) {
        this.result = result;
    }
    public Integer getCode() {
        return code;
    }
    public void setCode(Integer code) {
        this.code = code;
    }
    public String getMsg() {
        return msg;
    }
    public void setMsg(String msg) {
        this.msg = msg;
    }
    public Object getData() {
        return data;
    }
    public void setData(Object data) {
        this.data = data;
    }

    public int getTotal() {
        return total;
    }

    public void setTotal(int total) {
        this.total = total;
    }
    //===================================接口请求基础信息结束===================

    //==================================APP 公共传入参数开始===================
    /**
     * 设备型号 如 MI 4LTE
     */
    private String  devicemodel;
    /**
     * 系统类型  1-IOS   2-安卓
     */
    private Integer system;
    /**
     * 系统版本号  如4.4.4
     */
    private String  sysversion;
    /**
     * APP版本号 int值   如  1
     */
    private String appversion;
    /**
     * 设备唯一编号
     */
    private String  udid;
    /**
     * 用户id  未登录时候不传 或传空字符串
     */
    private String  userId;
    /**
     * 授权Token
     */
    private String  authToken;

    public String getDevicemodel() {
        return devicemodel;
    }
    public void setDevicemodel(String devicemodel) {
        this.devicemodel = devicemodel;
    }
    public Integer getSystem() {
        return system;
    }
    public void setSystem(Integer system) {
        this.system = system;
    }
    public String getSysversion() {
        return sysversion;
    }
    public void setSysversion(String sysversion) {
        this.sysversion = sysversion;
    }
    public String getAppversion() {
        return appversion;
    }
    public void setAppversion(String appversion) {
        this.appversion = appversion;
    }
    public String getUdid() {
        return udid;
    }
    public void setUdid(String udid) {
        this.udid = udid;
    }
    public String getUserId() {
        return userId;
    }
    public void setUserId(String userId) {
        this.userId = userId;
    }
    public String getAuthToken() {
        return authToken;
    }
    public void setAuthToken(String authToken) {
        this.authToken = authToken;
    }
    //==================================APP 公共传入参数结束===================
}
