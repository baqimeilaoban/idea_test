package com.company.MyPro02;

/**
 * ��������ת����������
 * @author �ƽ���
 *
 */
public class TestTypeConvertError {

	public static void main(String[] args) {
		int money = 1000000000;
		int year = 20;
		//���ص�total�Ǹ�����������int�ķ�Χ
		int total = money * year;
		System.out.println("total = " + total);
		//���ص�total����Ȼ�Ǹ�����Ĭ����int����˽����תΪintֵ����תΪlong�������Ѿ����������ݶ�ʧ
		long total1 = money * year;
		System.out.println("total1 = " + total1);
		//���ص�total2��ȷ���Ƚ�һ�����ӱ��long���������ʽ����������ȫ����long����
		long total2 = money * ((long)year);
		System.out.println("total2 = " + total2);
		
		//��������
		//�ֲ�����L��1
		int l = 2;
		//����ʹ�ô�дL
		long a = 2345L;
		System.out.println(l + 1);
	}
}
