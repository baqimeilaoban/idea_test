package com.company.MyPro03;

/**
 * ����ifelse˫ѡ����
 * @author �ƽ���
 *
 */
public class TestIfElse {

	public static void main(String[] args) {
		//�������һ��[0,4)����İ뾶�������ݰ뾶��Բ���ܳ������
		double r = 4 * Math.random();
		//Math.pow(r,2)��뾶��ƽ��
		double area = Math.PI * Math.pow(r, 2);
		double circle = 2 * Math.PI * r;
		System.out.println("�뾶Ϊ��" + r);
		System.out.println("�ܳ�Ϊ��" + circle);
		System.out.println("���Ϊ��" + area);
		//���������ڵ����ܳ����������������ڵ����ܳ�������������ܳ��������
		if (area >= circle) {
			System.out.println("������ڵ����ܳ���");
		} else {
			System.out.println("�ܳ����������");
		}
	}
}
