package com.util;

/**
 * 组装类，主要用来封装返回结果集及分页信息
 * @author 许瑞
 *
 */
public class ReponseData{
	private Object result;


	public ReponseData() {
		this.result = null;
	//	this.page = new PageRequest(0, 10);
	}

	public ReponseData(Object result) {
		this.result = result;
	//	this.page = new PageRequest(0, 10);
	}

//	public ReponseData(Object result, Pageable page) {
//		this.result = result;
//	//	this.page = page;
//	}
	public ReponseData(Object result, long total_rows, int curr_rows, int curr_page, int page_rows, long runtime) {
		this.result = result;
	}

	public Object getResult() {
		return result;
	}

	public void setResult(Object result) {
		this.result = result;
	}

	/*public Pageable getPage() {
		return page;
	}

	public void setPage(Pageable page) {
		this.page = page;
	}*/
	
	/**
	 * 清除分页相关信息
	 */
	public void resetPageInfo()
	{
	}

}
