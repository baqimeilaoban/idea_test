package com.company.MyPro02;

/**
 * �����ַ����ͺͲ�������
 * @author �ƽ���
 *
 */
public class TestPrimitiveDataType03 {

	public static void main(String[] args) {
		char a = 'T';
		char b = '��';
		char c = '\u0061';
		System.out.println(c);
		
		//ת���ַ�
		System.out.println("" + 'a' + '\n' + 'b');
		System.out.println("" + 'a' + '\t' + 'b');
		System.out.println("" + 'a' + '\'' + 'b');
		
		//String���ַ�����
		String d = "abc";
		
		//��������
		boolean man = true;
		
		if(man) {
			System.out.println("����");
		}
	}
}
