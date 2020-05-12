package cn.designpattern.factory.abstractfactory;

public interface Seat {
    void massage();
}

class LuxurySeat implements Seat{

    @Override
    public void massage() {
        System.out.println("�����Զ���Ħ��");
    }
}

class LowSeat implements Seat{

    @Override
    public void massage() {
        System.out.println("���ܰ�Ħ��");
    }
}
