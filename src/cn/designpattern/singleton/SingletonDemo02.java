package cn.designpattern.singleton;

/**
 * 测试懒汉式单例模式
 * @author hjb
 */
public class SingletonDemo02 {
    /**
     *  类初始化时，不初始化这个对象（延时加载，真正用的时候再创建）
     */
    private static SingletonDemo02 instance;

    /**
     * 私有化构造器
     */
    private SingletonDemo02() {
    }

    /**
     * 方法同步，调用效率低
     */
    public static synchronized SingletonDemo02 getInstance(){
        if (instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
