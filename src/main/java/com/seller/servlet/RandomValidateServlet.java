/**
 * 创建于: 2017-1-16 下午1:31:49<br>
 * 所属项目:transn BI
 * 文件名称:RandomValidateServlet.java
 * 作者:Allen Gong
 * 版权信息: 版权所有 © 2001-2013 传神语联网网络科技股份有限公司
 */
package com.seller.servlet;

import java.awt.Color;
import java.awt.Font;
import java.awt.Graphics;
import java.awt.image.BufferedImage;
import java.io.IOException;
import java.util.Random;

import javax.imageio.ImageIO;
import javax.servlet.ServletException;
import javax.servlet.ServletOutputStream;
import javax.servlet.http.HttpServlet;
import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;

/**
 * 类功能描述：生成随机验证码图片的servlet。
 * RandomValidateServlet.java
 * @author Allen Gong
 * @version 0.1.0
 * @history 2017-1-16 Allen Gong 创建RandomValidateServlet.java
 */
public class RandomValidateServlet extends HttpServlet{

	private static final long serialVersionUID = -8929180442318123335L;

	static Random random = new Random();
	
	//验证码字符集 不包括 0,o,1,l
	static final char[] dictionary = { '2', '3', '4', '5', '6', '7', '8', '9',
			'a', 'b', 'c', 'd', 'e', 'f', 'g', 'h', 'i', 'j', 'k', 'm', 'n',
			'p', 'q', 'r', 's', 't', 'u', 'v', 'w', 'x', 'y', 'z', 'A', 'B',
			'C', 'D', 'E', 'F', 'G', 'H', 'J', 'K', 'L', 'M', 'N', 'P', 'Q',
			'R', 'S', 'T', 'U', 'V', 'W', 'X', 'Y', 'Z' };

	static String getRandomString(int n) {
		StringBuffer buffer = new StringBuffer();
		if (n < 4) {
			n = 4;
		}
		for (int i = 0; i < n; i++) {
			buffer.append(dictionary[random.nextInt(dictionary.length)]);
		}
		return buffer.toString();
	}

	static Color getRandomColor() {
		return new Color(random.nextInt(255), random.nextInt(200),
				random.nextInt(200));
	}

	static Color getReverseColor(Color c) {
		return new Color(255 - c.getRed(), 255 - c.getGreen(),
				255 - c.getBlue());
	}

@Override
	public void doPost(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		doGet(request, response);
	}
@Override
	public void doGet(HttpServletRequest request, HttpServletResponse response)
			throws ServletException, IOException {
		response.setContentType("image/jpeg");
		String randomString = getRandomString(4);
		request.getSession(true).setAttribute("validateCode", randomString);
		int width = 90; // 验证码图片宽度
		int height = 38; // 验证码图片高度
		Color color = getRandomColor();
		// 创建一个彩图
		BufferedImage bi = new BufferedImage(width, height,
				BufferedImage.TYPE_INT_RGB);
		// 绘图对象
		Graphics g = bi.getGraphics();
		//设置背景颜色
		//g.setColor(getReverseColor(color));
		g.setFont(new Font(Font.SANS_SERIF, Font.BOLD, 22));
		g.fillRect(0, 0, width, height);
		g.setColor(color);
		g.drawString(randomString, 18, 27);

		// 绘制25个噪音点
		for (int i = 0; i < 25; i++) {
			g.drawRect(random.nextInt(width), random.nextInt(height), 1, 1);
		}
		ServletOutputStream out = response.getOutputStream();
		ImageIO.write(bi, "JPEG", out);

		out.flush();
		out.close();
	}
}
