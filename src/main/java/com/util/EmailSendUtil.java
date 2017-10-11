package com.util;

import java.io.IOException;
import java.util.Properties;

import javax.activation.DataHandler;
import javax.activation.DataSource;
import javax.activation.FileDataSource;
import javax.mail.BodyPart;
import javax.mail.Message;
import javax.mail.MessagingException;
import javax.mail.Multipart;
import javax.mail.Session;
import javax.mail.Transport;
import javax.mail.internet.InternetAddress;
import javax.mail.internet.MimeBodyPart;
import javax.mail.internet.MimeMessage;
import javax.mail.internet.MimeMultipart;

import com.seller.constants.Constants;

import Decoder.BASE64Encoder;

/**
 * 邮件发送工具类
 * @author Allen Gong
 * @version V1.0
 * @date 2016-12-29 19:11
 */
public class EmailSendUtil {
    /**
     * 发送邮件
     * @param receiverEmail 收件邮箱
     * @param subject 邮件标题
     * @param content 邮件内容
     * @throws MessagingException
     * @throws IOException
     */
	public static void sendEmail(String receiverEmail, String subject, String content) throws MessagingException, IOException{
		sendEmail(receiverEmail, subject, content, null, null);
	}
    /**
     * 发送邮件-带附件
     * @param receiverEmail 收件邮箱
     * @param subject 邮件标题
     * @param content 邮件内容
     * @param affixPath 附件绝对路径
     * @param affixName 显示附件名
     * @throws MessagingException
     * @throws IOException
     */
	public static void sendEmail(String receiverEmail, String subject, String content, String affixPath, String affixName) throws MessagingException, IOException{
        String senderEmail = SystemConfig.getInstance().getValue(Constants.SENDER_EMAIL);
        String senderEmailPassword = SystemConfig.getInstance().getValue(Constants.SENDER_EMAIL_PASSWORD);
        Properties properties = PropertiesReaderUtil.reader("system.properties");
        Session session = Session.getDefaultInstance(properties);
        session.setDebug(true);

        MimeMessage message = new MimeMessage(session);

        message.setFrom(new InternetAddress(senderEmail));
        message.addRecipient(Message.RecipientType.TO, new InternetAddress(receiverEmail));
        message.setSubject(subject);
        //message.setContent(content, "text/html;charset=utf-8");
        
        //向multipart对象中添加邮件的各个部分内容，包括文本内容和附件
        Multipart multipart = new MimeMultipart();         
        //设置邮件的文本内容
        BodyPart contentPart = new MimeBodyPart();
        contentPart.setContent(content, "text/html;charset=utf-8");
        multipart.addBodyPart(contentPart);
        addAffix(multipart, affixPath, affixName);
        //将multipart对象放到message中
        message.setContent(multipart);
        //保存邮件
        message.saveChanges();

        Transport transport = session.getTransport();
        transport.connect(senderEmail, senderEmailPassword);
        transport.sendMessage(message, message.getAllRecipients());
        transport.close();
    }
   
    /**
     * 向邮件添加附件
     * @param multipart
     * @param affixPath
     * @param affixName
     */
    private static void addAffix(Multipart multipart, String affixPath, String affixName) throws MessagingException{
    	if(StringUtils.isBlank(affixPath)){
    		return;
    	}
		 //添加附件
        BodyPart messageBodyPart= new MimeBodyPart();
        DataSource source = new FileDataSource(affixPath);
        //添加附件的内容
        messageBodyPart.setDataHandler(new DataHandler(source));
        //添加附件的标题
        //这里很重要，通过下面的Base64编码的转换可以保证你的中文附件标题名在发送时不会变成乱码
		BASE64Encoder enc = new BASE64Encoder();
		if(StringUtils.isNotBlank(affixName)){
			messageBodyPart.setFileName("=?UTF-8?B?"+enc.encode(affixName.getBytes())+"?=");
		}
        multipart.addBodyPart(messageBodyPart);
    }
}
