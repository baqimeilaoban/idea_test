package com.company.MyPro02;

/**
 * ���Ի�����������
 * @author �ƽ���
 *
 */
public class TestPrimitiveData {
	public static void main(String[] args) {
		//�������ͱ���
		int a = 15;
		//��0��ͷ�ǰ˽���
		int b = 015;
		//��0x��ͷ��16����
		int c = 0x15;
		//��0b��ͷ�Ƕ�����
		int d = 0b1101;
		
		System.out.println("a = " + a);
		System.out.println("b = " + b);
		System.out.println("c = " + c);
		System.out.println("d = " + d);
		
		byte age = 30;
		short salary = 30000;
		int population = 2000000000;
		long golalPopulation = 7400000000L;
	}
}
