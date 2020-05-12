package cn.designpattern.factory.abstractfactory;

public interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("ת�ÿ�");
    }

    @Override
    public void start() {
        System.out.println("�����죡�����Զ���ͣ��");
    }
}


class lowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("ת������");
    }

    @Override
    public void start() {
        System.out.println("��������");
    }
}