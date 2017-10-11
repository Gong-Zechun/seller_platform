package com.util;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import com.seller.constants.Constants;
import com.util.encrypt.RSAUtils;

/**
 * 字符串工具类
 * @author Allen Gong
 * @version V1.0
 * @date 2016-11-28 16:54
 */
public class StringUtils extends org.apache.commons.lang.StringUtils{
    private static Pattern pattern;
    private static Matcher matcher;
    public static String emailPattern = "^(\\w-*\\.*)+@(\\w-?)+(\\.\\w{2,})+$";
    public static String pswPattern = "\\w{8,}";

    /**
     * ======================字符串取默认值处理start===============================
     */

    /**
     * 取Long型默认值
     * @param s 字符串
     * @param defaultValue 默认的long型数值
     * @return
     */
    public static long getLongValue(String s, long defaultValue) {
        if(s == null) {
            return defaultValue;
        } else {
            try {
                return Long.parseLong(s);
            } catch (Exception var4) {
                return defaultValue;
            }
        }
    }

    /**
     * 取Float型默认值
     * @param s 字符串
     * @param defaultValue 默认的float型值
     * @return
     */
    public static float getFloatValue(String s, float defaultValue) {
        if(s == null) {
            return defaultValue;
        } else {
            try {
                return Float.parseFloat(s);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    /**
     * 取Short型默认值
     * @param s 字符串
     * @param defaultValue 默认的short型值
     * @return
     */
    public static short getShortValue(String s, short defaultValue) {
        if(s == null) {
            return defaultValue;
        } else {
            try {
                return Short.parseShort(s);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    /**
     * 取Double型默认值
     * @param s 字符串
     * @param defaultValue 默认的double型值
     * @return
     */
    public static double getDoubleValue(String s, double defaultValue) {
        if(s == null) {
            return defaultValue;
        } else {
            try {
                return Double.parseDouble(s);
            } catch (Exception var4) {
                return defaultValue;
            }
        }
    }

    /**
     * 取int型默认值
     * @param s 字符串
     * @param defaultValue 默认的int型值
     * @return
     */
    public static int getIntValue(String s, int defaultValue) {
        if(s != null && s.length() != 0) {
            try {
                return Integer.parseInt(s);
            } catch (Exception var3) {
                return defaultValue;
            }
        } else {
            return defaultValue;
        }
    }

    /**
     * 取boolean型默认值
     * @param s 字符串
     * @param defaultValue 默认的boolean型值
     * @return
     */
    public static boolean getBooleanValue(String s, boolean defaultValue) {
        if(s == null) {
            return defaultValue;
        } else {
            try {
                return Boolean.parseBoolean(s);
            } catch (Exception var3) {
                return defaultValue;
            }
        }
    }

    /**
     * ======================字符串取默认值处理end===============================
     */

    public static boolean isElMatch(String str, String emailPattern) {
        pattern = Pattern.compile(emailPattern);
        matcher = pattern.matcher(str);
        if(matcher.matches()) {
            return true;
        }else {
            return false;
        }
    }
    
    /**
     * 根据排序字段和排序方式生成 order by 字符串
     * @param sort
     *            排序字段(多个字段间以,分割)
     * @param order
     *            排序方式(与order字段对应,多个排序方式以,分割)
     * @return
     */
    public static String generateSqlOrderByClause(String sort, String order) {
        StringBuilder orderBuilder = new StringBuilder();
        if (isNotBlank(order) && (isNotBlank(sort))) {
            String sortArray[] = sort.split(Constants.DATA_SPLIT_MARK_COMMA, -1);
            String orderArray[] = order.split(Constants.DATA_SPLIT_MARK_COMMA, -1);
            for (int m = 0; m < sortArray.length; m++) {
                if (m > 0) {
                    orderBuilder.append(",");
                }
                orderBuilder.append(camelToUnderLine(sortArray[m])).append(" ").append(orderArray[m]);
            }
        }
        return orderBuilder.toString();
    }
    
    /**
     * 将驼峰式命名的字符串转换为下划线大写方式。如果转换前的驼峰式命名的字符串为空，则返回空字符串。<br/>
     * 例如：HelloWorld->HELLO_WORLD
     * @param name
     *            转换前的驼峰式命名的字符串
     * @return 转换后下划线大写方式命名的字符串
     */
    public static String camelToUnderLine(String name) {
        StringBuilder result = new StringBuilder();
        if (name != null && name.length() > 0) {
            // 将第一个字符处理成大写
            result.append(name.substring(0, 1).toUpperCase());
            // 循环处理其余字符
            for (int i = 1; i < name.length(); i++) {
                String s = name.substring(i, i + 1);
                // 在大写字母前添加下划线
                if (s.equals(s.toUpperCase()) && !Character.isDigit(s.charAt(0))) {
                    result.append("_");
                }
                // 其他字符直接转成大写
                result.append(s.toUpperCase());
            }
        }
        return result.toString();
    }

    /**
     * 将下划线大写方式命名的字符串转换为驼峰式。如果转换前的下划线大写方式命名的字符串为空，则返回空字符串。<br/>
     * 例如：HELLO_WORLD->HelloWorld
     * @param name
     *            转换前的下划线大写方式命名的字符串
     * @return 转换后的驼峰式命名的字符串
     */
    public static String underLineToCamel(String name) {
        StringBuilder result = new StringBuilder();
        // 快速检查
        if (name == null || name.isEmpty()) {
            // 没必要转换
            return "";
//        } else if (!name.contains("_")) {
//            // 不含下划线，仅将首字母小写
//            return name.substring(0, 1).toLowerCase() + name.substring(1);
        }
        // 用下划线将原始字符串分割
        String camels[] = name.split("_");
        for (String camel : camels) {
            // 跳过原始字符串中开头、结尾的下换线或双重下划线
            if (camel.isEmpty()) {
                continue;
            }
            // 处理真正的驼峰片段
            if (result.length() == 0) {
                // 第一个驼峰片段，全部字母都小写
                result.append(camel.toLowerCase());
            } else {
                // 其他的驼峰片段，首字母大写
                result.append(camel.substring(0, 1).toUpperCase());
                result.append(camel.substring(1).toLowerCase());
            }
        }
        return result.toString();
    }


    public static void main(String[] args) {
    	Logger log = LoggerFactory.getLogger(RSAUtils.class);
    	StringBuilder sb = new StringBuilder(72580);
        for(int i=1; i<=62580; i++){
        	sb.append(",");
        	sb.append(i);
        }
        log.error(sb.toString());
        System.out.println("OK");
    }
}
