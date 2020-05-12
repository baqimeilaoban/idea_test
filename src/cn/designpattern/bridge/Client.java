package cn.designpattern.bridge;

public class Client {
    public static void main(String[] args) {
        Computer2 c = new Laptop2(new Lenovo());
        c.sale();
        System.out.println("************");
        Computer2 c2 = new Desktop2(new Shenzhou());
        c2.sale();
    }
}
