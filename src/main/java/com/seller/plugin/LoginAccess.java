package com.seller.plugin;

import java.lang.annotation.ElementType;
import java.lang.annotation.Retention;
import java.lang.annotation.RetentionPolicy;
import java.lang.annotation.Target;

/**
 * 类功能描述：授权token登陆验证注解
 * 
 * @author barry.wang
 * @version 5.0.0
 * @history 2017-06-13 barry.wang 创建
 */
@Target(ElementType.METHOD)//这个注解是应用在方法上  
@Retention(RetentionPolicy.RUNTIME) 
public @interface LoginAccess {

}
