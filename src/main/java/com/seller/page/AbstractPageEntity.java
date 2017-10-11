/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:AbstractPageEntity.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.seller.page;

import java.io.Serializable;

import com.util.StringUtils;

/**
 * 类功能描述:分页用的实体对象，如果要用到分页就必须继承这个对象
 * 
 * @history 2012-12-21 Allen Gong 创建AbstractPageEntity.java
 * 
 * @author Allen Gong
 * @version 0.1.0
* [1.0] 2016-12-22 Allen Gong add 分页<br>
 */
public abstract class AbstractPageEntity implements Serializable {
	private static final long serialVersionUID = 7804371273488110630L;
	/**
	 * 起始页，默认为第一页
	 */
//	private Integer page = 1;
	private Integer page;
	/**
	 * 每页显示条数，默认每页显示5条
	 */
//	private Integer rows = 4;
	private Integer rows;
	/**
	 * 排序字段名称
	 */
	private String sort;
	/**
	 * 排序方式，例如：asc 或 desc
	 */
	private String order;
	/**
	 * 排序语句，例如：create_time desc
	 */
	private String orderByClause;
	public Integer getPage() {
		return page;
	}
	public void setPage(Integer page) {
		this.page = page;
	}
	public Integer getRows() {
		return rows;
	}
	public void setRows(Integer rows) {
		this.rows = rows;
	}
//	public String getSort() {
//		return sort;
//	}
//	public void setSort(String sort) {
//		this.sort = sort;
//	}
	public String getOrder() {
		return order;
	}
	public void setOrder(String order) {
		this.order = order;
	}
	public String getOrderByClause() {
		if(StringUtils.isNotBlank(sort) && StringUtils.isNotBlank(order)){
			orderByClause =StringUtils.generateSqlOrderByClause(sort, order);
		}
		return orderByClause;
	}
	public void setOrderByClause(String orderByClause) {
		this.orderByClause = orderByClause;
	}
}
