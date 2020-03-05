package com.company.MyPro02;

import java.math.*;
/**
 * 测试浮点类型
 * @author 黄建波
 *
 */
public class TestPrimitiveDataType02 {

	public static void main(String[] args) {
		float a = 3.14f;
		double b = 6.28;
		double c = 628e-2;
		
		System.out.println(c);
		
		//浮点数是不精确的，一定不要用于比较
		float f  = 0.1f;
		double d = 1.0/10;
		//结果为false
		System.out.println(f == d);
		
		float d1 = 423423423f;
		double d2 = d1 + 1;
		if(d1 == d2) {
			//输出结果为d1 == d2
			System.out.println("d1 == d2");
		}else {
			System.out.println("d1 != d2");
		}
		
		System.out.println("*************************");
		//使用精确浮点运算，推荐，BigDecimal
		BigDecimal bd = BigDecimal.valueOf(1.0);
		//subtract为减的意思
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		bd = bd.subtract(BigDecimal.valueOf(0.1));
		//0.5
		System.out.println(bd);
		//0.50000000000001
		System.out.println(1.0 - 0.1 - 0.1 - 0.1 - 0.1 - 0.1);
		
		BigDecimal bd2 = BigDecimal.valueOf(0.1);
		BigDecimal bd3 = BigDecimal.valueOf(1.0/10);

		//true
		System.out.println(bd2.equals(bd3));
	}
}
