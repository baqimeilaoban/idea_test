package com.company.MyPro02;

/**
 * ���Գ���
 * @author �ƽ���
 *
 */
public class TestConstant {
	public static void main(String[] args) {
		int age = 18;
		age = 20;
		//����
		final String name = "huangjianbo";

		final double PI = 3.14;
		double r = 4;
		double area = PI * r * r;
		double circle = 2 * PI * r;
		System.out.println("���Ϊ��" + area);
		System.out.println("�ܳ�Ϊ��" + circle);
	}
}
