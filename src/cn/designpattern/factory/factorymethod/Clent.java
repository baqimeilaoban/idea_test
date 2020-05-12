package cn.designpattern.factory.factorymethod;

public class Clent {
    public static void main(String[] args) {
        Car c1 = new AudiFactory().creatCar();
        Car c2 = new BydFactory().creatCar();

        c1.run();
        c2.run();
    }
}
