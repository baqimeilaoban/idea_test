package com.company.MyPro03;

/**
 * ����Whileѭ��
 * @author �ƽ���
 *
 */
public class TestWhile {

	public static void main(String[] args) {
		//����1+2+3+4+......+100���ۼӺͣ�5050
		int i = 1;
		int sum = 0;
		while (i <= 100) {
			sum = sum + i;
			i++;
		}
		
		System.out.println("sum = " + sum);
	}
}
