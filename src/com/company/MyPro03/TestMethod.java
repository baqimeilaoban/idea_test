package com.company.MyPro03;

/**
 * 测试方法的基本使用
 * @author 黄建波
 *
 */
public class TestMethod {

	public static void main(String[] args) {
		//通过对象调用普通方法
		TestMethod tm = new TestMethod();
		tm.printSxt();
		tm.printSxt();
		int c = tm.add(1, 2, 3) + 6;
		System.out.println(c);
	}
	
	void printSxt() {
		System.out.println("黄建波");
	}
	
	int add(int a, int c, int b) {
		int sum  = a + b + c;
		System.out.println(sum);
		return sum; //return两个作用:1.结束方法的运行。2.返回值
	}
}
