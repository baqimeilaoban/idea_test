package com.company.MyPro03;

/**
 * ����if��ѡ�ṹ
 * @author �ƽ���
 *
 */
public class TestIf {

	public static void main(String[] args) {
		//����[0,1)֮��������
		double d = Math.random();
		System.out.println(d);
		System.out.println((int)(6*Math.random()));
		
		int h = (int)(6*Math.random()+1);
		if (h <= 3) {
			System.out.println("С");
		}
		
		System.out.println("************************");
		//ͨ�����������ӿ��������������
		int i = (int)(6*Math.random()) + 1;
		System.out.println("i = " + i);
		int j = (int)(6*Math.random()) + 1;
		System.out.println("j = " + j);
		int k = (int)(6*Math.random()) + 1;
		System.out.println("k = " + k);
		int count = i + j + k;
		//�����������֮�ʹ���15�����ʾ������������
		if (count > 15) {
			System.out.println("������������");
		}
		//�����������֮����10��15֮�䣬���ʾ��������һ��
		if (count >= 10 && count <= 15) {
			System.out.println("��������һ��");
		}
		//�����������֮��С��10������������ô��
		if (count < 10) {
			System.out.println("������������ô��");
		}
		System.out.println("����" + count + "��");
	}
}
