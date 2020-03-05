package com.company.MyPro02;

import java.math.*;
/**
 * ���Ը�������
 * @author �ƽ���
 *
 */
public class TestPrimitiveDataType02 {

	public static void main(String[] args) {
		float a = 3.14f;
		double b = 6.28;
		double c = 628e-2;
		
		System.out.println(c);
		
		//�������ǲ���ȷ�ģ�һ����Ҫ���ڱȽ�
		float f  = 0.1f;
		double d = 1.0/10;
		//���Ϊfalse
		System.out.println(f == d);
		
		float d1 = 423423423f;
		double d2 = d1 + 1;
		if(d1 == d2) {
			//������Ϊd1 == d2
			System.out.println("d1 == d2");
		}else {
			System.out.println("d1 != d2");
		}
		
		System.out.println("*************************");
		//ʹ�þ�ȷ�������㣬�Ƽ���BigDecimal
		BigDecimal bd = BigDecimal.valueOf(1.0);
		//subtractΪ������˼
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
