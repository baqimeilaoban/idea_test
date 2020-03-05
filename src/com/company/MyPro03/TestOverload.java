package com.company.MyPro03;

/**
 * ���Է�������
 * @author �ƽ���
 *
 */
public class TestOverload {

	public static void main(String[] args) {
		System.out.println(add(2, 3));
		System.out.println(add(3, 5, 10));
		System.out.println(add(3.0, 2));
		System.out.println(add(3, 5.0));
	}
	
	/**
	 * ��͵ķ���
	 */
	public static int add(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}

	/**
	 * ��������ͬ������������ͬ����������
	 * @param n1
	 * @param n2
	 * @param n3
	 * @return
	 */
	public static int add(int n1, int n2, int n3) {
		int sum = n1 + n2 + n3;
		return sum;
	}

	/**
	 * ��������ͬ���������Ͳ�ͬ����������
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static double add(double n1, int n2) {
		double sum  = n1 + n2;
		return sum;
	}

	/**
	 * ��������ͬ������˳��ͬ����������
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static double add(int n1, double n2) {
		return n1 + n2;
	}
}
