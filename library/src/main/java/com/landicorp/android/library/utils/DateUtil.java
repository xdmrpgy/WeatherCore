package com.landicorp.android.library.utils;

import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;

/**
 * Created by panguangyi on 2017-05-25.
 */

public class DateUtil {
    /**
     * 获取当前日期字符串
     * */
    public static String getCurrentDate() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
        return df.format(new Date());
    }

    /**
     * 获取当前日期字符串
     */
    public static String getCurrentDateString() {
        SimpleDateFormat df = new SimpleDateFormat("yyyy年MM月dd日");
        return df.format(new Date());
    }

    /**
     * 获取当前年
     * @return
     */
    public static int getCurrentYear() {
        Calendar cal=Calendar.getInstance();
        return cal.get(Calendar.YEAR);
    }

    /**
     * 获取当前月
     * @return
     */
    public static int getCurrentMonth() {
        Calendar cal= Calendar.getInstance();
        return cal.get(Calendar.MONTH);
    }

    /**
     * 获取当前日
     * @return
     */
    public static int getCurrentDay() {
        Calendar cal=Calendar.getInstance();
        return cal.get(Calendar.DATE);
    }
}
