package com.company.MyPro07;

/**
 * 测试数组的初始化
 * @author 黄建波
 */
public class Test02 {
    public static void main(String[] args) {
        //静态初始化
        int[] a = {1,2,3};
        User[] b = {new User(1001,"黄"),new User(1002,"红"),new User(1003,"蓝")};

        //默认初始化
        //默认给数组的元素进行赋值，赋值的规则和成员变量默认赋值规则一致
        int[] c = new int[3];
    }
}
