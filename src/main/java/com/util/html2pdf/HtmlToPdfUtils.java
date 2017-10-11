/**
 * 创建于: 2016年9月23日 上午9:23:17<br>
 * 所属项目:VTeam Framework
 * 文件名称:HtmlToPdfUtils.java
 * 作者:oscar.yu
 * 版权信息:Copyright (c) 2001~2012, VTeam All Rights Reserved.
 */
package com.util.html2pdf;

import java.io.File;
import java.io.FileOutputStream;
import java.io.StringWriter;
import java.util.Properties;

import org.apache.velocity.Template;
import org.apache.velocity.VelocityContext;
import org.apache.velocity.app.Velocity;

import com.seller.constants.Constants;
import com.util.SystemConfig;

/**
 * 类功能描述:Html文档转PDF文档处理线程
 * @className HtmlToPdfUtils.java
 * 
 * @author Allen Gong
 * @version 1.0
 * 
 * @history 2017-01-01 Allen Gong 创建 HtmlToPdfUtils.java
 */
public class HtmlToPdfUtils {

    /**
     * 测试方法
     * @param args
     * @throws Exception
     */
    public static void main(String[] args) throws Exception {
    	VelocityContext ctx = new VelocityContext();
    	ctx.put("test", "Hello World 2017");
        String templateName = "privacy.vm";
        String outFilePath = "E:\\test\\";
        String fileName = "myxmjb.html";
//        // 根据数据填充 模板
        loadHtmlTemp(ctx, outFilePath, templateName, outFilePath, fileName);
        // HTML文档转为PDF文档
        String srcPath = outFilePath + fileName;
        String destPath = getOutputFilePath(srcPath);
        htmlToPdf(srcPath, destPath);
    }

    /**
     * 根据数据填充HTML模板
     * @param dataMap
     * @param templateName
     * @param outFilePath
     * @param fileName
     * @throws Exception
     */
    public static void loadHtmlTemp(VelocityContext ctx, String templatePath, String templateName, String outFilePath, String fileName) throws Exception {
    	final String separator = File.separator;
        Properties p = new Properties();//通过Properties对象设置配置信息
        p.setProperty("file.resource.loader.path", templatePath);
        //设置velocity的输入输出编码转换
        p.setProperty("output.encoding", "gb2312");
        p.setProperty("input.encoding", "iso-8859-1");//输入的编码    
        Velocity.init(p);
        //取得模版文件
        Template template = Velocity.getTemplate(templateName);
        StringWriter sw = new StringWriter();
        template.merge(ctx, sw);
        // 输出文件
        File outFile = new File(outFilePath + separator + fileName);
        // 如果输出目标文件夹不存在，则创建
        if (!outFile.getParentFile().exists()) {
        	outFile.getParentFile().mkdirs();
        }
        FileOutputStream fos = new FileOutputStream(outFile);
        fos.write(sw.toString().getBytes());
        fos.close();
    }

    /**
     * HTML文档转为PDF文档
     * <p>
     * 在java中调用wkhtmltopdf的命令Runtime.getRuntime().exec("c:\wkhtmltopdf.exe http://www.csdn.net c:\csdn.pdf")就可以实现转换。
     * </p>
     * @param srcPath
     *            html路径，可以是硬盘上的路径，也可以是网络路径
     * @param destPath
     *            pdf保存路径
     * @return 转换成功返回true
     */
    public static void htmlToPdf(String srcPath, String destPath) throws Exception {
        File file = new File(destPath);
        File parent = file.getParentFile();
        // 如果pdf保存路径不存在，则创建路径
        if (!parent.exists()) {
            parent.mkdirs();
        }
        StringBuilder cmd = new StringBuilder();
        cmd.append(SystemConfig.getInstance().getValue(Constants.WKHTMLTOPDF_TOOL_PATH));
        cmd.append(" ");
        cmd.append(srcPath);
        cmd.append(" ");
        cmd.append(destPath);
        Process proc = Runtime.getRuntime().exec(cmd.toString());
        HtmlToPdfInterceptor error = new HtmlToPdfInterceptor(proc.getErrorStream());
        HtmlToPdfInterceptor output = new HtmlToPdfInterceptor(proc.getInputStream());
        error.start();
        output.start();
        proc.waitFor();
        proc.destroy();
    }

    /**
     * 获取输出文件路径
     * @param inputFilePath
     * @return
     */
    public static String getOutputFilePath(String inputFilePath) {
        String outputFilePath = inputFilePath.replaceAll(".html", ".pdf");
        return outputFilePath;
    }

}
