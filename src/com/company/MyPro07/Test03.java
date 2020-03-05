package com.company.MyPro07;

/**
 * 测试数组的遍历
 * @author 黄建波
 */
public class Test03 {
    public static void main(String[] args) {
        //初始化数组元素的值
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++){
            a[i] = 100 * i;
        }

        //读取元素的值
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        //foreach循环：用于读取数组元素的值，不能修改元素的值
        for (int m : a) {
            System.out.println(m);
        }
    }
}
