package com.demo.common.util;

import org.apache.commons.lang3.time.DateFormatUtils;

import java.text.ParseException;
import java.text.ParsePosition;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.Calendar;
import java.util.Date;
import java.util.List;

public class DateUtil {

    /** 时间格式：yyyy-MM-dd HH:mm */
    public final static String DATE_MINUTE_PATTERN = "yyyy-MM-dd HH:mm";
    /** 时间格式：yyyy-MM-dd */
    public final static String DATE_PATTERN = "yyyy-MM-dd";
    /** 时间格式：HH:mm */
    public final static String DATE_HOUR = "HH:mm";
    /** 时间格式：M月dd日 */
    public final static String DATE_MONTH_PATTERN = "M月dd日";
    /** 时间格式：M月dd日 HH:mm */
    public final static String DATE_MONTH_HOUR_PATTERN = "M月dd日 HH:mm";
    /** 时间格式：yyyy-MM-dd HH:mm:ss */
    public final static String DATE_SECOND_PATTERN = "yyyy-MM-dd HH:mm:ss";
    /** 时间格式：yyyyMMddHHmmss */
    public final static String DATE_SECOND_NO_PATTERN = "yyyyMMddHHmmss";
    /** 时间格式：HHmmss */
    public final static String SECOND_NO_PATTERN = "HHmmss";

    private final static String[] weekDays = {"周日", "周一", "周二", "周三", "周四",
            "周五", "周六"};


    public static Date parse(String dateStr, String pattern) {
        if (dateStr != null) {
            SimpleDateFormat sdf = new SimpleDateFormat(pattern);
            try {
                return sdf.parse(dateStr);
            } catch (ParseException e) {
                e.printStackTrace();
            }
        }
        return null;
    }

    /**
     * 与当前时间做比较，类型是yyyy-MM-dd
     *
     * @param date 类型是yyyy-MM-dd
     * @return 返回 1 当前日期 > date, 返回 0 当前日期 = date, 返回 -1 当前日期 < date
     * @throws ParseException
     */
    public static int compareNowDate(String date) throws ParseException {
        // String pattern = "yyyy-MM-dd";
//		String nowDate = new SimpleDateFormat(DATE_PATTERN).format(new Date());
//		return compareDate(nowDate, DATE_PATTERN, date, DATE_PATTERN);
        // 徒步的业务逻辑是, 不超过当天10点，都能购票
//        if (Constant.isPedestrianism) {
//            String nowDate = new SimpleDateFormat(DATE_MINUTE_PATTERN).format(new Date());
//            return compareDate(nowDate, DATE_MINUTE_PATTERN, date + " 10:00", DATE_MINUTE_PATTERN);
//        } else {
            return compareDate(DateFormatUtils.format(new Date(), "yyyy-MM-dd"), "yyyy-MM-dd", date, "yyyy-MM-dd");
    //    }
    }

    /**
     * 与当前时间做比较，类型自定义
     *
     * @param date 待比较时间
     * @param pattern 时间格式类型
     * @return 返回 1 当前日期 > date, 返回 0 当前日期 = date, 返回 -1 当前日期 < date
     * @throws ParseException
     */
    public static int compareNowDate(String date, String pattern) throws ParseException {
        return compareDate(DateFormatUtils.format(new Date(), pattern), pattern, date, pattern);
    }


    /**
     * 日期比较
     *
     * @param secondDate
     * @param pattern
     * @param firstDate
     * @param lastpattern
     * @return 1 firstDate > secondDate, 0 secondDate = firstDate, -1 firstDate
     * < secondDate
     * @throws ParseException
     */
    public static int compareDate(String firstDate, String pattern,
                                  String secondDate, String lastpattern) throws ParseException {
        Date date = null;
        Date compareDate = null;

        date = new SimpleDateFormat(pattern).parse(firstDate);
        compareDate = new SimpleDateFormat(lastpattern).parse(secondDate);

        if (date.getTime() > compareDate.getTime()) {
            return 1;
        } else if (date.getTime() == compareDate.getTime()) {
            return 0;
        } else {
            return -1;
        }

    }

