package com.util;

/**
 * 组装类，将业务处理结果组装成前端可以使用的格式标�?
 * @author xurui
 *
 */

public class ResponseContainer {
	private int status;
	private String msg;
	private ReponseData data;

	public Object getData() {
		return data;
	}


	public String getMsg() {
		return msg;
	}

	public int getStatus() {
		return status;
	}

	public void setData(ReponseData data) {
		this.data = data;
	}


	public void setMsg(String msg) {
		this.msg = msg;
	}

	public void setStatus(int status) {
		this.status = status;
	}

}
