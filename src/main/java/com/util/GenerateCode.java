/**
 * 创建于: 2012-12-22 下午1:50:28<br>
 * 所属项目:Transn SG
 * 文件名称:GenerateCode.java
 * 作者:Allen Gong
 * 版权信息:Copyright (c) 2016~2016,  All Rights Reserved.
 */
package com.util;

import java.io.File;
import java.io.PrintWriter;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * 类功能描述:根据表结构生成代码
 * 
 * @history 2012-12-21 Allen Gong 创建GenerateCode.java
 *
 * @author Allen Gong
 * @version 0.1.0
* [1.0] 2016-12-22 Allen Gong add 根据表结构生成代码<br>
 */
public class GenerateCode {
	public static final String database = "transnsg";  
	public static final String url = "jdbc:mysql://59.151.103.73:3306/"+database;  
    public static final String name = "com.mysql.jdbc.Driver";
    public static final String user = "root";
    public static final String password = "ts123456";
    public static final boolean isOracle = false;
    
	public static void main(String[] arg) throws SQLException{
		Statement stmt = getConnect(isOracle);
		String allTablesSql = "select table_name from information_schema.tables where table_schema='"+database+"'";
		ResultSet rs=stmt.executeQuery(allTablesSql);
		List<String> tableNameList = new ArrayList<String>();
		while(rs.next()){
			tableNameList.add(rs.getString("table_name"));
		}
		for(String stable : tableNameList){
    		String currentPath = "";
    		File directory = new File("");//设定为当前文件夹 
    		currentPath = directory.getAbsolutePath()+"/src";//获取绝对路径  E:\JAVA\MYSPRINGSIDE
    		//包路径
    		String packagepath = "com.code";
    		String apppackage = "";
    		StringBuffer st = new StringBuffer();
    		stable = stable.toLowerCase();
    		//生成版权信息
    		st = createCopyright(StringUtils.capitalize(stable));
    		//加入PACKAGE
    		st.append("package com.sellersg.entity").append(";\r\n\r\n");
    		
//    		st.append("import java.io.Serializable;\r\n");
//    		st.append("import javax.persistence.GeneratedValue;\r\n");
//    		st.append("import javax.persistence.Table;\r\n");
//    		st.append("import javax.persistence.Id;\r\n");
//    		st.append("import javax.persistence.Transient;\r\n\r\n");
    		
    		//st.append("import org.hibernate.validator.constraints.NotBlank;\r\n");
    		st.append("import com.sellersg.page.AbstractPageEntity;\r\n\r\n");
//    		st.append("import org.vetech.core.modules.mybatis.entity.BusinessId;\r\n\r\n");
//    		st.append("import org.vetech.core.modules.utils.VeDate;\r\n\r\n");
    		
    		
//    		st.append("@Table(name = \"" + stable.toUpperCase()+"\")\r\n");
    		
    		String className = replaceToUpper(stable, true);
    		
    		st.append(createCopyright(StringUtils.capitalize(stable)));
    		st.append("public class ").append(StringUtils.capitalize(className)).append(" extends AbstractPageEntity {\r\n\r\n");
    		
//    		st.append("    @Id\r\n");
//    		st.append("    @GeneratedValue(generator=\"uuid\")\r\n");
    		
    		//中间是对应的字段清单
    		st.append(createBeanEntity(stmt,stable, isOracle));
    		
    		st.append("\r\n\r\n}");
    		
    		stable = stable.replaceAll("_", "");
    		
    		 try{
    			  writeFile(currentPath+"/" +StringUtils.replace(packagepath, ".", "/")+"/entity/"+apppackage,StringUtils.capitalize(className)+".java", 
    				st.toString());
    		 }catch(Exception es){
    			 es.printStackTrace();
    		 }
    		//生成DAO对象
    		st = new StringBuffer();		
    		//生成版权信息
    		st = createCopyright(StringUtils.capitalize(className) +"Dao"); 
    		//加入PACKAGE
    		st.append("package ").append(packagepath).append(".dao.").append(apppackage).append(";\r\n\r\n");
    		st = createDao(st,className,packagepath,apppackage);
    		writeFile(currentPath+"/" +StringUtils.replace(packagepath, ".", "/")+"/dao/"+ apppackage,
    				StringUtils.capitalize(className)+"Dao.java", 
    				st.toString());
    		
    		//生成service
    		st = new StringBuffer();
    		//生成版权信息
    		st =  createCopyright(StringUtils.capitalize(className)+"ServiceImpl"); 
    		//加入PACKAGE
    		st.append("package ").append(packagepath).append(".service.").append(apppackage).append(";\r\n\r\n");
    		st = createService(st,className,packagepath,apppackage);
    		writeFile(currentPath+"/" +StringUtils.replace(packagepath, ".", "/")+"/service/" + apppackage, 
    				StringUtils.capitalize(className)+"ServiceImpl.java", 
    				st.toString());
//    		
    		//生成controller
    		st = new StringBuffer();
    		//生成版权信息
    		st = createCopyright(StringUtils.capitalize(className)+"Controller"); 
    		//加入PACKAGE
    		st.append("package ").append(packagepath).append(".web.").append(apppackage).append(";\r\n\r\n");
    		st = createAction(st,className,packagepath,apppackage);
    		writeFile(currentPath+"/" +StringUtils.replace(packagepath, ".", "/")+"/web/" + apppackage, 
    				StringUtils.capitalize(className)+"Controller.java", 
    				st.toString());
		}
	}
	
