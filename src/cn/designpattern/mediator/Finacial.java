package cn.designpattern.mediator;

public class Finacial implements Department{
    /**
     * �����н��ߣ��ܾ���������
     */
    private Mediator m;

    public Finacial(Mediator m) {
        this.m = m;
        m.register("financial",this);
    }

    @Override
    public void selfAction() {
        System.out.println("��Ǯ��");
    }

    @Override
    public void outAction() {
        System.out.println("�㱨������ûǮ�ˣ�Ǯ̫���ˣ���ô����");
    }
}
