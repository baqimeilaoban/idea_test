package cn.designpattern.factory.simplefactory;

/**
 * 测试简单工厂模式
 * @author hjb
 */
public class Client03 {
    public static void main(String[] args) {
        Car c1 = CarFactory02.createAudi();
        Car c2 = CarFactory02.createByad();

        c1.run();
        c2.run();
    }
}
