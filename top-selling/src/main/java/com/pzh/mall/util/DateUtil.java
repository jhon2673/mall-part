package com.pzh.mall.util;

import java.text.SimpleDateFormat;
import java.util.Calendar;

/**
 * @Description TODO
 * @Author panzhh
 * @Date 2021/3/18 13:26
 * @Version 1.0
 */
public class DateUtil {

    /**
     * 获取日期
     * @param days 负数表示几天前，正数表示几天后
     * @param formatter 日期格式
     * @return
     */
    public static String getDate(int days, SimpleDateFormat formatter) {
        Calendar calendar = Calendar.getInstance();
        calendar.add(Calendar.DATE, days);
        String date = formatter.format(calendar.getTime());
        return date;
    }

    public static void main(String[] args) {
        SimpleDateFormat formatter = new SimpleDateFormat("yyyy-MM-dd");
        String date = getDate(-1, formatter);
        System.out.println("yyyy-MM-dd格式日期是：" + date);

        SimpleDateFormat formatter2 = new SimpleDateFormat("yyyyMMdd");
        String date2 = getDate(-1, formatter2);
        System.out.println("yyyyMMdd格式日期是：" + date2);
    }
}
