package com.company.MyPro03;

/**
 * 求阶乘
 * @author 黄建波
 *
 */
public class TestRecursion {

	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		System.out.printf("%d阶乘的结果为%s%n", 10, factorial(10));
		long d2 = System.currentTimeMillis();
		System.out.printf("递归费时：%s%n",d2 - d1);
		
		System.out.printf("循环方法使用后的%d阶乘的结果为%s%n", 10 , factorialLoop(10));
	}
	
	/**
	 * 求阶乘的方法
	 */
	static long factorial(int n) {
		//递归头
		if(n == 1) {
			return 1;
		}else {
			//n! = n * (n-1)
			return n * factorial(n-1);
		}
	}
	
	//循环的做法
	static long factorialLoop(int a) {
		long d3 = System.currentTimeMillis();
		long result = 1;
		while(a > 1) {
			result *= a ;
			a -- ;
		}
		long d4 = System.currentTimeMillis();
		System.out.printf("普通循环耗时：%s%n", d4 - d3);
		return result;
	}
}
