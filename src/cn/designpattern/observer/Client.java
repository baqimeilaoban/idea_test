package cn.designpattern.observer;

public class Client {
    public static void main(String[] args) {
        //目标对象
        ConcreteSubject subject = new ConcreteSubject();

        //创建多个观察者
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();
        ObserverA observerA3 = new ObserverA();

        //将这三个观察者添加到subject对象的观察者队伍中
        subject.registerObserver(observerA1);
        subject.registerObserver(observerA2);
        subject.registerObserver(observerA3);

        //改变subject的状态
        subject.setState(3000);
        System.out.println("************");
        //观察者的状态是否发生变化
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());

        //改变subject的状态
        subject.setState(30);
        System.out.println("**************");
        //观察者的状态是否发生变化
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());
    }
}
