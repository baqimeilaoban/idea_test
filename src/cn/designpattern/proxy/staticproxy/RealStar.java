package cn.designpattern.proxy.staticproxy;

public class RealStar implements Star{
    @Override
    public void confer() {
        System.out.println("RealStar.confer()");
    }

    @Override
    public void signConstract() {
        System.out.println("RealStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("RealStar.bookTicket()");
    }

    @Override
    public void sing() {
        System.out.println("RealStar(ÖÜ½ÜÂ×±¾ÈË).sing()");
    }

    @Override
    public void collectMoney() {
        System.out.println("RealStar.collectMoney()");
    }
}
