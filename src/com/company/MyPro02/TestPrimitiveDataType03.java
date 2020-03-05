package com.company.MyPro02;

/**
 * 测试字符类型和布尔类型
 * @author 黄建波
 *
 */
public class TestPrimitiveDataType03 {

	public static void main(String[] args) {
		char a = 'T';
		char b = '黄';
		char c = '\u0061';
		System.out.println(c);
		
		//转义字符
		System.out.println("" + 'a' + '\n' + 'b');
		System.out.println("" + 'a' + '\t' + 'b');
		System.out.println("" + 'a' + '\'' + 'b');
		
		//String是字符序列
		String d = "abc";
		
		//布尔类型
		boolean man = true;
		
		if(man) {
			System.out.println("男性");
		}
	}
}
