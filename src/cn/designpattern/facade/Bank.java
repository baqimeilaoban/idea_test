package cn.designpattern.facade;

public interface Bank {
    void openAccount();
}

class ICBC implements Bank{

    @Override
    public void openAccount() {
        System.out.println("���й��������п�����");
    }
}
