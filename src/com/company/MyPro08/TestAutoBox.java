package com.company.MyPro08;

/**
 * 测试自动装箱，自动拆箱
 * @author 黄建波
 */
public class TestAutoBox {
    public static void main(String[] args) {
        //自动装箱，这句话相当于Integer a = Integer.valueOf(234);
        Integer a = 234;
        //自动拆箱，这句话相当于int b = a.intValue();
        int b = a;

        Integer c = null;
        if(c != null){
            //自动拆箱，调用了：c.intValue();
            int d = c;
        }

        //缓存[-128,127]之间的数字，实际上就是系统初始的时候，创建了[-128,127]之间的缓存数组
        //当我们调用ValueOf()的时候，首先检查是否在[-128,127]之间，如果在这个范围则直接从缓存数组中拿出已经建好的对象
        //如果不在这个范围，则创建新的Integer对象
        Integer in1 = Integer.valueOf(-128);
        Integer in2 = -128;
        //true，因为-128在缓存范围内
        System.out.println(in1 == in2);
        //true
        System.out.println(in1.equals(in2));
        Integer in3 = 1234;
        Integer in4 = 1234;
        //false，因为1234不在缓存范围内
        System.out.println(in3 == in4);
        //true
        System.out.println(in3.equals(in4));
    }
}
