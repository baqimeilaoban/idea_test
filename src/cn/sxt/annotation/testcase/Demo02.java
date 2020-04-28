package cn.sxt.annotation.testcase;

/**
 * 测试类加载器的层次结构、双亲委托机制
 * @author hjb
 *
 */
public class Demo02 {
    public static void main(String[] args) {
        System.out.println(ClassLoader.getSystemClassLoader());
        System.out.println(ClassLoader.getSystemClassLoader().getParent());
        System.out.println(ClassLoader.getSystemClassLoader().getParent().getParent());
        System.out.println(System.getProperty("java.class.path"));
        System.out.println("****************");
        String a = "gaogao";
        System.out.println(a.getClass().getClassLoader());
        System.out.println(a);
    }
}