	public static StringBuffer createDao(StringBuffer st,String table,String s_package,String apppackage){
		st.append("import org.vetech.core.modules.mybatis.mapper.Mapper;\r\n\r\n");
		
		
		st.append("import ").append(s_package).append(".entity.").append(apppackage).append(".").
		append(StringUtils.capitalize(table)).append(";\r\n\r\n");
		
		st.append("public interface ").
		append(StringUtils.capitalize(table)).append("Dao extends Mapper<").
		append(StringUtils.capitalize(table)).append(">{\r\n");
		  
		st.append("}");
		return st;
	}
	
	
	public static StringBuffer createService(StringBuffer st,String table,String s_package,String apppackage){
		st.append("import org.springframework.stereotype.Service;\r\n\r\n");
		st.append("import org.vetech.core.modules.service.MBaseService;\r\n\r\n");
		
		st.append("import ").append(s_package).append(".entity.").append(apppackage).append(".").
		append(StringUtils.capitalize(table)).append(";\r\n");
		st.append("import ").append(s_package).append(".dao.").append(apppackage).append(".").
		append(StringUtils.capitalize(table)).append("Dao;\r\n\r\n\r\n");
		
		st.append("@Service\r\n");
		st.append("public class ").
		append(StringUtils.capitalize(table)).append("ServiceImpl extends MBaseService<").
		append(StringUtils.capitalize(table)).append(",").
		append(StringUtils.capitalize(table)).append("Dao>").
		append("{\r\n\r\n");
		
		st.append("}");
		return st;
	}
	
	
	public static StringBuffer createAction(StringBuffer st,String table,String pack,String apppackage){
		 
		st.append("import org.springframework.stereotype.Controller;\r\n");
		st.append("import org.vetech.core.modules.web.MBaseControl;\r\n\r\n");
		
		st.append("import ").append(pack).append(".entity.").append(apppackage).append(".").
		append(StringUtils.capitalize(table)).append(";\r\n");
		st.append("import ").append(pack).append(".service.").append(apppackage).append(".").
		append(StringUtils.capitalize(table)).append("ServiceImpl;\r\n\r\n\r\n");
		
		st.append("@Controller\r\n");
		
		st.append("public class ").
			append(StringUtils.capitalize(table)).append("Controller extends MBaseControl<").
			append(StringUtils.capitalize(table)).append(",").
			append(StringUtils.capitalize(table)).append("ServiceImpl").
			append(">{\r\n\r\n");
		 
		st.append("    @Override\r\n").
			append("    public void insertInitEntity(").append(StringUtils.capitalize(table)).
			append("  t){\r\n").append("      \r\n").append("    }\r\n\r\n");
		st.append("}");
		return st;
	}
	
	public static StringBuffer createBeanEntity(Statement stmt,String table, boolean isOracle){
		ResultSet rs=null;
	    StringBuffer sbuffer = new StringBuffer();
	    StringBuffer sf1 = new StringBuffer();
	    try {
	    	String sql = "";
	    	if(isOracle){
	    		sql = "select t.column_name CN,t.data_type DT, t.data_scale DS, t.nullable NU,aa.comments CM from  USER_TAB_COLUMNS t ,"
				   		+ " user_col_comments aa where t.TABLE_NAME = aa.table_name and t.COLUMN_NAME=aa.column_name"
				   		+ " and t.table_name='"+table.toUpperCase()+"' order by t.column_id  ";
	    	} else {
	    		sql = "select t.COLUMN_NAME CN,t.DATA_TYPE DT, t.NUMERIC_SCALE DS, t.IS_NULLABLE NU,t.COLUMN_COMMENT CM  from information_schema.COLUMNS t where TABLE_SCHEMA='"+database+"' and TABLE_NAME='"+table.toLowerCase()+"'";
	    	}
	    	rs=stmt.executeQuery(sql);//
	    	while(rs.next()){
//			   if("N".equals(rs.getString("NU"))){//是否可为空
//				   sbuffer.append("\r\n    @NotBlank");  
//			   }
			   if(StringUtils.isNotBlank(rs.getString("CM"))){
				   sbuffer.append(" \r\t/**").append(rs.getString("CM")).append("*/");
			   }
			   String cname = rs.getString("CN");
			   String currentName = replaceToUpper(cname, false);
			   sbuffer.append("\r\tprivate ").append(getColumnType(rs.getString("DT"), rs.getInt("DS"), isOracle)).
	   			append(" ").append(currentName).append(";");
//			   System.out.println(rs.getString("CM")+"==========");
			   sf1.append("\r\t	public ").
			   		append(getColumnType(rs.getString("DT"), rs.getInt("DS"), isOracle)).
			   		append(" get").
			   		append(StringUtils.capitalize(currentName)).
			   		append("() {").
			   		append("\r\n		return ").
			   		append(currentName).
			   		append(";").append("\r\n	}");
			   sf1.append("\r\n	public void set").append(StringUtils.capitalize(currentName)).append("(").
		  		append(getColumnType(rs.getString("DT"), rs.getInt("DS"), isOracle)).append(" ").
		  		append(currentName).
		  		append(") {").
		  		append("\r\n		this.").
		  		append(currentName).append(" = ").
		  		append(currentName).append(";").
		  		append("\r\n	}");
		   }
	    } catch (Exception e) {
	    	e.printStackTrace();
	    }
	    return sbuffer.append("\r\n\r\n").append(sf1);
	}
	
