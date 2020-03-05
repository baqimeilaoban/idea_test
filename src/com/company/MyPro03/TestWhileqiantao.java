package com.company.MyPro03;

/**
 * 测试嵌套循环
 * @author 黄建波
 *
 */
public class TestWhileqiantao {

	public static void main(String[] args) {
		for (int i = 0; i <= 5; i++) {
			for (int j = 0; j <= 5; j++) {
				System.out.print(j + "\t");
			}
			System.out.println();
		}
		
		System.out.println("***************************");
		for (int i = 1; i <= 9; i++) {
			for (int j = 1; j <= i; j++) {
				System.out.print(j + "*" + i + " = " + (i * j < 10 ? (" " + i * j) : i * j) + "\t");
			}
			System.out.println();
		}
		System.out.println("**************************");
		//用while分别计算100以内奇数及偶数的和，并输出
		int sum01 = 0;
		int sum02 = 0;
		for (int i = 1; i <= 100; i++) {
			//偶数
			if (i % 2 == 0) {
				sum01 = sum01 + i;
			}else { //奇数
				sum02 = sum02 + i;
			}
		}
		System.out.println("奇数和为：" + sum02);
		System.out.println("偶数和为：" + sum01);
		
		//用while循环或其他循环输出1-1000能被5整除的数，5个一组
		System.out.println("*************************");
		int a = 0;
		for (int i = 1; i <= 1000; i++) {
			if (i % 5 == 0) {
				System.out.print(i + "\t");
				a ++;
				if (a % 5 == 0) {
					System.out.println();
					a = 0;
				}
			}
		}
	}
}
