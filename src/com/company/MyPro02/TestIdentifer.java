package com.company.MyPro02;

/**
 * 测试标识符的用法
 * @author 黄建波
 *
 */
public class TestIdentifer {
	public static void main(String[] args) {
		int a123 = 1;
		//数字不能作为开头
		int a = 1;
		int $a = 1;
		int _a = 1;
		//汉字可以使用，但不建议使用，关键字不能作为标识符
		int 年龄 = 18;
	}
}
