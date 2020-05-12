package cn.designpattern.factory.simplefactory;

/**
 * 简单工厂情况下
 * @author hjb
 */
public class CarFactory {
    public static Car createCar(String type){
        if ("奥迪".equals(type)){
            return new Audi();
        }else if ("比亚迪".equals(type)){
            return new Byad();
        }else {
            return null;
        }
    }
}
