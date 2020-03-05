package cn.sxt.oo;

import cn.sxt.oo2.Human;

/**
 * 测试封装
 * @author 黄建波
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
        // h.name = "黄建波"; name为default属性，不能被不同包的类访问
        h.sayAge(); //公开的，不同的包都能调用
    }
}

class Girl extends Human{
    void sayGood(){
        System.out.println(height);
    }
}