	/**
	 * 判断字母大小写
	 * @param word
	 * @return
	 */
	public static boolean isAcronym(String word){
	  for(int i = 0; i < word.length(); i++)
	  {
	   char c = word.charAt(i);
	   if (!Character.isLowerCase(c))
	   {
	    return false;
	   }
	  }
	  return true;
	}
	
	/**
	 * ColumnType转换
	 * @param stype
	 * @return
	 */
	public static String getColumnType(String stype, int scale, boolean isOracle){
		String st  = "String"; //默认为String
		stype = stype.toUpperCase();
		if("VARCHAR".equals(stype) || "CHAR".equals(stype) || "CHAR".equals(stype) )
			st =  "String";
		else if("BIGINT".equals(stype))
			st="Long";
		else if("INT".equals(stype) || "INTEGER".equals(stype) )
			st="Integer";
		else if("DECIMAL".equals(stype))
			st="BigDecimal";
		else if("DATE".equals(stype) || "TIMESTAMP".equals(stype)){
			st="Date";
		} else if(("NUMBER".equals(stype) || "NUMERIC".equals(stype)) && scale == 0){
			st="Integer";
		} else if(("NUMBER".equals(stype) || "NUMERIC".equals(stype)) && scale > 0){
			st="BigDecimal";
		} else if("DOUBLE".equals(stype)){
			st="BigDecimal";
		}
		return st; //
	}

	
	/**
	 * 创建版权信息
	 * @param JavaName
	 * @return
	 */
	public static StringBuffer createCopyright(String JavaName){
		StringBuffer scopy= new StringBuffer();
		scopy.append("/**\r\n");
		scopy.append("*@Description: \r\n");
		scopy.append("*@Author:   Allen Gong").append("\r\n");
		scopy.append("*@Version:  1.0").append("\r\n");
		scopy.append("*@Date:  ").append(DateUtils.getCurrentDateTime()).append("\r\n");
		scopy.append("*/").append("\r\n\r\n");
		return scopy;
	}
	
	/**
	 * 数据库连接
	 * @return
	 * @throws SQLException 
	 */
	public static Statement getConnect(boolean isOracle) throws SQLException{
		Connection conn = null;
		if(isOracle){
			String url = "jdbc:oracle:thin:@192.168.1.71:1521:vedb";
			String userName = "VEDS_JP";   
			String password = "VEDS_JP";
			try{
//				DriverManager.registerDriver(new oracle.jdbc.driver.OracleDriver());
				conn=DriverManager.getConnection(url, userName, password);   
			}catch(Exception es){
				System.out.println("ERROR: Can not get DB connect!!!" + es.getMessage());
				return null;
			}
		} else {
			try {
	            Class.forName(name);//指定连接类型  
	            conn = DriverManager.getConnection(url, user, password);//获取连接  
	        } catch (Exception e) {  
	            e.printStackTrace();  
	        }
		}
			
		return conn.createStatement();
	}
	
	/**
	 * 写文件，可以传入编码
	 */
	public static void writeFile(String path, String filename, String fileContent) {
		try {
			File file = new File(path);
			if (!file.exists()) {
				file.mkdirs();
			}
			file = new File(path + "\\" + filename);
			PrintWriter pwrite = null;
			pwrite = new PrintWriter(file, "UTF-8");
			pwrite.println(fileContent);
			pwrite.close();
		} catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	public static String replaceToUpper(String name, boolean isClassName){
	   String[] splitName = name.toLowerCase().split("_");
	   StringBuffer currentName = null;
	   for(String split : splitName){
	   	   String firstChar = split.substring(0, 1);
		   if(currentName == null){
			   currentName = new StringBuffer();
			   if(isClassName){
				   currentName.append(split.replaceFirst(firstChar, firstChar.toUpperCase()));
			   } else {
				   currentName.append(split);
			   }
		   } else {
			   currentName.append(split.replaceFirst(firstChar, firstChar.toUpperCase()));
		   }
	   }
	   if(currentName != null){
		   return currentName.toString();
	   }
	   return "";
	}
}


