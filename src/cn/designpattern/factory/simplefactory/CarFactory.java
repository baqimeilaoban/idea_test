package cn.designpattern.factory.simplefactory;

/**
 * �򵥹��������
 * @author hjb
 */
public class CarFactory {
    public static Car createCar(String type){
        if ("�µ�".equals(type)){
            return new Audi();
        }else if ("���ǵ�".equals(type)){
            return new Byad();
        }else {
            return null;
        }
    }
}