    public static Date nowDateAddDay(Date date, int day) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.DATE, day);// num为增加的天数，可以改变的
        return c.getTime();
    }

    public static Date nowDateAddMinute(Date date, int minute) {
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        c.add(Calendar.MINUTE, minute);
        return c.getTime();
    }

    public static Date nowDateAddDay(int day) {
        Calendar c = Calendar.getInstance();
        c.add(Calendar.DATE, day);// num为增加的天数，可以改变的
        return c.getTime();
    }

    public static String getWeek(String sdate) {
        // 再转换为时间
        Date date = strToDate(sdate);
        Calendar c = Calendar.getInstance();
        c.setTime(date);
        int day = c.get(Calendar.DAY_OF_WEEK) - 1;

        if (day < 0) {
            day = 0;
        }

        return weekDays[day];

        // hour中存的就是星期几了，其范围 1~7
        // 1=星期日 7=星期六，其他类推
        // String value = new SimpleDateFormat("EEEE").format(c.getTime());
        // log.info("value={}",value);
        // return value;
    }



    public static Date strToDate(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date strToDateHour(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_MINUTE_PATTERN);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }
    
    
    public static Date strToDateSecond(String strDate) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_SECOND_PATTERN);
        ParsePosition pos = new ParsePosition(0);
        Date strtodate = formatter.parse(strDate, pos);
        return strtodate;
    }

    public static Date nowDate() {
        Date nowDate = new Date(System.currentTimeMillis());
        String str = dateToStr(nowDate);
        return strToDate(str);

    }

    /**
     * 时间转换字符串(自定义格式)
     * @param date 时间
     * @param pattern 自定义格式
     * @return String
     */
    public static String dateToStr(Date date, String pattern) {
        SimpleDateFormat formatter = new SimpleDateFormat(pattern);
        return formatter.format(date);
    }

    public static String dateToStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_PATTERN);
        return formatter.format(date);
    }

    public static String dateToMonthStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_MONTH_PATTERN);
        return formatter.format(date);
    }

    public static String strToMonthStr(String strDate) {
        Date date = strToDate(strDate);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_MONTH_PATTERN);
        return formatter.format(date);
    }

    public static String strToMonthHourStr(String strDate) {
        Date date = strToDateHour(strDate);
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_MONTH_HOUR_PATTERN);
        return formatter.format(date);
    }

    public static String dateToSecondStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_SECOND_PATTERN);
        return formatter.format(date);
    }

    public static String dateToHourStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_MINUTE_PATTERN);
        return formatter.format(date);
    }

    public static String dateToOnlyHourStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_HOUR);
        return formatter.format(date);
    }


    public static String dateToSecondNoStr(Date date) {
        SimpleDateFormat formatter = new SimpleDateFormat(DATE_SECOND_NO_PATTERN);
        return formatter.format(date);
    }


    /**
     * 与当前日期比较相差几天
     * @param strDate
     * @return
     * @throws ParseException
     */
    public static int compareNowDays(String strDate) throws ParseException {
        SimpleDateFormat format = new SimpleDateFormat(DATE_PATTERN);
        Date date = format.parse(strDate);
        Date nowDate = nowDate();

        return differentDaysByMillisecond(nowDate, date);
    }

    /**
     * 通过时间秒毫秒数判断两个时间的间隔
     * @param date1
     * @param date2
     * @return
     */
    public static int differentDaysByMillisecond(Date date1, Date date2) {
        long time = date2.getTime() - date1.getTime();
        int days = (int) (time / (1000 * 3600 * 24));
        return days;
    }

    /**
     * 判断现在和查询日期相差分钟数
     * @param strHour
     * @return 比较时间 - 现在时间
     */
    public static int differentMinuteByNow(String strHour) {
        String day = "2018-01-01 ";
        Date date1 = strToDateHour(day + strHour);
        Calendar c = Calendar.getInstance();
        int hour = c.get(Calendar.HOUR_OF_DAY);
        int minute = c.get(Calendar.MINUTE);
        if (hour < 10) {
            day = day + "0" + hour;
        } else {
            day = day + hour;
        }
        day += ":";
        if (minute < 10) {
            day = day + "0" + minute;
        } else {
            day = day + minute;
        }
        Date nowDate = strToDateHour(day);
        long time = date1.getTime() - nowDate.getTime();
        return (int) (time / (1000 * 60));

    }

    /**
     * 判断两个日期相差分钟数
     * @param strDate1 HH:MM
     * @param strDate2 HH:MM
     * @return date2 - date1 分钟数
     */
    public static int differentMinuteByHour(String strDate1, String strDate2) {
        String day = "2018-01-01 ";
        Date date1 = strToDateHour(day + strDate1);
        Date date2 = strToDateHour(day + strDate2);
        long time = date2.getTime() - date1.getTime();
        int minute = (int) (time / (1000 * 60));
        return minute;
    }

    /**
     * date2 - date1 相差分钟数
     */
    public static int differentMinuteByDATE_MINUTE_PATTERN(Date date1, Date date2) {
        long time = date2.getTime() - date1.getTime();
        int minute = (int) (time / (1000 * 60));
        return minute;
    }


    public static Date getFirstMonthDay() {
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // String firstday;
        // 获取前月的第一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 0);
        cale.set(Calendar.DAY_OF_MONTH, 1);
        // Date date = cale.getTime();
        String firstday = format.format(cale.getTime());
        return strToDate(firstday);
    }

    public static Date getEndMonthDay() {
        Calendar cale = null;
        cale = Calendar.getInstance();
        // 获取当月第一天和最后一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        String lastday = format.format(cale.getTime());
        return strToDate(lastday);
    }

    public static Date getEndMonthDay2() {
        Calendar cale = null;
        // 获取前月的最后一天
        cale = Calendar.getInstance();
        cale.add(Calendar.MONTH, 1);
        cale.set(Calendar.DAY_OF_MONTH, 0);
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 59);
        cale.set(Calendar.SECOND, 59);
        cale.set(Calendar.MILLISECOND, 000);	//Mysql在插入时间时若毫秒超过了500，则会新增1s
        
        return cale.getTime();
    }
    
    public static Date getEndWeekDay2() {
        Calendar cale = null;
        // 获取本周的最后一天
        cale = Calendar.getInstance();
        cale.setFirstDayOfWeek(Calendar.MONDAY);
        cale.set(Calendar.DAY_OF_WEEK, Calendar.SUNDAY);
        cale.set(Calendar.HOUR_OF_DAY, 23);
        cale.set(Calendar.MINUTE, 59);
        cale.set(Calendar.SECOND, 59);
        cale.set(Calendar.MILLISECOND, 000);	//Mysql在插入时间时若毫秒超过了500，则会新增1s
        
        return cale.getTime();
    }
    
    public static Date getNextMonthDay() {
        Calendar c = Calendar.getInstance();
        System.out.println(c.getTime());
        c.set(Calendar.MONTH, c.get(Calendar.MONTH) + 1);
        c.set(Calendar.DAY_OF_MONTH, 1);
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        String firstday = format.format(c.getTime());
        return strToDate(firstday);
    }

    public static String getTimerRedisKey(String pre) {
        Calendar c = Calendar.getInstance();
        String year = deal(c.get(Calendar.YEAR));
        String mon = deal(c.get(Calendar.MONTH) + 1);
        String day = deal(c.get(Calendar.DATE));
        String hour = deal(c.get(Calendar.HOUR_OF_DAY));
        String min = deal(c.get(Calendar.MINUTE));
        String key = "";
        if (pre != null && !pre.equals("")) {
            key = key + pre + "_";
        }
        key = key + year + "-" + mon + "-" + day + "-" + hour + "-" + min;
        return key;
    }

    private static String deal(int time) {
        String timeStr = String.valueOf(time);
        if (timeStr.length() < 2) {
            timeStr = "0" + timeStr;
        }
        return timeStr;
    }

    /**
     * 一段时间
     */
    public static List<String> getLongTime(int day){
        SimpleDateFormat sdf = new SimpleDateFormat("yyyy-MM-dd");
        Calendar cal2 = Calendar.getInstance();

        List<String> list = new ArrayList<>();
        for( int i =0;i < day;i++ ){
            cal2.add(Calendar.DATE,i);
            Date time2 = cal2.getTime();
            list.add(sdf.format(time2));
            cal2.add(Calendar.DATE,-i);
        }
        return list;
    }

    public static int getCancelTime(String buyTime){
        Date buyDate = DateUtil.strToDateSecond(buyTime);
        Date nowTime = new Date();
        long time = nowTime.getTime() - buyDate.getTime();
        time /= 1000;
        if( time >= 180 ){
            time = 180;
        }else{
            if( time < 0 ){
                time = 0;
            }
        }
        return (int)time;
    }

    public static int getCancelTime(Date buyDate){
        Date nowTime = new Date();
        long time = nowTime.getTime() - buyDate.getTime();
        time /= 1000;
        time = 180 - time;
        if( time < 0 ){
            time = 0;
        }
        return (int)time;
    }

    /**
     * 当前月份第一天
     */
    public static String getFirstDayOfTargetMonth() {
        Calendar ca = Calendar.getInstance();
        ca.add(Calendar.MONTH, 0);
        ca.set(Calendar.DAY_OF_MONTH,1);//设置为1号,当前日期既为本月第一天
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(ca.getTime());
    }

    /**
     * 当前月份最后一天
     */
    public static String getLastDayOfTargetMonth() {
        Calendar ca = Calendar.getInstance();
        ca.set(Calendar.DAY_OF_MONTH, ca.getActualMaximum(Calendar.DAY_OF_MONTH));
        SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd");
        return format.format(ca.getTime());
    }


}
