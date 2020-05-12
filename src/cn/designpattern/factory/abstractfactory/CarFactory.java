package cn.designpattern.factory.abstractfactory;

public interface CarFactory {
    Engine creatEngine();
    Seat creatSeat();
    Tyre creatTyre();
}
