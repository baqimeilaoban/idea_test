package cn.designpattern.decorator;

/**
 * 抽象构建
 * @author hjb
 */
public interface Icar {
    void move();
}

/**
 * ConcreateComponent具体构建角色（真实对象）
 */
class Car implements Icar{

    @Override
    public void move() {
        System.out.println("陆地上跑！");
    }
}

/**
 * Decorator装饰角色
 */
class SuperCar implements Icar{
    protected Icar car;

    public SuperCar(Icar car) {
        this.car = car;
    }

    @Override
    public void move() {
        car.move();
    }
}

/**
 * ConcreteDecorator具体装饰角色
 */
class FlyCar extends SuperCar{

    public FlyCar(Icar car) {
        super(car);
    }

    public void fly(){
        System.out.println("天生飞！");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

/**
 * ConcreteDecorator具体装饰角色
 */
class WaterCar extends SuperCar{
    public WaterCar(Icar car) {
        super(car);
    }

    public void swim(){
        System.out.println("水上游！");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}

/**
 * ConcreteDecorator具体装饰角色
 */
class AICar extends SuperCar{
    public AICar(Icar car) {
        super(car);
    }

    public void autoMove(){
        System.out.println("自动跑！");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}