package cn.designpattern.mediator;

public class Maket implements Department{
    /**
     * �����н��ߣ��ܾ���������
     */
    private Mediator m;

    public Maket(Mediator m) {
        this.m = m;
        m.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("��ȥ����Ŀ��");
    }

    @Override
    public void outAction() {
        System.out.println("�㱨��������Ŀ�нӵĽ��ȣ���Ҫ�ʽ�֧�֣�");
        m.command("financial");
    }
}
