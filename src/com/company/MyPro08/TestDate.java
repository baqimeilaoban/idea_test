package com.company.MyPro08;

import java.util.Date;

/**
 * 创建Date类的常见用法
 * @author 黄建波
 */
public class TestDate {
    public static void main(String[] args) {
        Date d = new Date(2000);
        System.out.println(d);

        System.out.println(d.getTime());
        Date d2 = new Date();
        System.out.println(d2.getTime());
        System.out.println(d2.after(d));
        //表示2020年4月10日
        //以后遇到日期处理，使用Canlendar日期类
        Date d3 = new Date(2020-1900,3,10);
        System.out.println(d3);



    }
}
