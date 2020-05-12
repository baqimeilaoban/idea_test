package cn.designpattern.factory.simplefactory;

/**
 * 简单工厂情况下
 * @author hjb
 */
public class Client02 {
    public static void main(String[] args) {
        Car c1 = CarFactory.createCar("奥迪");
        Car c2 = CarFactory.createCar("比亚迪");

        c1.run();
        c2.run();
    }
}
