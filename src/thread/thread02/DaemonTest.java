package thread.thread02;

/**
 * �ػ��̣߳���Ϊ�û��̷߳���ģ�jvmֹͣ���õȴ��ػ��߳�ִ�����
 * Ĭ��:�û��߳� jvm�ȴ��û��߳�ִ����ϲŻ�ֹͣ
 * @author �ƽ���
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t =new Thread(god);
        //���û��̵߳���Ϊ�ػ�
        t.setDaemon(true);
        t.start();
        new Thread(you).start();
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<=365*100; i++){
            System.out.println("happy life...");
        }
        System.out.println("ooo...");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("bless you...");
        }
    }
}
