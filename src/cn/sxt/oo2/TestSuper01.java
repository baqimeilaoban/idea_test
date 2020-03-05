package cn.sxt.oo2;

/**
 * ����super�ؼ���
 * @author �ƽ���
 */
public class TestSuper01 {
    public static void main(String[] args) {
        new ChildClass().f();
    }
}

class FatherClass{
    public int value;

    public void f(){
        value = 100;
        System.out.println("FatherClass.value=" + value);
    }
}

class ChildClass extends FatherClass{
    public int value;

    @Override
    public void f(){
        //���ø���������ͨ����
        super.f();
        value = 200;
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        //���ø������ĳ�Ա����
        System.out.println(super.value);
    }
}