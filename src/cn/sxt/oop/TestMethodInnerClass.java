package cn.sxt.oop;

/**
 * ���Է����ڲ���
 * @author �ƽ���
 */
public class TestMethodInnerClass {
    public void show(){
        /**
         * ����������ڸ÷���
         */
        class Inner{
            public void fun(){
                System.out.println("hello world!");
            }
        }
        new Inner().fun();
    }

    public static void main(String[] args) {
        new TestMethodInnerClass().show();
    }
}
