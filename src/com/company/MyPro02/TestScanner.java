package com.company.MyPro02;

import java.util.Scanner;
/**
 * ���Լ�������
 * @author �ƽ���
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("���������֣�");
		String name = scanner.nextLine();
		System.out.println("��������İ��ã�");
		String favor = scanner.nextLine();
		System.out.println("������������䣺");
		int age = scanner.nextInt();
		
		System.out.println("###############");
		System.out.println(name);
		System.out.println(favor);
		System.out.println("������������" + age * 365);
		
	}
}
