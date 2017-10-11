package com.util;

import java.text.DecimalFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

import org.apache.log4j.Logger;
/**
 * 类功能描述：日期工具类
 * @author Allen Gong
 * @version 1.0.0
 * @history 2017-04-10 Allen Gong 创建
 */
public class DateUtils extends org.apache.commons.lang3.time.DateUtils{
    private static final Logger logger = Logger.getLogger(DateUtils.class);
    /** 日期格式：yyyyMMddHHmmssSSS */
    public static final String YMDHMSSS = "yyyyMMddHHmmssSSS";

    // Grace style
    public static final String PATTERN_GRACE = "yyyy/MM/dd HH:mm:ss";
    public static final String PATTERN_GRACE_NORMAL = "yyyy/MM/dd HH:mm";
    public static final String PATTERN_GRACE_SIMPLE = "yyyy/MM/dd";

    // Classical style
    public static final String PATTERN_CLASSICAL = "yyyy-MM-dd HH:mm:ss";
    public static final String PATTERN_CLASSICAL_NORMAL = "yyyy-MM-dd HH:mm";
    public static final String PATTERN_CLASSICAL_SIMPLE = "yyyy-MM-dd";

    private  static SimpleDateFormat shortSdf =  new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
    private  static SimpleDateFormat longSdf = new SimpleDateFormat(PATTERN_CLASSICAL);

    public static String changeDateToMysql(long time) {
        Date d = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat(PATTERN_CLASSICAL_NORMAL);
        String date = format.format(d);
        return date;
    }

    public static String getYear() {
        Calendar now = Calendar.getInstance();
        return  now.get(Calendar.YEAR)+"";
    }

    public static String getMonth() {
        Calendar now = Calendar.getInstance();
        return  (now.get(Calendar.MONTH) + 1)+"";
    }

    public static String getLastMonth() {
        Calendar now = Calendar.getInstance();
        return  (now.get(Calendar.MONTH))+"";
    }

