package com.company.MyPro02;

/**
 * 变量分类
 * @author 黄建波
 *
 */
public class TestVariable {

	/**
	 * 成员变量，从属于对象，成员变量会自动被初始化
	 */
	int a;

	/**
	 * 静态变量，从属于类
	 */
	static int size;
	public static void main(String[] args) {
		{
			//局部变量，从属于语句块
			int year;
			year = 10;
		}
		//局部变量，从属于方法
		int age;
		age = 18;
		int salary = 3000;
		
		int gao = 13;
		System.out.println(gao);
	}
}
