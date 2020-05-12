package cn.designpattern.factory.factorymethod;

public class BydFactory implements CarFactory{
    @Override
    public Car creatCar() {
        return new Byd();
    }
}
