package com.company.MyPro02;

/**
 * 测试位运算
 * @author 黄建波
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
		
		//移位运算
		int c = 3 << 2; //左移一位相当于乘以2
		System.out.println(c);
		int d = 12 >> 2; //右移一位相当于除以2
		System.out.println(d);
	}
}
