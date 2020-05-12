package cn.designpattern.builder;

public class Client {
    public static void main(String[] args) {
        AirShipDirector director = new SxtAirShipDirector(new SxtAirShipBuilder());
        AirShip ship = director.directAirShip();
        System.out.println(ship.getEngine().getName());
        ship.lunch();
    }
}
