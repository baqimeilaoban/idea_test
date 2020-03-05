package cn.sxt.oop;

/**
 * 测试interface
 * @author 黄建波
 */
public interface MyInterface {
    /**
     * 接口定义的为常量
     * 其相当于public static final int maxAge = 100;
     */
    int MAX_AGE = 100;

    /**
     * 方法相当于：public abstract void test();
     */
    void test01();
}

class MyClass implements MyInterface{

    @Override
    public void test01() {
        System.out.println(MAX_AGE);
        System.out.println("MyClass.test01()");
    }
}
