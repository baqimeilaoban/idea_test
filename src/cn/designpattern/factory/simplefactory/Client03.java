package cn.designpattern.factory.simplefactory;

/**
 * ���Լ򵥹���ģʽ
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
