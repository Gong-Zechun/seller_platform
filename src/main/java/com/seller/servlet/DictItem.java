package com.seller.servlet;

/**
 * 类功能描述:字典项Bean
 * @author Allen Gong
 * @version 2.0
 * @history 2017-1-22 Allen Gong 创建
 */
public class DictItem {
	private String value;// 代码
	private String label;// 名称
	private String type;// 类型
	private String desc;// 描叙

	public DictItem(String value, String label, String type) {
		this(value, label, type, null);
	}
	
	public DictItem(String value, String label, String type, String desc) {
		this.value = value;
		this.label = label;
		this.type = type;
		this.desc = desc;
	}

	public String getValue() {
		return value;
	}

	public void setValue(String value) {
		this.value = value;
	}

	public String getLabel() {
		return label;
	}

	public void setLabel(String label) {
		this.label = label;
	}

	public String getType() {
		return type;
	}

	public void setType(String type) {
		this.type = type;
	}

	public String getDesc() {
		return desc;
	}

	public void setDesc(String desc) {
		this.desc = desc;
	}
}
