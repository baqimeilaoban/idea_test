package cn.sxt.oop;

/**
 * ���������ڲ���
 * @author �ƽ���
 */
public class TestAnonymousInner {
    public static void test01(AA a){
        System.out.println("******");
        a.aa();
    }

    public static void main(String[] args) {
        TestAnonymousInner.test01(new AA() {
            @Override
            public void aa() {
                System.out.println("TestAnonymousInner.main(...).new AA() {...}.aa()");
            }
        });
    }
}


interface AA{
    void aa();
}


