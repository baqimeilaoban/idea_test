package cn.designpattern.strategy;

/**
 * 负责和具体的策略类进行交互
 * 这样的话，具体的算法和直接的客户端调用分离了，使得算法可以独立于客户端独立的变化
 * 如果使用spring的依赖注入功能，还可以通过配置文件，动态的注入不同的策略对象，动态的切换不同的算法
 * @author 黄建波
 */
public class Context {
    /**
     * 当前采用的算法对象
     */
    private Strategy strategy;

    /**
     * 可以通过构造器来注入
     * @param strategy 策略
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * 可以通过set方法来注入
     * @param strategy 策略
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrince(double s){
        System.out.println("你的报价：" + strategy.getPrice(s));
    }
}
