package com.company.MyPro03;

/**
 * ����forѭ��
 * @author �ƽ���
 *
 */
public class TestFor {

	public static void main(String[] args) {
		int sum = 0;
		for (int i = 0; i <= 100; i++) {
			sum = sum + i;
		}
		System.out.println("sum = " + sum);
		
		/**
		 * 1.ִ�г�ʼ����䣺i = 1;
		 * 2.�ж�i<100
		 * 3.ִ��ѭ����
		 * 4.����������i++
		 * 5.�ص��ڶ��������ж�
		 */
		
		//���������
		for (int i = 1 , j = i + 10; i < 5; i++ , j = i * 2) {
			System.out.println("i = " + i + " j = " + j);
		}
	}
}
