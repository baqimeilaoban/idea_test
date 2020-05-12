package cn.designpattern.templatemethod;

public abstract class BankTemplateMethod {
    /**
     * ���巽��
     */
    public void takeNumber(){
        System.out.println("ȡ���Ŷ�");
    }

    /**
     * ��������ҵ�񣨹��ӷ�����
     */
    public abstract void transact();

    public void evalute(){
        System.out.println("��������");
    }

    /**
     * ģ�巽��
     */
    public final void process(){
        this.takeNumber();

        this.transact();

        this.evalute();
    }
}
