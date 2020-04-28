package cn.sxt.annotation.testcase;

/**
 * @author thinkpad
 */
public class Demo01 {
    static {
        System.out.println("静态类的初始化Demo01");
    }
    public static void main(String[] args) {
        System.out.println("Demo01的main方法！");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(B.width);
    }
}

class A_Father extends Object{
    static {
        System.out.println("静态初始化A_Father");
    }
}

class A extends A_Father{
    public static int width=100;
    public static int MAX=100;

    static {
        System.out.println("静态初始化类A");
        width=300;
    }
    public A(){
        System.out.println("创建A类的对象");
    }
}

class B extends A{
    static {
        System.out.println("静态初始化B");
    }
}