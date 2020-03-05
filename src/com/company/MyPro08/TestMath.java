package com.company.MyPro08;

import java.util.Random;

/**
 * 测试Math类
 * @author 黄建波
 */
public class TestMath {
    public static void main(String[] args) {
        //取整相关操作
        System.out.println(Math.ceil(3.1));
        System.out.println(Math.floor(3.2));
        System.out.println(Math.round(3.2));
        System.out.println(Math.round(3.8));

        //绝对值、开方、a的b次幂等操作
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5,2));
        System.out.println(Math.pow(2,5));

        //Math类中常用的变量
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //随机数[0,1]
        System.out.println(Math.random());

        Random random = new Random();
        //生成[0,1]之间的double类型的数据
        System.out.println(random.nextDouble());
        //随机生成int类型允许范围之类的整型数据
        System.out.println(random.nextInt());
        //随机生成[0,1]之间的float类型的数据
        System.out.println(random.nextFloat());
        //随机生成false或者true
        System.out.println(random.nextBoolean());
        //随机生成[0,10]之间的int类型的数据
        System.out.println(random.nextInt(10));
        //随机生成[20,30]之间的int类型的数据
        System.out.println(20 + random.nextInt(10));
        //随机生成[20,30]之间的int类型的数据（此种方法计算较为复杂）
        System.out.println(20 + (int)(random.nextDouble() * 10));
    }
}
