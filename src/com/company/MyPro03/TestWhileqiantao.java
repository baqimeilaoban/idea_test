package com.company.MyPro03;

/**
 * ����Ƕ��ѭ��
 * @author �ƽ���
 *
 */
public class TestWhileqiantao {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		
		System.out.println("***************************");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + " = " + (i * j < 10 ? (" " + i * j) : i * j) + "\t");
			}
			System.out.println();
		}
		System.out.println("**************************");
		//��while�ֱ����100����������ż���ĺͣ������
		int sum01 = 0;
		int sum02 = 0;
		for (int i = 1; i <= 100; i++) {
			//ż��
			if (i % 2 == 0) {
				sum01 = sum01 + i;
			}else { //����
				sum02 = sum02 + i;
			}
		}
		System.out.println("������Ϊ��" + sum02);
		System.out.println("ż����Ϊ��" + sum01);
		
		//��whileѭ��������ѭ�����1-1000�ܱ�5����������5��һ��
		System.out.println("*************************");
		int a = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 5 == 0) {
				System.out.print(i + "\t");
				a ++;
				if (a % 5 == 0) {
					System.out.println();
					a = 0;
				}
			}
		}
	}
}
