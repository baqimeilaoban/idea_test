package thread.thread02;

/**
 * ��������
 * isAlive:�߳��Ƿ񻹻���
 * Thread.currentThread():��ǰ�߳�
 * setName��getName:��������
 * ����Գ����˹��˹
 * @author �ƽ���
 */
public class InfoTest {
    public static void main(String[] args) throws InterruptedException {
        System.out.println(Thread.currentThread().isAlive());
        //�������ƣ���ʵ��ɫ+�����ɫ
        MyInfo info = new MyInfo("ս����");
        Thread t = new Thread(info);
        t.setName("����");
        t.start();
        Thread.sleep(1000);
        System.out.println(t.isAlive());
    }
}

class MyInfo implements Runnable{
    private String name;

    public MyInfo(String name) {
        this.name = name;
    }

    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + name);
    }
}
