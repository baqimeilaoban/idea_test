package cn.sxt.thread.thread01;

/**
 * ��̬����
 * �����ӿڣ�
 * 1.��ʵ��ɫ
 * 2.�����ɫ
 * @author �ƽ���
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();

        //new Thread(�̶߳���).start();
    }
}

interface Marry{
    void happyMarry();
}

/**
 * ��ʵ��ɫ
 */
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("�϶����ڱ����ˡ�����");
    }
}

/**
 * �����ɫ
 */
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("��������ҹ������");
    }

    private void ready() {
        System.out.println("�����·���������");
    }
}
