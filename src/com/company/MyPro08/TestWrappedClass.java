package com.company.MyPro08;

/**
 * ���԰�װ��
 * @author �ƽ���
 */
public class TestWrappedClass {
    public static void main(String[] args) {
        //������������ת��Ϊ��װ�����
        Integer a = new Integer(3);
        Integer b = Integer.valueOf(30);

        //�Ѱ�װ�����ת�ɻ�����������
        int c = b.intValue();
        double d = b.doubleValue();

        //���ַ���ת�ɰ�װ�����
        Integer e = new Integer("999");
        Integer f = Integer.parseInt("9999");

        //�Ѱ�װ�����ת���ַ���
        String str = f.toString();

        //�����ĳ���
        System.out.println("int��������������" + Integer.MAX_VALUE);


    }
}
