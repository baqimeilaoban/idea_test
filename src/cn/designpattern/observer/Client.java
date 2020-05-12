package cn.designpattern.observer;

public class Client {
    public static void main(String[] args) {
        //Ŀ�����
        ConcreteSubject subject = new ConcreteSubject();

        //��������۲���
        ObserverA observerA1 = new ObserverA();
        ObserverA observerA2 = new ObserverA();
        ObserverA observerA3 = new ObserverA();

        //���������۲�����ӵ�subject����Ĺ۲��߶�����
        subject.registerObserver(observerA1);
        subject.registerObserver(observerA2);
        subject.registerObserver(observerA3);

        //�ı�subject��״̬
        subject.setState(3000);
        System.out.println("************");
        //�۲��ߵ�״̬�Ƿ����仯
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());

        //�ı�subject��״̬
        subject.setState(30);
        System.out.println("**************");
        //�۲��ߵ�״̬�Ƿ����仯
        System.out.println(observerA1.getMyState());
        System.out.println(observerA2.getMyState());
        System.out.println(observerA3.getMyState());
    }
}
