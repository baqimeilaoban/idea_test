package cn.sxt.oop;

/**
 * 测试非静态内部类
 * @author 黄建波
 */
public class TestInnerClass {

    public static void main(String[] args) {
        //创建内部类对象
        Outer.Inner inner = new Outer().new Inner();

        inner.show();
    }
}

class Outer{
    private int age = 10;

    public void testOuter(){}

    /**
     * 非静态内部类和静态内部类也叫做成员内部类
     */
    class Inner{
        int age = 25;
        public void show(){
            int age = 30;
            System.out.println("外部类的成员变量age:" + Outer.this.age);
            System.out.println("内部类的成员变量age:" + this.age);
            System.out.println("局部的成员变量age:" + age);
        }
    }
}
