package cn.designpattern.strategy;

public class OldCustomerFewStrategy implements Strategy{
    @Override
    public double getPrice(double standardPrice) {
        System.out.println("´ò°ËÎåÕÛ");
        return standardPrice*0.85;
    }
}
