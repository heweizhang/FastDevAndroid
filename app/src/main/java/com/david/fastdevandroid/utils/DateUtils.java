package com.david.fastdevandroid.utils;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * Created by Administrator on 2016/8/19.
 */
public class DateUtils {

    private static SimpleDateFormat sf;

    /**
     * 获取系统时间 格式为："yyyy/MM/dd "
     **/
    public static String getCurrentDate() {
        Date d = new Date();
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        return sf.format(d);
    }

    /**
     * 获取当前系统时间戳
     *
     * @return
     */
    public static long getCurrentTime() {
        long d = new Date().getTime() / 1000;
        return d;
    }

    /**
     * 时间戳转换成字符窜
     */
    public static String getDateToString(long time) {
        Date d = new Date(time * 1000);
        sf = new SimpleDateFormat("yyyy年MM月dd日HH时mm分");//小写hh会导致下午5点直接显示05 而不是17
        return sf.format(d);
    }

    /**
     * 时间戳转换成字符窜
     */
    public static String getDateToStringData(long time) {
        Date d = new Date(time * 1000);
        sf = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");//小写hh会导致下午5点直接显示05 而不是17

        return sf.format(d);
    }
    /**
     * 将字符串转为时间戳
     */
    public static long getStringToDate(String time) {
        sf = new SimpleDateFormat("yyyy年MM月dd日");
        Date date = new Date();
        try {
            date = sf.parse(time);
        } catch (ParseException e) {
            // TODO Auto-generated catch block
            e.printStackTrace();
        }
        return date.getTime();
    }
}
