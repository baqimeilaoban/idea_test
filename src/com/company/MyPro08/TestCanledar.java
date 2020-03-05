package com.company.MyPro08;

import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * �����������ʹ��
 * @author �ƽ���
 */
public class TestCanledar {
    public static void main(String[] args) {
        //������ڵ����Ԫ��
        Calendar calendar = new GregorianCalendar(2999,10,9,22,10,50);
        int year = calendar.get(Calendar.YEAR);
        //0-11��ʾ��Ӧ���·ݣ�0��1�£�1��2�£�....��11��12��
        int month = calendar.get(Calendar.MONTH);
        //���ڼ���1-7��1�������գ�2������һ��....��7��������
        int weekday = calendar.get(Calendar.DAY_OF_WEEK);
        //����ʹ��DATE��Ҳ����ʹ��DAY_OF_MONTH
        int day = calendar.get(Calendar.DATE);
        System.out.println(year);
        System.out.println(month);
        System.out.println(weekday);
        System.out.println(day);
        System.out.println(calendar);


        //�������ڵ����Ԫ��
        Calendar c2 = new GregorianCalendar();
        c2.set(Calendar.YEAR,8012);
        System.out.println(c2);

        //���ڵļ���
        Calendar c3 = new GregorianCalendar();
        c3.add(Calendar.DAY_OF_MONTH,100);
        System.out.println(c3);

        //���ڶ����ʱ������ת��
        Date d4 = c3.getTime();
        Calendar c4 = new GregorianCalendar();
        c4.setTime(new Date());

        printCalendar(c4);
    }

    public static void printCalendar(Calendar c){
        //��ӡ��1918��10��10�� 11��23��45 ����
        int year = c.get(Calendar.YEAR);
        int month = c.get(Calendar.MONTH) + 1;
        int date = c.get(Calendar.DAY_OF_MONTH);
        //1-7:1������2����һ
        int dayweek = c.get(Calendar.DAY_OF_WEEK) - 1;
        String dayweek2 = dayweek == 0 ? "��" : dayweek + "";

        int hour = c.get(Calendar.HOUR);
        int minute = c.get(Calendar.MINUTE);
        int second = c.get(Calendar.SECOND);

        System.out.println(year + "��" + month + "��" + date + "��" +
                "    " + hour + "ʱ" + minute + "��" + second + "��" +
                "    " + "��" + dayweek2);
    }
}
