package cn.sxt.oop;

/**
 * 测试抽象类
 * 抽象类的意义在于：为子类提供统一的，规范的模板，子类必须实现相关的抽象方法
 * @author 黄建波
 */
public abstract class Animal {
    /**
     * 抽象方法没有实现
     * 第一：父类没有实现
     * 第二：子类必须实现
     */
    abstract public void shout();

    public void run(){
        System.out.println("跑啊跑！");
    }

    public static void main(String[] args) {
        Animal d = new Dog();
        d.shout();
    }
}

class Dog extends Animal{

    @Override
    public void shout() {
        System.out.println("汪汪汪！");
    }
}