    public  static String changeDateToSystem(String time) throws ParseException {
        SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL_NORMAL);
//		    String time="2011-09-11 16:35";
        Date date = format.parse(time);
//		    System.out.print("Format To times:"+date.getTime());
        return date.getTime()+"";

    }

    /**
     * 字符串转Date类型
     * @param time “yyyy-MM-dd”
     * @return
     */
    public static Date changeStringToDate(String time) throws ParseException {
        try{
            if(StringUtils.isNotBlank(time)) {
                SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
                Date date = format.parse(time);
                return date;
            }else {
                return null;
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转Date类型
     * @param time “yyyy-MM-dd HH:mm”
     * @return
     */
    public static Date changeStringToDateNormal(String time) throws ParseException {
        try{
            if(StringUtils.isNotBlank(time)) {
                SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL_NORMAL);
                Date date = format.parse(time);
                return date;
            }else {
                return null;
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 字符串转Date类型
     * @param time “yyyy-MM-dd HH:mm:ss”
     * @return
     */
    public static Date changeStringToDateTime(String time){
        try{
            if(StringUtils.isNotBlank(time)) {
                SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL);
                Date date = format.parse(time);
                return date;
            }else {
                return null;
            }
        } catch(ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 转变日期为字符串
     * @param date java.util.Date
     * @return yyyy-MM-dd
     */
    public static String changeDateToString(Date date){
        String dateStr = "";
        try{
            SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
            dateStr = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }

    /**
     * 转变时间为字符串
     * @param date java.util.Date
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static String changeTimeToString(Date date){
        String dateStr = "";
        if(date == null) {
            return null;
        }
        try{
            SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL);
            dateStr = format.format(date);
        } catch (Exception e) {
            e.printStackTrace();
        }
        return dateStr;
    }


    /**
     * 获得本月的开始时间，即2012-01-01 00:00:00
     *
     * @return
     */
    public static Date getCurrentMonthStartTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            now = shortSdf.parse(shortSdf.format(c.getTime()));
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    /**
     * 当前月的结束时间，即2012-01-31 23:59:59
     *
     * @return
     */
    public static  Date getCurrentMonthEndTime() {
        Calendar c = Calendar.getInstance();
        Date now = null;
        try {
            c.set(Calendar.DATE, 1);
            c.add(Calendar.MONTH, 1);
            c.add(Calendar.DATE, -1);
            now = longSdf.parse(shortSdf.format(c.getTime()) + " 23:59:59");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return now;
    }

    public static  Long getLongDate(String date){
        try {
            date=date.replaceAll("\"", "");
            Date newDate =shortSdf.parse(date);
            return newDate.getTime();
        } catch (ParseException e) {
            logger.error("字符串格式时间转化成Long类型出错",e);
        }
        return null;

    }
    /**
     *
     * @Title: getLongDate
     * @Description:
     * @param date
     * @param formart
     * @return
     * @return String
     */
    public static  String getLongDate(String date,String formart){
        try {
            SimpleDateFormat f=new SimpleDateFormat(formart);
            Date newDate=f.parse(date);
            Long time=newDate.getTime();
            return time.toString();
        } catch (ParseException e) {
            logger.error("字符串格式时间转化成Long类型出错",e);
        }
        return null;

    }

    public static String getStringDate(long time) {
        Date d = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
        String date = format.format(d);
        return date;

    }
    /**
     *
     * @Title: getDatesBetweenTwoDate
     * @Description: 获取时间段的整个时间
     * @param beginDate
     * @param endDate
     * @return
     * @return List<String>
     */
    @SuppressWarnings({ "rawtypes", "unchecked" })
    public static List<Long> getDatesBetweenTwoDate(String beginDate, String endDate) {

        try {
            SimpleDateFormat format =  new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
            Date date1 = format.parse(beginDate);
            Date date2=format.parse(endDate);
            List lDate = new ArrayList();
            lDate.add(date1.getTime());//把开始时间加入集合
            Calendar cal = Calendar.getInstance();
            //使用给定的 Date 设置此 Calendar 的时间
            cal.setTime(date1);
            boolean bContinue = true;
            while (bContinue) {
                //根据日历的规则，为给定的日历字段添加或减去指定的时间量
                cal.add(Calendar.DAY_OF_MONTH, 1);
                // 测试此日期是否在指定日期之后
                if (date2.after(cal.getTime())) {
                    Long date= cal.getTime().getTime();
                    lDate.add(date);
                } else {
                    break;
                }
            }
            lDate.add(date2.getTime());//把结束时间加入集合
            return lDate;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }
    /**
     *
     * @Title: getAge
     * @Description: 通过出生日期计算时间
     * @param brithTime
     * @return
     * @return String
     */
    public static String getAge(String brithTime){
        Integer age=0;
        try {
            SimpleDateFormat format =new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
            Calendar born = Calendar.getInstance();
            Calendar now = Calendar.getInstance();
            if(brithTime !=null){
                born.setTime(format.parse(brithTime));
                now.setTime(new Date());
                if(born.after(now)){
                    throw new IllegalArgumentException("Can't be born in the future");
                }
                age=now.get(Calendar.YEAR) - born.get(Calendar.YEAR);
                if(now.get(Calendar.DAY_OF_YEAR) < born.get(Calendar.DAY_OF_YEAR)){
                    age-=1;
                }
            }

        } catch (ParseException e) {
            e.printStackTrace();
        }
        return age.toString();

    }
    //判断当前时间是否在一个时间段内
    @SuppressWarnings("static-access")
    public static boolean isInDate(Date date, String strDateBegin,
                                   String strDateEnd){
        try {
            Calendar caldate = Calendar.getInstance();
            Calendar dateBegin = Calendar.getInstance();
            Calendar dateEnd = Calendar.getInstance();
            Date begintime=shortSdf.parse(strDateBegin);
            Date endTime=shortSdf.parse(strDateEnd);
            caldate.setTime(date);
            dateBegin.setTime(begintime);
            dateEnd.setTime(endTime);
            dateEnd.add(dateEnd.DATE, 1);
            if(caldate.before(dateBegin)){
                return false;
            }
            if(caldate.after(dateEnd)){
                return false;
            }
            return true;
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return false;


    }

    public static String createCardNO(Integer type,String i){
        String lastnumber="";
        SimpleDateFormat sd = new SimpleDateFormat("yyyyMMdd");
        Date date =new Date();
        String cardNO=sd.format(date);
        cardNO=cardNO.substring(2, cardNO.length());
        //生成后四位
        int siteSum=4-i.length();
        for (int j = 0; j < siteSum; j++) {
            lastnumber+="0";
        }
        if(type==1){
            cardNO="N86"+cardNO+"888"+lastnumber+i;
        }
        if(type==2){
            cardNO="S86"+cardNO+"888"+lastnumber+i;
        }
        return cardNO;
    }
    public static String getNowTime() {
        Date date = new Date();
        SimpleDateFormat dateFormat = new SimpleDateFormat("yyyyMMddHHmm");
        return dateFormat.format(date);
    }
    /**
     * 短信固定时间
     * @param time
     * @return
     */
    public static String getMsgStringTime(long time) {
        Date d = new Date(time);
        SimpleDateFormat format = new SimpleDateFormat("yyyy年MM月dd日 HH:mm");
        String date = format.format(d);
        return date;

    }
    public static boolean sameDay(String daystr){
        SimpleDateFormat format = new SimpleDateFormat("yyyyMMdd");
        String nowdate=format.format(new Date());
        if(nowdate.substring(2,nowdate.length()).equals(daystr)){
            return true;
        }else{
            return false;
        }
    }

    /**
     * 获取系统当前年月日（格式：yyyy-MM-dd）
     * @return
     */
    public static String getCurrentDate() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_CLASSICAL_SIMPLE);
        return df.format(date);
    }

    /**
     * 获取系统当前年月日（格式：yyyy-MM-dd HH:mm:ss）
     * @return
     */
    public static String getCurrentTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_CLASSICAL);
        return df.format(date);
    }

    /**
     * 获取当前时间
     * @return yyyy-MM-dd HH:mm:ss
     */
    public static Date getCurrentDateTime() {
        Date date = new Date();
        SimpleDateFormat df = new SimpleDateFormat(PATTERN_CLASSICAL);

        String s = df.format(date);

        Date d2 = null;
        try {
            d2 = df.parse(s);
        } catch (ParseException e) {

            e.printStackTrace();
        }

        return d2;
    }

    /**
     * long类型转为String类型（例：1489593600000转成2017-03-16）
     * @param millSec
     * @return
     */
    @SuppressWarnings("unused")
    private static String transferLongToDate(Long millSec){
        Date date= new Date(millSec);
        return shortSdf.format(date);
    }

    /**
     *  计算天数的系数
     *  预估费天数计算方式：
     默认每天工作时间为9:00-18:00 共8个小时，包含用餐时间。
     计算包含三部分:
     1. 第一天开始时间至18:00，若时间段＞4个小时≤8小时，按全天算，若≤4个小时，按0.6天计算，若≥8个小时，按1.6天算。
     2. 最后一天9:00至结束时间，计算方式同第一天
     3. 中间天数均按全天算
     * @Title: calculateDay
     * @Description: 计算天数的系数
     * @param beginTime
     * @param endTime
     * @return
     * @throws ParseException
     * @return double
     */
    public static String calculateDay(String beginTime, String endTime) {
        DecimalFormat df = new DecimalFormat("######0.00");
        SimpleDateFormat sd = new SimpleDateFormat(PATTERN_CLASSICAL_NORMAL);
        try {
            Long time = sd.parse(endTime).getTime() - sd.parse(beginTime).getTime();
            long nd = 1000 * 24 * 60 * 60;// 一天的毫秒数
            long nh = 1000 * 60 * 60;// 一小时的毫秒数
            long fz = 1000 * 60;// 分钟的毫秒数
            int day = (int) (time / nd) + 1;// 计算差多少天
            int hour = (int) (time % nd / nh);// 计算差多少小时
            int minute = (int) (time % nd % nh / fz);// 计算差多少小时

            if (hour <= 4 && hour > 0) {
                if (minute > 0) {
                    return df.format(day * 1);
                } else {
                    return df.format(day * 0.6);
                }
            } else if (hour > 4 && hour <= 9) {
                if (minute > 0 && hour == 9) {
                    return df.format(day * 1.6);
                } else {
                    return df.format(day * 1);
                }
            } else if (hour > 9) {
                return df.format(day * 1.6);
            } else {
                return df.format(day);
            }
        } catch (ParseException e) {
            e.printStackTrace();
        }
        return null;
    }

    /**
     * 返回两个日期之间相差小时数
     * @param startTime
     * @param endTime
     * @return
     */
    public static double getHoursBetweenTwoDate(Date startTime, Date endTime) {
        double diff = endTime.getTime() - startTime.getTime();
        double result = (diff / (double)(1000 * 60 * 60));
        DecimalFormat df = new DecimalFormat("######.00");
        return Double.parseDouble(df.format(result));
    }

    /***
     *
     * @param date
     * @param dateFormat : e.g:yyyy-MM-dd HH:mm:ss
     * @return
     */
    public static String formatDateByPattern(Date date,String dateFormat){
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        String formatTimeStr = null;
        if (date != null) {
            formatTimeStr = sdf.format(date);
        }
        return formatTimeStr;
    }

    /**
     * Date转为cron
     * @param date
     * @return
     */
    public static String getCron(java.util.Date  date){
        String dateFormat="ss mm HH dd MM ? yyyy";
        return formatDateByPattern(date, dateFormat);
    }
    /**
     * cron表达式转为日期
     * @param cron
     * @return
     */
    public static Date cronToDate(String cron) {
        String dateFormat="ss mm HH dd MM ? yyyy";
        SimpleDateFormat sdf = new SimpleDateFormat(dateFormat);
        Date date = null;
        try {
            date = sdf.parse(cron);
        } catch (ParseException e) {
            return null;
        }
        return date;
    }
    public static String getDayCron(java.util.Date  date){
        //String dateFormat="ss mm HH dd MM ? yyyy";
        //String dateFormat = "0 mm HH ? *";
        String dateFormat = "mm HH";
        return formatDateByPattern(date, dateFormat);
    }
    public static String getMinuteCron(java.util.Date  date){
        //String dateFormat="ss mm HH dd MM ? yyyy";
        //String dateFormat = "0 mm HH ? *";
        String dateFormat = "mm";
        return formatDateByPattern(date, dateFormat);
    }
    public static String getHourCron(java.util.Date  date){
        //String dateFormat="ss mm HH dd MM ? yyyy";
        //String dateFormat = "0 mm HH ? *";
        String dateFormat = "HH";
        return formatDateByPattern(date, dateFormat);
    }
    /**
     * date2比date1多的天数
     * @param startDate
     * @param endDate
     * @return
     */
    public static int differentDays(Date startDate, Date endDate) {
        Calendar cal1 = Calendar.getInstance();
        cal1.setTime(startDate);

        Calendar cal2 = Calendar.getInstance();
        cal2.setTime(endDate);
        int day1= cal1.get(Calendar.DAY_OF_YEAR);
        int day2 = cal2.get(Calendar.DAY_OF_YEAR);

        int year1 = cal1.get(Calendar.YEAR);
        int year2 = cal2.get(Calendar.YEAR);
        if(year1 != year2){//同一年
            int timeDistance = 0 ;
            for(int i = year1 ; i < year2 ; i ++){
                if(i%4==0 && i%100!=0 || i%400==0){//闰年
                    timeDistance += 366;
                } else {//不是闰年
                    timeDistance += 365;
                }
            }
            return timeDistance + (day2-day1) ;
        } else {//不同年
            return day2-day1;
        }
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param startDate
     * @param endDate
     * @return
     */
    public static int differentDaysByMillisecond(Date startDate, Date endDate){
        return (int) ((endDate.getTime() - startDate.getTime()) / (1000*3600*24));
    }

    public static void main(String[] args) throws ParseException {
//		System.out.println(calculateDay("2017-03-01 09:00","2017-03-02 12:00"));
//		System.out.println(calculateDay("2017-03-17 09:00","2017-03-17 17:01"));
//		String x = transferLongToDate(Long.parseLong("1489593600000"));
//		System.out.println(x);
//
//		Long x1 = getLongDate("2017-04-20");
//		System.out.println(x1);
//		String x = "2017-04-12 09:00";
//		String y = x.substring(0, x.lastIndexOf("-"));
//	    DateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
//	    Date d1 = df.parse("2017-07-26 13:00:20");
////	    Date d2 = df.parse("2017-07-26 16:00:50");
//		System.out.println(getCron(d1));
        //0.006805530503060764
        //1.336425467601915
        double t1 = DateUtils.getHoursBetweenTwoDate(DateUtils.changeStringToDateTime("2017-01-24 10:15:25"), new Date());
        double p1 = 41;
        double score1 = p1/Math.pow((t1+2), 1.5);
        System.out.println(score1);
    }

}
