package thread.thread02;

/**
 * sleepģ��������ʱ���Ŵ�������Ŀ�����
 * @author �ƽ���
 */
public class BlockedSleep01 {
    public static void main(String[] args) {
        //һ����Դ
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //�������
        new Thread(web,"����").start();
        new Thread(web,"��ũ").start();
        new Thread(web,"���").start();
    }
}

class Web12306 implements Runnable{
    /**
     * Ʊ��
     */
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true){
            if (ticketNums<0){
                break;
            }
            //ģ����ʱ
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }
}
