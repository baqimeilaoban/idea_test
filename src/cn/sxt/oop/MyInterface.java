package cn.sxt.oop;

/**
 * ����interface
 * @author �ƽ���
 */
public interface MyInterface {
    /**
     * �ӿڶ����Ϊ����
     * ���൱��public static final int maxAge = 100;
     */
    int MAX_AGE = 100;

    /**
     * �����൱�ڣ�public abstract void test();
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
