package cn.sxt.oop;

/**
 * 测试方法内部类
 * @author 黄建波
 */
public class TestMethodInnerClass {
    public void show(){
        /**
         * 作用域仅限于该方法
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
