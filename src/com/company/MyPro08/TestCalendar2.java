package com.company.MyPro08;

import java.text.DateFormat;
import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.Calendar;
import java.util.Date;
import java.util.GregorianCalendar;

/**
 * ���ӻ��������򣨵�һ���汾��
 * @author �ƽ���
 */
public class TestCalendar2 {
    public static void main(String[] args) throws ParseException {
        String str = "2020-10-10";

        DateFormat df = new SimpleDateFormat("yyyy-MM-dd");

        Date date = df.parse(str);
        Calendar c = new GregorianCalendar();
        //������������ַ���תΪ��������
        c.setTime(date);

        System.out.println("��\tһ\t��\t��\t��\t��\t��");
        //����ǰ������Ϊ1
        c.set(Calendar.DAY_OF_MONTH,1);

        for (int i = 0; i < c.get(Calendar.DAY_OF_WEEK) - 1; i++ ){
            System.out.print("\t");
        }
        int days = c.getActualMaximum(Calendar.DATE);
        for (int i = 1; i<= days; i++){
            System.out.print(c.get(Calendar.DAY_OF_MONTH) + "\t");
            if (c.get(Calendar.DAY_OF_WEEK) == Calendar.SATURDAY){
                //���в���
                System.out.println();
            }
            c.add(Calendar.DAY_OF_MONTH,1);
        }
    }
}
