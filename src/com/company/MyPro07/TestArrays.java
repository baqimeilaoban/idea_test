package com.company.MyPro07;

import java.util.Arrays;

/**
 * ����java.util.Arrays�������ʹ��
 * @author �ƽ���
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
