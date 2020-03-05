package com.company.MyPro08;

import java.util.Random;

/**
 * ����Math��
 * @author �ƽ���
 */
public class TestMath {
    public static void main(String[] args) {
        //ȡ����ز���
        System.out.println(Math.ceil(3.1));
        System.out.println(Math.floor(3.2));
        System.out.println(Math.round(3.2));
        System.out.println(Math.round(3.8));

        //����ֵ��������a��b���ݵȲ���
        System.out.println(Math.abs(-45));
        System.out.println(Math.sqrt(64));
        System.out.println(Math.pow(5,2));
        System.out.println(Math.pow(2,5));

        //Math���г��õı���
        System.out.println(Math.PI);
        System.out.println(Math.E);
        //�����[0,1]
        System.out.println(Math.random());

        Random random = new Random();
        //����[0,1]֮���double���͵�����
        System.out.println(random.nextDouble());
        //�������int��������Χ֮�����������
        System.out.println(random.nextInt());
        //�������[0,1]֮���float���͵�����
        System.out.println(random.nextFloat());
        //�������false����true
        System.out.println(random.nextBoolean());
        //�������[0,10]֮���int���͵�����
        System.out.println(random.nextInt(10));
        //�������[20,30]֮���int���͵�����
        System.out.println(20 + random.nextInt(10));
        //�������[20,30]֮���int���͵����ݣ����ַ��������Ϊ���ӣ�
        System.out.println(20 + (int)(random.nextDouble() * 10));
    }
}
