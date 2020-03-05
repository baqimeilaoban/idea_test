package com.company.MyPro02;

/**
 * 测试基本数据类型
 * @author 黄建波
 *
 */
public class TestPrimitiveData {
	public static void main(String[] args) {
		//测试整型变量
		int a = 15;
		//以0开头是八进制
		int b = 015;
		//以0x开头是16进制
		int c = 0x15;
		//以0b开头是二进制
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
