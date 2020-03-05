package com.company.MyPro02;

import java.util.Scanner;
/**
 * 测试键盘输入
 * @author 黄建波
 *
 */
public class TestScanner {

	public static void main(String[] args) {
		@SuppressWarnings("resource")
		Scanner scanner = new Scanner(System.in);
		System.out.println("请输入名字：");
		String name = scanner.nextLine();
		System.out.println("请输入你的爱好：");
		String favor = scanner.nextLine();
		System.out.println("请输入你的年龄：");
		int age = scanner.nextInt();
		
		System.out.println("###############");
		System.out.println(name);
		System.out.println(favor);
		System.out.println("来到地球天数" + age * 365);
		
	}
}
