package cn.sxt.annotation.testcase;

/**
 * @author thinkpad
 */
public class Demo01 {
    static {
        System.out.println("��̬��ĳ�ʼ��Demo01");
    }
    public static void main(String[] args) {
        System.out.println("Demo01��main������");
        System.out.println(System.getProperty("java.class.path"));
        System.out.println(B.width);
    }
}

class A_Father extends Object{
    static {
        System.out.println("��̬��ʼ��A_Father");
    }
}

class A extends A_Father{
    public static int width=100;
    public static int MAX=100;

    static {
        System.out.println("��̬��ʼ����A");
        width=300;
    }
    public A(){
        System.out.println("����A��Ķ���");
    }
}

class B extends A{
    static {
        System.out.println("��̬��ʼ��B");
    }
}