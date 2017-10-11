package com.util.html2pdf;

import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStream;
import java.io.InputStreamReader;

/**
 * 类功能描述:Html文档转PDF文档处理线程
 * @className HtmlToPdfInterceptor.java
 * 
 * @author Allen Gong
 * @version 1.0
 * 
 * @history 2017-01-01 Allen Gong 创建 HtmlToPdfInterceptor.java
 */
public class HtmlToPdfInterceptor extends Thread {

    private InputStream is;

    public HtmlToPdfInterceptor(InputStream is) {
        this.is = is;
    }

    public void run() {
        try {
            InputStreamReader isr = new InputStreamReader(is, "utf-8");
            BufferedReader br = new BufferedReader(isr);
            String line = null;
            while ((line = br.readLine()) != null) {
                System.out.println(line.toString()); // 输出内容
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
