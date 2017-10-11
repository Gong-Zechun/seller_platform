package com.seller.servlet;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.servlet.ServletContextEvent;

import org.apache.commons.collections.CollectionUtils;
import org.springframework.context.ApplicationContext;
import org.springframework.web.context.support.WebApplicationContextUtils;

import com.seller.entity.model.SysDict;
import com.seller.service.SysDictService;

/**
 * 类功能描述:系统数据缓存类
 * @author Allen Gong
 * @version 2.0
 * @history 2017-1-22 Allen Gong 创建CacheSysData.java
 */
public class CacheSysData{
	private ApplicationContext applicationContext = null;
	private static Map<String, List<DictItem>> dictItemMap = new HashMap<String, List<DictItem>>();

	public CacheSysData(ServletContextEvent sc){
		applicationContext = WebApplicationContextUtils.getWebApplicationContext(sc.getServletContext());
		this.initData();
	}

	/**
	 * 初始化数据
	 */
	public void initData(){
		//1. 初始化数据字典Map
		this.initDictItemMap();
	}

	/**
	 * 初始化数据字典Map
	 */
	private void initDictItemMap(){
		SysDictService sysDictService = applicationContext.getBean(SysDictService.class);
		List<SysDict> sysDictList = sysDictService.getAllSysDictList();
		if(CollectionUtils.isNotEmpty(sysDictList)) {
			for(SysDict sysDict : sysDictList){
				List<DictItem> dictItemList = dictItemMap.get(sysDict.getType());
				if(dictItemList == null){
					dictItemList = new ArrayList<DictItem>();
					dictItemMap.put(sysDict.getType(), dictItemList);
				}
				dictItemList.add(new DictItem(sysDict.getValue(), sysDict.getLabel(), sysDict.getType(), sysDict.getDescription()));
			}
		}
	}

	public static Map<String, List<DictItem>> getDictItemMap() {
		return dictItemMap;
	}

	/**
	 * 释放缓存数据
	 */
	public static void release(){
		dictItemMap.clear();
	}
}
