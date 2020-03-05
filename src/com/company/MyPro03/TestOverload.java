package com.company.MyPro03;

/**
 * 测试方法重载
 * @author 黄建波
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
	 * 求和的方法
	 */
	public static int add(int n1, int n2) {
		int sum = n1 + n2;
		return sum;
	}

	/**
	 * 方法名相同，参数个数不同，构成重载
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
	 * 方法名相同，参数类型不同，构成重载
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static double add(double n1, int n2) {
		double sum  = n1 + n2;
		return sum;
	}

	/**
	 * 方法名相同，参数顺序不同，构成重载
	 * @param n1
	 * @param n2
	 * @return
	 */
	public static double add(int n1, double n2) {
		return n1 + n2;
	}
}
