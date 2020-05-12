package cn.designpattern.templatemethod;

public class Client {
    public static void main(String[] args) {
        BankTemplateMethod btm = new DrawMoney();
        btm.process();

        System.out.println("���������ڲ���");
        BankTemplateMethod btm2 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("��Ҫ��Ǯ��");
            }
        };
        btm2.process();
        System.out.println("*************");
        BankTemplateMethod bmt3 = new BankTemplateMethod() {
            @Override
            public void transact() {
                System.out.println("��Ҫ��ƣ���������2000�򺫱�");
            }
        };
        bmt3.process();
    }
}

class DrawMoney extends BankTemplateMethod{

    @Override
    public void transact() {
        System.out.println("��Ҫȡ�");
    }
}
