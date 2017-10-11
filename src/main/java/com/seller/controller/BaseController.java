package com.seller.controller;

import java.util.List;
import java.util.Map;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;

import com.seller.entity.model.User;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.client.RestTemplate;

import com.alibaba.fastjson.JSON;
import com.seller.constants.ErrorCode;
import com.util.JsonUtil;
import com.util.ReponseData;
import com.util.ResponseContainer;
import com.util.sql.BaseEntity;

import net.sf.json.JSONObject;

/**
 * 类功能描述：ME父类Controller
 * 
 * @author Allen Gong
 * @version 5.0.0
 * @history 2017-03-31 Allen Gong 创建
 */
public abstract class BaseController {
    protected static final Logger logger = LoggerFactory.getLogger(BaseController.class);
    protected HttpServletRequest request;
    protected HttpServletResponse response;
    protected HttpSession session;

    /**
     * 请求时获取request与response， 不需要单独在Controller的方法中获取
     * @param request
     * @param response
     */
    @ModelAttribute
    public void setReqAndRes(HttpServletRequest request, HttpServletResponse response){
        this.request = request;
        this.response = response;
        this.session = request.getSession();
    }
    
	public static Map<String, List<Map<String, String>>> directionaryMap=null;

	/**
	 * ResponseContainer 对象多线�?
	 */
	private ThreadLocal<ResponseContainer> resConLocal = new ThreadLocal<ResponseContainer>();
	
	
    /**
     * ReponseData 对象多线程管�?
     */
	private ThreadLocal<ReponseData> rsDataLocal = new ThreadLocal<ReponseData>();

	public ResponseContainer getResponseContainer() {
		if (resConLocal.get() == null) {
			ResponseContainer con = new ResponseContainer();
			resConLocal.set(con);
			return con;
		} else {
			return resConLocal.get();
		}
	}

	public ReponseData getReponseData() {
		if (rsDataLocal.get() == null) {
			ReponseData rsdata = new ReponseData();
			rsDataLocal.set(rsdata);
			return rsdata;
		} else {
			return rsDataLocal.get();
		}
	}

	public ResponseContainer addResponse(int status, String msg, Object obj) {
		ResponseContainer res = this.getResponseContainer();
		ReponseData rsdata = this.getReponseData();
		res.setStatus(status);
		res.setMsg(msg);
		rsdata.setResult(obj);
		rsdata.resetPageInfo();// 清除分页相关信息
		res.setData(rsdata);
		return res;
	}

	public ResponseContainer addPageResponse(int status, String msg,
			ReponseData rspData, int mode, String md5) {
		ResponseContainer res = this.getResponseContainer();
		res.setStatus(status);
		res.setMsg(msg);
		res.setData(rspData);
		return res;
	}
	/**
	 * 传入�?个地�?，Get 请求
	 * @param url
	 * @return
	 */
	public Object getRestApiData(String url) {
		String courSharResoStr;
		RestTemplate restTemplate = new RestTemplate();
		courSharResoStr = restTemplate.postForObject(url, null, String.class);
		Object o=null;
		try {
//			JSONObject objj = JSONObject.fromObject(courSharResoStr);
			ResponseContainer responseContainer = (ResponseContainer) JSON.parseObject(courSharResoStr, ResponseContainer.class); 
			if(responseContainer.getStatus()==200){
				ReponseData r=(ReponseData) responseContainer.getData();
				 o=r.getResult();
			}
			return o;
		} catch (Exception e) {
			return null;
		}
	}

	/**
	 * 传入Map，Post到对�?个的地址（为了兼容之前传入的Map参数�?
	 * @param url
	 * @param requestParams
	 * @return JSONObject
	 */
	public Object getRestApiData(String url,
			Map<String, String> requestParams) {
		String courSharResoStr;
		Object o=null;
		MultiValueMap<String, String> map = new LinkedMultiValueMap<String, String>();
		map.setAll(requestParams);
		
		RestTemplate restTemplate = new RestTemplate();
		courSharResoStr = restTemplate.postForObject(url, map, String.class,"");
		try {
//			JSONObject objj = JSONObject.fromObject(courSharResoStr);
			ResponseContainer responseContainer = (ResponseContainer) JSON.parseObject(courSharResoStr, ResponseContainer.class); 
			if(responseContainer.getStatus()==200){
				ReponseData r=(ReponseData) responseContainer.getData();
				 o=r.getResult();
			}
			return o;
		} catch (Exception e) {
			return null;
		}
	}
	/**
	 * 传入MultiValueMap，Post给对应的地址
	 * @param url
	 * @param requestParams
	 * @return JSONObject
	 */
	public Object getRestApiData(String url,
			MultiValueMap<String, String> requestParams) {
		String courSharResoStr;
		Object o=null;
		RestTemplate restTemplate = new RestTemplate();
		courSharResoStr = restTemplate.postForObject(url, requestParams, String.class, "");
		try {
//			JSONObject objj = JSONObject.fromObject(courSharResoStr);
			ResponseContainer responseContainer = (ResponseContainer) JSON.parseObject(courSharResoStr, ResponseContainer.class); 
			if(responseContainer.getStatus()==200){
				ReponseData r=(ReponseData) responseContainer.getData();
				 o=r.getResult();
			}
			return o;
		} catch (Exception e) {
			return null;
		}
	}


