package com.company.MyPro02;

/**
 * 测试类型转换常见问题
 * @author 黄建波
 *
 */
public class TestTypeConvertError {

	public static void main(String[] args) {
		int money = 1000000000;
		int year = 20;
		//返回的total是负数，超过了int的范围
		int total = money * year;
		System.out.println("total = " + total);
		//返回的total数仍然是负数，默认是int，因此结果会转为int值，再转为long。但是已经发生了数据丢失
		long total1 = money * year;
		System.out.println("total1 = " + total1);
		//返回的total2正确：先将一个因子变成long，整个表达式发生提升。全部用long计算
		long total2 = money * ((long)year);
		System.out.println("total2 = " + total2);
		
		//命名问题
		//分不清是L还1
		int l = 2;
		//建议使用大写L
		long a = 2345L;
		System.out.println(l + 1);
	}
}
