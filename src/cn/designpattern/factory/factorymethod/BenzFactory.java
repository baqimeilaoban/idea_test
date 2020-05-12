package cn.designpattern.factory.factorymethod;

public class BenzFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Benz();
    }
}
