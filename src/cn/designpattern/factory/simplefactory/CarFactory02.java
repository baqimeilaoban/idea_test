package cn.designpattern.factory.simplefactory;

/**
 * ≤‚ ‘ºÚµ•π§≥ß
 * @author hjb
 */
public class CarFactory02 {
    public static Car createAudi(){
        return new Audi();
    }

    public static Car createByad(){
        return new Byad();
    }
}
