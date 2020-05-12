package cn.designpattern.mediator;

public class Client {
    public static void main(String[] args) {
        Mediator m = new President();
        Maket maket = new Maket(m);
        Development development = new Development(m);
        Finacial finacial = new Finacial(m);

        maket.selfAction();
        maket.outAction();
    }
}
