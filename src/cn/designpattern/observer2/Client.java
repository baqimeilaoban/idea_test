package cn.designpattern.observer2;

public class Client {
    public static void main(String[] args) {
        //����Ŀ�����Obserable
        ConcreteSubject subject = new ConcreteSubject();

        //�����۲���
        ObserverA obs1 = new ObserverA();
        ObserverA obs2 = new ObserverA();
        ObserverA obs3 = new ObserverA();

        //�����������۲��߶�����ӵ�Ŀ�����subject�Ĺ۲���������
        subject.addObserver(obs1);
        subject.addObserver(obs2);
        subject.addObserver(obs3);

        //�ı�subject�����״̬
        subject.set(3000);
        System.out.println("===============״̬�޸��ˣ�");
        //�۲��ߵ�״̬�����˱仯
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());

        subject.set(600);
        System.out.println("===============״̬�޸��ˣ�");
        //�۲��ߵ�״̬�����˱仯
        System.out.println(obs1.getMyState());
        System.out.println(obs2.getMyState());
        System.out.println(obs3.getMyState());
    }
}
