package cn.designpattern.factory.abstractfactory;

public class LowCarFactory implements CarFactory{
    @Override
    public Engine creatEngine() {
        return new lowEngine();
    }

    @Override
    public Seat creatSeat() {
        return new LowSeat();
    }

    @Override
    public Tyre creatTyre() {
        return new LowTyre();
    }
}
