package cn.sxt.oo2;

/**
 * 测试super关键字
 * @author 黄建波
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
        //调用父类对象的普通方法
        super.f();
        value = 200;
        System.out.println("ChildClass.value=" + value);
        System.out.println(value);
        //调用父类对象的成员变量
        System.out.println(super.value);
    }
}