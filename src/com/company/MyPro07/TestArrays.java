package com.company.MyPro07;

import java.util.Arrays;

/**
 * 测试java.util.Arrays工具类的使用
 * @author 黄建波
 */
public class TestArrays {
    public static void main(String[] args) {
        int[] a ={100,20,35,150,80,200};
        System.out.println(Arrays.toString(a));

        Arrays.sort(a);
        System.out.println(Arrays.toString(a));

        System.out.println(Arrays.binarySearch(a,35));
        System.out.println(Arrays.binarySearch(a,30));
    }
}
