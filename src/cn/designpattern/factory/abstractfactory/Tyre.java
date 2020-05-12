package cn.designpattern.factory.abstractfactory;

public interface Tyre {
    void revolve();
}

class LuxuryTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("��ת��ĥ��");
    }
}

class LowTyre implements Tyre{

    @Override
    public void revolve() {
        System.out.println("��תĥ��죡");
    }
}