package cn.sxt.oo2;

/**
 * 测试继承
 * final修饰的类不能被继承
 * java的类没有多继承，java的接口有多继承
 * @author 黄建波
 */
public class TestExtends {
    public static void main(String[] args) {
        Student stu = new Student();
        stu.name = "黄建波";
        stu.height = 162;
        stu.major = "计算机技术";
        stu.rest();
        stu.study();

        Student stu2 = new Student("喜喜",6,"挖掘机");
        System.out.println(stu2 instanceof Student);
        System.out.println(stu2 instanceof Person);
        stu2.study();
    }
}

class Person{
    String name;
    int height;

    public void rest(){
        System.out.println("休息一会儿");
    }
}

//可以使用CTRL+H方便查看继承结构
class Student extends Person{
    String major;

    public void study(){
        System.out.println("学习两小时");
    }

    //构造器
    public Student (String name, int height, String major){
        this.name = name;
        this.height = height;
        this.major = major;
    }

    public Student(){}
}