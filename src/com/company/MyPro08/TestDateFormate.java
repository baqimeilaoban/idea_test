package com.company.MyPro08;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * 测试时间对象和字符串之间的转换
 * DateFormate抽象类和SimpleDateFormate实现类的使用
 * @author 黄建波
 */
public class TestDateFormate {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //把时间对象按照 “格式字符串指定的格式” 转成相应的字符串
        String str = df.format(new Date(4000000));
        System.out.println(str);

        //把字符串按照 “格式字符串指定的格式” 转成相应的时间对应
        DateFormat df2 = new SimpleDateFormat("yyyy年MM月dd日 hh时mm分ss秒");
        Date date = df2.parse("1983年5月10日 10时45分59秒");
        System.out.println(date);

        //测试其他的格式字符
        //测试天数
        DateFormat df3 = new SimpleDateFormat("D");
        String str3 = df3.format(new Date());
        System.out.println(str3);
        //测试周数
        DateFormat df4 = new SimpleDateFormat("w");
        String str4 = df4.format(new Date());
        System.out.println(str4);

    }
}
