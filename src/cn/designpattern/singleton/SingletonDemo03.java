package cn.designpattern.singleton;

/**
 * 双重检查锁实现单例模式
 * @author hjb
 */
public class SingletonDemo03 {
    private static SingletonDemo03 instance = null;

    public static SingletonDemo03 getInstance(){
        if (instance==null){
            SingletonDemo03 sc;
            synchronized (SingletonDemo03.class){
                sc = instance;
                if (sc==null){
                    synchronized (SingletonDemo03.class){
                        if (sc==null){
                            sc = new SingletonDemo03();
                        }
                    }
                    return sc;
                }
            }
        }
        return instance;
    }

    private SingletonDemo03(){

    }
}
