package com.springboot.utils;

import javax.print.SimpleDoc;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.logging.Logger;

/**
 * @Title: TimeConvertUtil
 * @Description: 时间工具类
 * @Author: jiangwg
 * @CreateDate: 2020/9/25 14:56
 * @Version: 1.0
 */
public class TimeUtil {
    public static final String TIME_FORMAT_ONE =  "yyyy-MM-dd HH:mm:ss";
    public static final String TIME_FORMAT_TWO =  "yyyy-MM-dd";
    public static final String TIME_FORMAT_Three =  "HH:mm:ss";
    public static Calendar calendar = Calendar.getInstance();
    /**
     * @Author jiangwg
     * @Description 将时间String转化为Date
     * @Date 15:11 2020/9/25
     * @Param
     * @param dateString 需要转换的时间
     * @param type type=1 yyyy-MM-dd  HH:mm:ss    type=2 yyyy-MM-dd   type=3 HH:mm:ss
     * @return java.util.Date
     **/
    public static Date formatDate(String dateString,int type) {
        if(UtilValidator.isEmpty(dateString)){
            return null;
        }
        Date date = new Date();
        SimpleDateFormat  sdf = null;
        try{
            switch (type){
                case 1:
                    sdf = new SimpleDateFormat(TIME_FORMAT_ONE);
                    date = sdf.parse(dateString);
                    break;
                case 2:
                    sdf = new SimpleDateFormat(TIME_FORMAT_TWO);
                    date = sdf.parse(dateString);
                    break;
                case 3:
                    sdf = new SimpleDateFormat(TIME_FORMAT_Three);
                    date = sdf.parse(dateString);
                    break;
                default:
                    date = null;
            }
        } catch (ParseException e) {
            e.printStackTrace();
            return null;
        }
        return  date;
    }
    /**
     * @Author jiangwg
     * @Description 计算两个时间的差值
     * @Date 15:51 2020/9/25
     * @Param
     * @param start
     * @param end
     * @param type  1： 返回毫秒数    2：返回秒数    3：返回分钟数   4：返回小时数     5：返回天数
     * @return long
     **/
    public static Long calculateTime(Date start, Date end, int type) {
        if(UtilValidator.isEmpty(start) || UtilValidator.isEmpty(end)){
            return  null;
        }
        long dif= end.getTime() - start.getTime();
        switch (type){
            case 1:
                return dif;
            case 2:
                return dif / 1000;
            case 3:
                return dif / 1000 / 60;
            case 4:
                return dif / 1000 / 60 / 60;
            case 5:
                return dif / 1000 / 60 / 60 / 24;
            default:
                return null;
        }
    }
    /**
     * @Author jiangwg
     * @Description  获取当前时间
     * @Date 10:37 2020/9/27
     * @Param
     * @return java.util.Date
     **/
    public static Date getCurrentTime(){
        return calendar.getTime();
    }
    /**
     * @Author jiangwg
     * @Description 获取Calendar实例
     * @Date 10:38 2020/9/27
     * @Param
     * @return java.util.Calendar
     **/
    public static Calendar calendar(){
        return calendar;
    }
}
