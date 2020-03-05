package com.company.MyPro03;

/**
 * ²âÊÔswitchÓï¾ä
 * @author »Æ½¨²¨
 *
 */
public class TestSwitch {

	public static void main(String[] args) {
		char c = 'a';
		int rand = (int)(26 * Math.random());
		char c2 = (char)(c + rand);
		System.out.println(c2 + "£º");
		switch (c2) {
		case 'a':
		case 'e':
		case 'i':
		case 'o':
		case 'u':
			System.out.println("ÔªÒô");
			break;
		case 'y':
		case 'w':
			System.out.println("°ëÔªÒô");
			break;
		default:
			System.out.println("¸¨Òô");
		}
	}
}
