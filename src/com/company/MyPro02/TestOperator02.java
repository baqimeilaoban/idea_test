package com.company.MyPro02;

/**
 * ²âÊÔÂß¼­ÔËËã·û
 * @author »Æ½¨²¨
 *
 */
public class TestOperator02 {
	public static void main(String[] args) {
		boolean b1 = true;
		boolean b2 = false;
		System.out.println(b1&b2);
		System.out.println(b1|b2);
		System.out.println(b1^b2);
		System.out.println(!b1);
		
		//¶ÌÂ·
		boolean b3 = 1>2 && 2<(3/0);
		System.out.println(b3);
	}
}
