package com.company.MyPro03;

/**
 * ���Է����Ļ���ʹ��
 * @author �ƽ���
 *
 */
public class TestMethod {

	public static void main(String[] args) {
		//ͨ�����������ͨ����
		TestMethod tm = new TestMethod();
		tm.printSxt();
		tm.printSxt();
		int c = tm.add(1, 2, 3) + 6;
		System.out.println(c);
	}
	
	void printSxt() {
		System.out.println("�ƽ���");
	}
	
	int add(int a, int c, int b) {
		int sum  = a + b + c;
		System.out.println(sum);
		return sum; //return��������:1.�������������С�2.����ֵ
	}
}
