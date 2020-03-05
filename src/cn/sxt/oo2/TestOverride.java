package cn.sxt.oo2;

/**
 * 测试重写(Override)
 * @author 黄建波
 */
public class TestOverride {
    public static void main(String[] args) {
        System.out.println("程序开始：");
        Horse h = new Horse();
        h.run();
    }
}

class Vehicle{
    public void run(){
        System.out.println("跑......");
    }

    public void stop(){
        System.out.println("停止！");
    }

    public Person WhoIsPsg(){
        return new Person();
    }
}

class  Horse extends Vehicle{

    @Override
    /**
     * 优先调用自己的实现
     */
    public void run(){
        System.out.println("四蹄翻飞，得得得得");
    }

    @Override
    public Student WhoIsPsg(){
        return new Student();
    }
}