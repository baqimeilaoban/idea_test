package cn.designpattern.factory.abstractfactory;

public class LuxuryCarFactory implements CarFactory{
    @Override
    public Engine creatEngine() {
        return new LuxuryEngine();
    }

    @Override
    public Seat creatSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre creatTyre() {
        return new LuxuryTyre();
    }
}
