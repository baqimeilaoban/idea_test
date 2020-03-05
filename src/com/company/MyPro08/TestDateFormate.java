package com.company.MyPro08;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * ����ʱ�������ַ���֮���ת��
 * DateFormate�������SimpleDateFormateʵ�����ʹ��
 * @author �ƽ���
 */
public class TestDateFormate {
    public static void main(String[] args) throws ParseException {
        DateFormat df = new SimpleDateFormat("yyyy-MM-dd hh:mm:ss");

        //��ʱ������� ����ʽ�ַ���ָ���ĸ�ʽ�� ת����Ӧ���ַ���
        String str = df.format(new Date(4000000));
        System.out.println(str);

        //���ַ������� ����ʽ�ַ���ָ���ĸ�ʽ�� ת����Ӧ��ʱ���Ӧ
        DateFormat df2 = new SimpleDateFormat("yyyy��MM��dd�� hhʱmm��ss��");
        Date date = df2.parse("1983��5��10�� 10ʱ45��59��");
        System.out.println(date);

        //���������ĸ�ʽ�ַ�
        //��������
        DateFormat df3 = new SimpleDateFormat("D");
        String str3 = df3.format(new Date());
        System.out.println(str3);
        //��������
        DateFormat df4 = new SimpleDateFormat("w");
        String str4 = df4.format(new Date());
        System.out.println(str4);

    }
}
