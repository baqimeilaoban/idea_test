package com.company.MyPro03;

/**
 * 测试if单选结构
 * @author 黄建波
 *
 */
public class TestIf {

	public static void main(String[] args) {
		//返回[0,1)之间的随机数
		double d = Math.random();
		System.out.println(d);
		System.out.println((int)(6*Math.random()));
		
		int h = (int)(6*Math.random()+1);
		if (h <= 3) {
			System.out.println("小");
		}
		
		System.out.println("************************");
		//通过掷三颗骰子看看今天手气如何
		int i = (int)(6*Math.random()) + 1;
		System.out.println("i = " + i);
		int j = (int)(6*Math.random()) + 1;
		System.out.println("j = " + j);
		int k = (int)(6*Math.random()) + 1;
		System.out.println("k = " + k);
		int count = i + j + k;
		//如果三个骰子之和大于15，则表示今天手气不错
		if (count > 15) {
			System.out.println("今天手气不错");
		}
		//如果三颗骰子之和在10到15之间，则表示今天手气一般
		if (count >= 10 && count <= 15) {
			System.out.println("今天手气一般");
		}
		//如果三颗骰子之和小于10，则手气不怎么样
		if (count < 10) {
			System.out.println("今天手气不怎么样");
		}
		System.out.println("得了" + count + "分");
	}
}
