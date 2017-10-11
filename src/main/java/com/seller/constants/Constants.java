/**
 * 创建于: 2012-12-10 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:Constants.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.seller.constants;

/**
 * 类功能描述:常量类,定义系统中用到的一些常量 Constants.java
 * 
 * @history 2012-12-21 Allen Gong 创建Constants.java
 * 
 * @author Allen Gong
 * @version 0.1.0
* [1.5] 2016-12-22 Allen Gong add 添加全局常亮<br>
 */
public final class Constants {
	/**
	 * 系统附件路径
	 */
	public static final String FILE_PATH = "FILE_PATH";
	/**
	 * 订单文件路径
	 */
	public static final String ORDER_FILES = "/orderFiles/";
	/**
	 * 上传文件的类型
	 */
	public static final String[] FILE_TYPE = {".MP3", ".MP4", ".WMV", ".AIF", ".M4A", ".MOV",
			".AVI", ".VOB", ".AMR", ".WMA", ".OGG", ".WAV", ".WAV", ".SCC", ".TXT", ".SRT", ".DOC", ".DOCX", ".XLS", ".XLSX"};

    public static final String[] DOCUMENT_FILE_TYPE = {".TXT", ".SRT", ".DOC", ".DOCX", ".XLS", ".XLSX"};

	/**
	 * 上传的最大文件个数
	 */
	public static final int MAXIMUM_FILE_COUNTS = 5;

	/**
	 * 发邮件相关
	 */
	public static final String emailTemplatePath = "emailTemplate/";

	public static final String SENDER_EMAIL = "mail.sender";

	public static final String SENDER_EMAIL_PASSWORD = "mail.sender.password";

	public static final String SENDER_EMAIL_HOST = "mail.host";

	public static final String EMAIL_SUBJECT = "mail.subject";
	
	/**
	 * HTML转PDF工具执行文件路径
	 */
	public static final String WKHTMLTOPDF_TOOL_PATH = "WKHTMLTOPDF_TOOL_PATH";

	//Global客服邮箱
	public static final String CUSTOM_SERVICE_EMAIL = "global-support@transn.com";
	
	 /**
     * 标识常量,真
     */
    public static final String FLAG_TRUE = "1";
    
    /**
     * 标识常量,假
     */
    public static final String FLAG_FALSE = "0";
    
    /**
     * 常量_YES:Y
     */
    public static final String FLAG_YES = "Y";
    
    /**
     * 常量_NO:N
     */
    public static final String FLAG_NO = "N";
    
    /**
     * Ajax请求返回代码
     */
    public static final String RESULT_CODE = "CODE";
    /**
     * Ajax请求返回信息
     */
    public static final String RESULT_MSG = "MSG";
    /**
     * Ajax请求成功返回
     */
    public static final String RESULT_CODE_SUCESS = "SUCESS";
    /**
     * Ajax请求失败返回
     */
    public static final String RESULT_CODE_ERROR = "ERROR";
	/**
	 * 数据分隔符-逗号
	 */
	public static final String DATA_SPLIT_MARK_COMMA = ",";
	
	/**
	 * 数据分隔符-下划线
	 */
	public static final String DATA_SPLIT_MARK_UNDERLINE = "_";
	
	/**
	 * Java目录分割符
	 */
	public static final String JAVA_PATH_SEPARATOR = "/";
	
	/**
	 * 动态生成列-行名称
	 */
	public static final String DYNAMIC_COLS_DATA_ROW_NAME = "rowName";
	
	/**
	 * 商业合伙人证照图片路径
	 */
	public static final String BUS_PARTNER_PHOTO_DIR = "/partnerPhotos/";

	/**
	 * 无法读取文件的播放时长
	 */
	public static final int UNCALCULATE_FILE_LENGTH = -4;
}
