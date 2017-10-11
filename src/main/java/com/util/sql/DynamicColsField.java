package com.util.sql;

/**
 * 类功能描述：生成EasyUI动态生成列属性
 * @author Allen Gong
 * @version 2.0
 * @history 2017-7-7 Allen Gong 创建
 */
public class DynamicColsField {
	/**
	 * 域名-用于获取对应列数据
	 */
	private String field;
	
	/**
	 * 列名-用于显示表头名称
	 */
	private String title;
	
	public DynamicColsField(String field, String title){
		this.field = field;
		this.title = title;
	}

	public String getField() {
		return field;
	}
	public void setField(String field) {
		this.field = field;
	}
	public String getTitle() {
		return title;
	}
	public void setTitle(String title) {
		this.title = title;
	}
	
}
