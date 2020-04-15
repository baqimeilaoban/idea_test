package cn.sxt.thread.thread02;

/**
 * join:�ϲ��̣߳�����߳�
 * @author �ƽ���
 */
public class BlockedJoin02 {
    public static void main(String[] args) {
        System.out.println("�ְֺͶ������̵Ĺ���");
        new Thread(new Father()).start();
    }
}

class Father extends Thread{
    @Override
    public void run() {
        System.out.println("����̣�����û��");
        System.out.println("�ö���ȥ���л�");
        Thread t = new Thread(new Son());
        t.start();
        try {
            t.join();
            System.out.println("�ϰֽӹ�Ǯ������Ǯ���˶���");
        } catch (InterruptedException e) {
            e.printStackTrace();
            System.out.println("�����߶��ˣ��ϰֳ�ȥ�Һ��ӡ�����");
        }
    }
}

class Son extends Thread{
    @Override
    public void run() {
        System.out.println("�ӹ��ϰֵ�Ǯ��ȥ�ˡ�����");
        System.out.println("·���и���Ϸ��������10����");
        for (int i=1; i<=10; i++){
            System.out.println(i + "���ȥ�ˡ�����");
            try {
                Thread.sleep(1000);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        System.out.println("�Ͻ�����ȥ������");
        System.out.println("����һ���л��ؼ��ˡ�����");
    }
}