package cn.designpattern.adapter;

/**
 * 被适配的类
 *（相当于例子中的，ps/2键盘）
 * @author thinkpad
 */
public class Adaptee {
    public void request(){
        System.out.println("可以完成客户请求的需要的功能！");
    }
}
