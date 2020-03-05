package cn.sxt.oo2;

/**
 * 测试Object类
 * @author 黄建波
 */
public class TestObject {
    public static void main(String[] args) {
        //Object obj;

        TestObject to = new TestObject();
        System.out.println(to.toString());

        Person2 person2 = new Person2();
        person2.age = 25;
        person2.name = "黄建波";
        System.out.println(person2.toString());

        Person2 person21 = new Person2("黄1",17);
        System.out.println(person21.toString());
    }

    /**
     * 重写toString方法
     * @return
     */
    @Override
    public String toString(){
        return "测试Object对象";
    }
}

class Person2{
    String name;
    int age;

    @Override
    public String toString(){
        return name + ",年龄" + age;
    }

    /**
     * 构造器
     * @param name：姓名
     * @param age：年龄
     */
    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * 空构造器
     */
    public Person2(){}
}