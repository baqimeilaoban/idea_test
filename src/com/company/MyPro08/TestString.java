package com.company.MyPro08;

/**
 * ����String
 * @author �ƽ���
 */
public class TestString {
    public static void main(String[] args) {
        //ǰ�����final���Σ����ܱ��ı䣬����ı䣬�������¸�ֵ
        String str = "aaabbb";

        String str2 = str.substring(2,5);
        System.out.println(str);
        System.out.println(str2);

        //�����������Ż�ֱ���ڱ����ʱ���ַ���������ƴ��
        String str3 = "hello" + " java";
        String str4 = "hello java";
        //true
        System.out.println(str3 == str4);
        String str5 = "hello";
        String str6 = "java";
        //�����ʱ��֪�������д洢����ʲô����û�취�ڱ����ʱ���Ż�
        String str7 = str3 + str4;
        //false
        System.out.println(str3 == str7);


        //���ַ����Ƚ�ʱ��ʹ��equals��������Ҫʹ��==
        System.out.println(str3.equals(str7));
    }
}
