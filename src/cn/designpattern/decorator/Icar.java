package cn.designpattern.decorator;

/**
 * ���󹹽�
 * @author hjb
 */
public interface Icar {
    void move();
}

/**
 * ConcreateComponent���幹����ɫ����ʵ����
 */
class Car implements Icar{

    @Override
    public void move() {
        System.out.println("½�����ܣ�");
    }
}

/**
 * Decoratorװ�ν�ɫ
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
 * ConcreteDecorator����װ�ν�ɫ
 */
class FlyCar extends SuperCar{

    public FlyCar(Icar car) {
        super(car);
    }

    public void fly(){
        System.out.println("�����ɣ�");
    }

    @Override
    public void move() {
        super.move();
        fly();
    }
}

/**
 * ConcreteDecorator����װ�ν�ɫ
 */
class WaterCar extends SuperCar{
    public WaterCar(Icar car) {
        super(car);
    }

    public void swim(){
        System.out.println("ˮ���Σ�");
    }

    @Override
    public void move() {
        super.move();
        swim();
    }
}

/**
 * ConcreteDecorator����װ�ν�ɫ
 */
class AICar extends SuperCar{
    public AICar(Icar car) {
        super(car);
    }

    public void autoMove(){
        System.out.println("�Զ��ܣ�");
    }

    @Override
    public void move() {
        super.move();
        autoMove();
    }
}