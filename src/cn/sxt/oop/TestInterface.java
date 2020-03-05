package cn.sxt.oop;

/**
 * ���Խӿں�ʵ����
 * @author �ƽ���
 */
public class TestInterface {
    public static void main(String[] args) {
        Volant v = new Angel();
        v.fly();

        Honest h = new GoodMan();
        h.helpOther();
    }
}

interface Volant{
    int FLY_HEIGHT = 1000;
    void fly();
}

interface Honest{
    void helpOther();
}

/**
 * ʵ�������ʵ�ֶ���ӿ�
 */
class Angel implements Volant,Honest{

    @Override
    public void fly() {
        System.out.println("Angel.fly()");
    }

    @Override
    public void helpOther() {
        System.out.println("Angel.helpOther()");
    }
}

class GoodMan implements Honest{

    @Override
    public void helpOther() {
        System.out.println("GoodMan.HelpOther()");
    }
}

class Birdman implements Volant{

    @Override
    public void fly() {
        System.out.println("BirdMan.fly()");
    }
}