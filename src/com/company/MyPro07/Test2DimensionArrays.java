package com.company.MyPro07;

/**
 * 测试二维数组
 * @author 黄建波
 */
public class Test2DimensionArrays {
    public static void main(String[] args) {
        int[] a = new int[3];

        //定义二维数组
        int[][] b = new int[3][];
        b[0] = new int[]{20,30};
        b[1] = new int[]{10,15,80};
        b[2] = new int[]{50,60};

        System.out.println(b[1][2]);

        //静态初始化二维数组
        int c[][] = {{20,30,40},{50,20},{100,200,300,400}};
        System.out.println(c[2][3]);
    }



}
