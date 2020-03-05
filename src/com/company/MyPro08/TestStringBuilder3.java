package com.company.MyPro08;

/**
 * ���Կɱ��ַ����кͲ��ɱ��ַ����е�ʹ������
 * @author �ƽ���
 */
public class TestStringBuilder3 {
    public static void main(String[] args) {
        /**
         * ʹ��String�����ַ�����ƴ��
         */
        String str = "";
        //������ʹ��StringBuilderƴ�ӣ�����ÿ��ѭ����������StringBuilder����
        //��ȡϵͳʣ��ռ�
        long num1 = Runtime.getRuntime().freeMemory();
        //��ȡϵͳ��ǰʱ��
        long time1 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++){
            //�൱�ڲ���10000������
            str = str + i;
        }
        long num2 = Runtime.getRuntime().freeMemory();
        long time2 = System.currentTimeMillis();
        System.out.println("Stringռ���ڴ棺" + (num1 - num2));
        System.out.println("Stringռ��ʱ�䣺" + (time2 - time1));

        /**
         * ʹ��StringBuilder�����ַ�����ƴ��
         */
        StringBuilder sb1 = new StringBuilder("");
        long num3 = Runtime.getRuntime().freeMemory();
        long time3 = System.currentTimeMillis();
        for (int i = 0; i < 5000; i++){
            sb1.append(i);
        }
        long num4 = Runtime.getRuntime().freeMemory();
        long time4 = System.currentTimeMillis();
        System.out.println("StringBuilderռ���ڴ棺" + (num3 - num4));
        System.out.println("StringBuilderռ��ʱ�䣺" + (time4 - time3));
    }
}
