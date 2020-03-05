package com.company.MyPro02;

/**
 * 测试常量
 * @author 黄建波
 *
 */
public class TestConstant {
	public static void main(String[] args) {
		int age = 18;
		age = 20;
		//常量
		final String name = "huangjianbo";

		final double PI = 3.14;
		double r = 4;
		double area = PI * r * r;
		double circle = 2 * PI * r;
		System.out.println("面积为：" + area);
		System.out.println("周长为：" + circle);
	}
}
