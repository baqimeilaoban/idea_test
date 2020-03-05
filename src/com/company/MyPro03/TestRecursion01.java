package com.company.MyPro03;

/**
 * ≤‚ ‘µ›πÈ
 * @author ª∆Ω®≤®
 *
 */
public class TestRecursion01 {

	public static void main(String[] args) {
		a();
	}
	
	static int count = 0;
	static void a() {
		count++;
		System.out.println("a");
		if (count < 10) {
			a();
		}else {
			return;
		}
	}
	
	static void b() {
		System.out.println("b");
	}
}
