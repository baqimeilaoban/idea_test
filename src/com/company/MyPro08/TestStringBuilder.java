package com.company.MyPro08;

/**
 * ����StringBuilder��StringBuffer
 * @author �ƽ���
 */
public class TestStringBuilder {
    public static void main(String[] args) {
        //StringBuilder�̲߳���ȫ��Ч�ʸߣ�һ��ʹ�ã���StringBuffer�̰߳�ȫ��Ч�ʵ�
        StringBuilder sb = new StringBuilder("abcdefg");

        //��ӡ��ַ
        System.out.println(Integer.toHexString(sb.hashCode()));
        //��ӡ����
        System.out.println(sb);

        sb.setCharAt(2,'M');
        //��ַһ����˵����ͬһ������
        System.out.println(Integer.toHexString(sb.hashCode()));
        System.out.println(sb);

    }
}
