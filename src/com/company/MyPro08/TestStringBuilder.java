package com.company.MyPro08;

/**
 * 测试StringBuilder，StringBuffer
 * @author 黄建波
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        //StringBuilder线程不安全，效率高（一般使用）；StringBuffer线程安全，效率低
        StringBuilder sb = new StringBuilder("abcdefg");

        //打印地址
        System.out.println(Integer.toHexString(sb.hashCode()));
        //打印内容
        System.out.println(sb);

        sb.setCharAt(2,'M');
        //地址一样，说明是同一个对象
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

    }
}
