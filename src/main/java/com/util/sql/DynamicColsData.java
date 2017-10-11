package com.util.sql;

/**
 * 类功能描述：生成EasyUI动态生成列数据结构
 * @author Allen Gong
 * @version 2.0
 * @history 2017-7-7 Allen Gong 创建
 */
public class DynamicColsData {
	/**
	 * 二维表格-动态列名
	 */
	private String colName;
	/**
	 * 二维表格-每行名
	 */
	private String rowName;
	/**
	 * 二维表格-值或内容
	 */
	private String content;
	public String getColName() {
		return colName;
	}
	public void setColName(String colName) {
		this.colName = colName;
	}
	public String getRowName() {
		return rowName;
	}
	public void setRowName(String rowName) {
		this.rowName = rowName;
	}
	public String getContent() {
		return content;
	}
	public void setContent(String content) {
		this.content = content;
	}
}
