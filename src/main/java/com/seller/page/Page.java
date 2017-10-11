/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:Page.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.seller.page;

import java.io.Serializable;
import java.util.List;
import java.util.Map;

/**
 * 类功能描述:分页对象
 * 
 * @history 2012-12-21 Allen Gong 创建Page.java
 * 
 * @author Allen Gong
 * @version 0.1.0
* [1.0] 2016-12-22 Allen Gong add 分页<br>
 */
public class Page  implements Serializable {
	private static final long serialVersionUID = 553804799926114096L;
	/**
	 * 总记录数
	 */
	private long rowCount;
	 /**
	  * 当前页数
	  */
	private Integer pageNumber;
	
	/**
	 * 每页显示的大小
	 */
	private Integer pageSize;
	
	/**
	 * 开始记录
	 */
	private Integer startLine;
	
	/**
	 * 当前结果集合
	 */
	private List<?> resultList;
	
	/**
	 * 总页数 
	 */
	private Integer pageAllCount;
	
	/**
	 * 存入数据分页数据Map
	 */
	private Map<String, Object> jsonMap;
	
	public Page(){
		
	}
	
	public Page(Integer pageNum,Integer pageSize){
		this.pageNumber = pageNum;
		this.pageSize = pageSize;
	}

	public long getRowCount() {
		return rowCount;
	}

	public void setRowCount(long rowCount) {
		this.rowCount = rowCount;
	}

	public Integer getPageNumber() {
		return pageNumber;
	}

	public void setPageNumber(Integer pageNumber) {
		this.pageNumber = pageNumber;
	}

	public Integer getPageSize() {
		return pageSize;
	}

	public void setPageSize(Integer pageSize) {
		this.pageSize = pageSize;
	}

	public Integer getStartLine() {
		return startLine;
	}

	public void setStartLine(Integer startLine) {
		this.startLine = startLine;
	}

	public List<?> getResultList() {
		return resultList;
	}

	public void setResultList(List<?> resultList) {
		this.resultList = resultList;
	}

	public Integer getPageAllCount() {
		return pageAllCount;
	}

	public void setPageAllCount(Integer pageAllCount) {
		this.pageAllCount = pageAllCount;
	}

	public Map<String, Object> getJsonMap() {
		return jsonMap;
	}

	public void setJsonMap(Map<String, Object> jsonMap) {
		this.jsonMap = jsonMap;
	}

//	public void setTotalCount(long totalCount) {
//		this.rowCount = totalCount;
//		int pagenumcount = (int)(totalCount/pageSize);
//		if(totalCount%pageSize>0){
//			pagenumcount ++;
//		}
//		this.pageAllCount = pagenumcount;
//	}

}
