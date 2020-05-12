package cn.designpattern.proxy.staticproxy;

public class Client {
    public static void main(String[] args) {
        Star real = new RealStar();
        Star proxy = new ProxyStar(real);

        proxy.confer();
        proxy.signConstract();
        proxy.bookTicket();
        proxy.sing();

        proxy.collectMoney();
    }
}
