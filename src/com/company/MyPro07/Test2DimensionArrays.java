package com.company.MyPro07;

/**
 * ���Զ�ά����
 * @author �ƽ���
 */
public class Test2DimensionArrays {
    public static void main(String[] args) {
        int[] a = new int[3];

        //�����ά����
        int[][] b = new int[3][];
        b[0] = new int[]{20,30};
        b[1] = new int[]{10,15,80};
        b[2] = new int[]{50,60};

        System.out.println(b[1][2]);

        //��̬��ʼ����ά����
        int c[][] = {{20,30,40},{50,20},{100,200,300,400}};
        System.out.println(c[2][3]);
    }



}
