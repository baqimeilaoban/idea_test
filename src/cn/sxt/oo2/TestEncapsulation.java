package cn.sxt.oo2;

/**
 * 测试封装
 * @author 黄建波
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
        h.name = "黄建波";
        h.height = 230;

        Person4Encapsulation p4 = new Person4Encapsulation();
        p4.setAge(-14);
        System.out.println(p4.getAge());
    }
}

class Boy extends Human{
    void sayHello(){
        //System.out.println(age); 子类无法使用父类的私有属性方法
    }
}
