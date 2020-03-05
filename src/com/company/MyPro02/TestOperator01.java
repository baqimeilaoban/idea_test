package com.company.MyPro02;

/**
 * 测试算术运算符
 * @author 黄建波
 *
 */
public class TestOperator01 {

	public static void main(String[] args) {
/*		
		byte a = 1;
		int b = 2;
		long b2 = 3;
	//	byte c = a + b; //报错
	//	int c2 = b2 + b; //保错
		float f1  = 3.14f;
		float d = b + b2;
		
	//	float d2 = f1 + 6.2; //报错
		
		System.out.println(-9%5); //余数符号和左边操作时相同
*/		
		
		/*
		int a = 3;
		int b = a++; //执行完b=3；先给b赋值，再自增
		System.out.println("a = " + a + "\nb = " + b);
		a = 3;
		int c = ++a; //执行完c=4；a先自增，再赋值给c
		System.out.println("a = " + a + "\nc = " + c);
		*/
		
		int a = 3;
		int b = 4;
		a += b; //相当于a = a + b
		System.out.println("a=" + a + "\nb=" + b);
		a = 3;
		a*=b+3; //相当于a=a*(b+3)
		System.out.println("a=" + a + "\nb=" + b);
		
		
		
		
	}
}
