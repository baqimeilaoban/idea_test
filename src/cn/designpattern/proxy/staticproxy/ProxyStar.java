package cn.designpattern.proxy.staticproxy;

public class ProxyStar implements Star{
    private Star star;

    public ProxyStar(Star star) {
        this.star = star;
    }

    @Override
    public void confer() {
        System.out.println("ProxyStar.confer()");
    }

    @Override
    public void signConstract() {
        System.out.println("ProxyStar.signContract()");
    }

    @Override
    public void bookTicket() {
        System.out.println("ProxyStar.bookTicket()");
    }

    @Override
    public void collectMoney() {
        System.out.println("ProxyStar.signContract()");
    }

    @Override
    public void sing() {
        star.sing();
    }
}