	/**
	 * 传入一个地址，Get 请求
	 * @param url
	 * @return
	 */
	public JSONObject getRestApiDataNoAli(String url) {
		String courSharResoStr;
		RestTemplate restTemplate = new RestTemplate();
		courSharResoStr = restTemplate.postForObject(url, null, String.class);
		try {
			JSONObject objj = JSONObject.fromObject(courSharResoStr);
			return objj;
		} catch (Exception e) {
			return null;
		}
	}
	
	public String makephonecode() {
//		String a = "123456";
		String a = "";
		for (int i = 0; i < 6; i++) {
			a = a + (int) (Math.random() * 10);
		}
		return a;
	}

	/**
	 * 接口调用成功
	 * @param baseEntity
	 * @return
	 */
	public static String returnSuccessInfo(BaseEntity baseEntity) {
		baseEntity.setResult(ErrorCode.SUCCESS);
		return JsonUtil.toJsonStr(baseEntity);
	}
	
	/**
	 * 接口调用失败-未知错误打印日志
	 * @param throwable
	 * @return
	 */
	public static String returnErrorInfo(Throwable throwable) {
	    String errmsg = "出现未知错误";
	    logger.error(errmsg, throwable);
	    return returnErrorInfo(new BaseEntity(), ErrorCode.ERROR, errmsg);
	}
	
	/**
	 * 接口调用失败-返回错误信息
	 * @param errNo 错误具体原因的错误码
	 * @return
	 */
	public static String returnErrorInfo(Integer errNo) {
		String errmsg = ErrorCode.ERROR_MSG_MAP.get(errNo);
		if(errmsg == null) {
			errmsg = "出现未知错误";
		}
		return returnErrorInfo(new BaseEntity(), errNo, errmsg);
	}

	/**
	 * 接口调用失败-返回错误信息
	 * @param errNo 错误具体原因的错误码
	 * @param errmsg 错误信息
	 * @return
	 */
	public static String returnErrorInfo(Integer errNo, String errmsg) {
		BaseEntity baseEntity = new BaseEntity();
		baseEntity.setResult(ErrorCode.ERROR);
		baseEntity.setCode(errNo);
		baseEntity.setMsg(errmsg);
		return JsonUtil.toJsonStr(baseEntity);
	}

	/**
	 * 接口调用失败-返回错误信息
	 * @param baseEntity 错误对象
	 * @param errNo 错误具体原因的错误码
	 * @return
	 */
	public static String returnErrorInfo(BaseEntity baseEntity, Integer errNo) {
		String errmsg = ErrorCode.ERROR_MSG_MAP.get(errNo);
		if(errmsg == null) {
			errmsg = "出现未知错误";
		}
		return returnErrorInfo(baseEntity, errNo, errmsg);
	}

	/**
	 * 接口调用失败-返回错误信息
	 * @param baseEntity 错误对象
	 * @param errNo 错误具体原因的错误码
	 * @param errmsg 错误信息
	 * @return
	 */
	public static String returnErrorInfo(BaseEntity baseEntity, Integer errNo, String errmsg) {
		baseEntity.setResult(ErrorCode.ERROR);
		baseEntity.setCode(errNo);
		baseEntity.setMsg(errmsg);
		return JsonUtil.toJsonStr(baseEntity);
	}
	
	/**
	 * 判断整数是否为空
	 * @param integer
	 * @return
	 */
	public boolean isIntgerNull(Integer integer){
	    return integer == null || integer.intValue() == 0;
	}

	public static void main(String[] args) {
		User user = new User();
		String aaa = null;
		user.setPassword(aaa);
		System.out.println(user.getPassword());
	}

}
