package cn.sxt.oo2;

/**
 * 测试多态
 * @author 黄建波
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);
        //向上自动转型
        Animal d = new Dog();
        //d.seeDoor(); 编译器不认识，必须强制转换为Dog对象
        animalCry(d);
        animalCry(new Cat());
        //向下强制转型
        Dog d2 = (Dog)d;
        d2.seeDoor();
    }

    /**
     * 多态
     * @param a：父类对象，父类引用指向子类对象
     */
    static void animalCry(Animal a){
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.println("叫了一声");
    }
}

class Dog extends Animal{
    /**
     * 重写shout方法
     */
    @Override
    public void shout(){
        System.out.println("汪汪汪！");
    }

    public void seeDoor(){
        System.out.println("看门！");
    }
}

class Cat extends Animal{
    /**
     * 重写shout方法
     */
    @Override
    public void shout(){
        System.out.println("喵喵喵！");
    }
}