package cn.designpattern.bridge;

/**
 * Ʒ��ά��
 * @author hjb
 */
public interface Brand {
    void sale();
}

class Lenovo implements Brand{

    @Override
    public void sale() {
        System.out.println("�����������");
    }
}

class Dell implements Brand{

    @Override
    public void sale() {
        System.out.println("����Dell����");
    }
}

class Shenzhou implements Brand{

    @Override
    public void sale() {
        System.out.println("�������ݵ���");
    }
}
