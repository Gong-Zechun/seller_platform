/**
 * 创建于: 2016-12-28 下午1:50:28<br>
 * 所属项目:Transn BI
 * 文件名称:ServletListener.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2017,  All Rights Reserved.
 */
package com.seller.servlet;

import javax.servlet.ServletContextEvent;
import javax.servlet.ServletContextListener;

/**
 * 类功能描述:系统数据缓存类
 * @author Allen Gong
 * @version 2.0
 * @history 2017-1-22 Allen Gong 创建
 */
public class ServletListener implements ServletContextListener{
	/**
	 * Tomcat关闭时调用
	 */
	@Override
	public void contextDestroyed(ServletContextEvent sc) {
		System.out.println("--------------缓存清除开始---------------");
		CacheSysData.release();
		System.out.println("--------------缓存清除完成---------------");

	}

	/**
	 * Tomcat启动时调用
	 */
	@Override
	public void contextInitialized(ServletContextEvent sc) {
		System.out.println("--------------数据初始化开始---------------");
		new CacheSysData(sc);
		System.out.println("--------------数据初始化完成---------------");
	}
}
