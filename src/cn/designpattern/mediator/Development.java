package cn.designpattern.mediator;

public class Development implements Department{
    /**
     * �����н��ߣ��ܾ���������
     */
    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("ר�Ŀ��У�������Ŀ��");
    }

    @Override
    public void outAction() {
        System.out.println("�㱨������ûǮ�ˣ���Ҫ�ʽ�֧�֣�");
    }
}
