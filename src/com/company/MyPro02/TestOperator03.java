package com.company.MyPro02;

/**
 * ����λ����
 * @author �ƽ���
 *
 */
public class TestOperator03 {

	public static void main(String[] args) {
		int a = 3;
		int b = 4;
		System.out.println(a&b);
		System.out.println(a|b);
		System.out.println(a^b);
		System.out.println(~a);
		
		//��λ����
		int c = 3 << 2; //����һλ�൱�ڳ���2
		System.out.println(c);
		int d = 12 >> 2; //����һλ�൱�ڳ���2
		System.out.println(d);
	}
}
