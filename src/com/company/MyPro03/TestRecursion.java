package com.company.MyPro03;

/**
 * ��׳�
 * @author �ƽ���
 *
 */
public class TestRecursion {

	public static void main(String[] args) {
		long d1 = System.currentTimeMillis();
		System.out.printf("%d�׳˵Ľ��Ϊ%s%n", 10, factorial(10));
		long d2 = System.currentTimeMillis();
		System.out.printf("�ݹ��ʱ��%s%n",d2 - d1);
		
		System.out.printf("ѭ������ʹ�ú��%d�׳˵Ľ��Ϊ%s%n", 10 , factorialLoop(10));
	}
	
	/**
	 * ��׳˵ķ���
	 */
	static long factorial(int n) {
		//�ݹ�ͷ
		if(n == 1) {
			return 1;
		}else {
			//n! = n * (n-1)
			return n * factorial(n-1);
		}
	}
	
	//ѭ��������
	static long factorialLoop(int a) {
		long d3 = System.currentTimeMillis();
		long result = 1;
		while(a > 1) {
			result *= a ;
			a -- ;
		}
		long d4 = System.currentTimeMillis();
		System.out.printf("��ͨѭ����ʱ��%s%n", d4 - d3);
		return result;
	}
}
