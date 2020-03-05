package cn.sxt.oo2;

/**
 * 测试super关键字
 * @author 黄建波
 */
public class TestSuper02 {
    public static void main(String[] args) {
        System.out.println("开始创建一个ChildClass对象...");
        new ChildClass2();
    }
}

class FatherClass2{
    public FatherClass2(){
        System.out.println("创建FatherClass");
    }
}

class ChildClass2 extends FatherClass2{
    public ChildClass2(){
        //构造器第一句话总是super();
        System.out.println("创建ChildClass");
    }
}

