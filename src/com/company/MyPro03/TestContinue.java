package com.company.MyPro03;

/**
 * 测试循环语句中的continue
 * continue用于结束本次循环，继续循环下一次
 * @author 黄建波
 *
 */
public class TestContinue {

	public static void main(String[] args) {
		//定义计数器
		int count = 0;
		for (int i = 100; i < 150; i++) {
			//如果是3的倍数，则跳过本次循环，继续循环下一次
			if (i % 3 == 0) {
				continue;
			}
			//否则（不是3的倍数），输出该数
			System.out.print(i + "、 ");
			count ++;
			//根据计数器判断每行是否输出了五个数
			if (count % 5 == 0) {
				System.out.println();
				count = 0;
			}
		}
	}
}
