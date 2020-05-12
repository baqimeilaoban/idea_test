package cn.designpattern.strategy;

public class Client {
    public static void main(String[] args) {
        Strategy s1 = new OldCustomerManyStrategy();
        Context ctx = new Context(s1);

        ctx.pringPrince(998);
    }
}
