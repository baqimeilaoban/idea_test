package com.company.MyPro03;

/**
 * ����ѭ������е�continue
 * continue���ڽ�������ѭ��������ѭ����һ��
 * @author �ƽ���
 *
 */
public class TestContinue {

	public static void main(String[] args) {
		//���������
		int count = 0;
		for (int i = 100; i < 150; i++) {
			//�����3�ı���������������ѭ��������ѭ����һ��
			if (i % 3 == 0) {
				continue;
			}
			//���򣨲���3�ı��������������
			System.out.print(i + "�� ");
			count ++;
			//���ݼ������ж�ÿ���Ƿ�����������
			if (count % 5 == 0) {
				System.out.println();
				count = 0;
			}
		}
	}
}
