package com.company.MyPro07;

/**
 * ��������ı���
 * @author �ƽ���
 */
public class Test03 {
    public static void main(String[] args) {
        //��ʼ������Ԫ�ص�ֵ
        int[] a = new int[4];
        for (int i = 0; i < a.length; i++){
            a[i] = 100 * i;
        }

        //��ȡԪ�ص�ֵ
        for (int i = 0; i < a.length; i++){
            System.out.println(a[i]);
        }

        //foreachѭ�������ڶ�ȡ����Ԫ�ص�ֵ�������޸�Ԫ�ص�ֵ
        for (int m : a) {
            System.out.println(m);
        }
    }
}
