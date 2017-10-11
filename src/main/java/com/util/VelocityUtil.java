package com.util;

import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.VelocityEngine;

import com.seller.constants.Constants;

/**
 * @author Allen Gong
 * @version V1.0
 * @date 2017-1-20 16:52
 */
public class VelocityUtil {

    public static String turnVmPage2String(String fileName, VelocityContext context) {
        //初始化参数
        Properties properties=new Properties();
        //设置velocity资源加载方式为class
        properties.setProperty("resource.loader", "class");
        //设置velocity资源加载方式为file时的处理类
        properties.setProperty("class.resource.loader.class", "org.apache.velocity.runtime.resource.loader.ClasspathResourceLoader");
        //实例化一个VelocityEngine对象
        VelocityEngine velocityEngine=new VelocityEngine(properties);

        //实例化一个StringWriter
        StringWriter writer=new StringWriter();

        //从src目录下加载hello.vm模板
        //假若在com.velocity.test包下有一个hello.vm文件,那么加载路径为com/velocity/test/hello.vm
        velocityEngine.mergeTemplate(Constants.emailTemplatePath+fileName, "UTF-8", context, writer);
        return writer.toString();
    }

    public static void main(String[] args) {
//        String x = turnVmPage2String("captchaEmailTemplate.vm", new VelocityContext());
    }
}
