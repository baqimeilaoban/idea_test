package cn.sxt.oo2;

/**
 * 测试封装所用，class前面添加public表明不同的包也可用
 * @author thinkpad
 */
public class Human{
    private int age;
    /**
     * 可以被本包下面的类访问
     * name为default属性，不能被不同包的类访问
     */
    String name;
    protected int height;

    public void sayAge(){
        System.out.println(age);
    }
}