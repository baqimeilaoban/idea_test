package com.company.MyPro08;

/**
 * �����Զ�װ�䣬�Զ�����
 * @author �ƽ���
 */
public class TestAutoBox {
    public static void main(String[] args) {
        //�Զ�װ�䣬��仰�൱��Integer a = Integer.valueOf(234);
        Integer a = 234;
        //�Զ����䣬��仰�൱��int b = a.intValue();
        int b = a;

        Integer c = null;
        if(c != null){
            //�Զ����䣬�����ˣ�c.intValue();
            int d = c;
        }

        //����[-128,127]֮������֣�ʵ���Ͼ���ϵͳ��ʼ��ʱ�򣬴�����[-128,127]֮��Ļ�������
        //�����ǵ���ValueOf()��ʱ�����ȼ���Ƿ���[-128,127]֮�䣬����������Χ��ֱ�Ӵӻ����������ó��Ѿ����õĶ���
        //������������Χ���򴴽��µ�Integer����
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        //true����Ϊ-128�ڻ��淶Χ��
        System.out.println(in1 == in2);
        //true
        System.out.println(in1.equals(in2));
        Integer in3 = 1234;
        Integer in4 = 1234;
        //false����Ϊ1234���ڻ��淶Χ��
        System.out.println(in3 == in4);
        //true
        System.out.println(in3.equals(in4));
    }
}
