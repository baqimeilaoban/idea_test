package cn.sxt.thread.thread03;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author �ƽ���
 */
public class SynTest01 {
    public static void main(String[] args) {
        //һ����Դ
        SafeWeb12306 web = new SafeWeb12306();
        //�������
        new Thread(web,"����").start();
        new Thread(web,"��ũ").start();
        new Thread(web,"���").start();
    }
}

class SafeWeb12306 implements Runnable{
    private int ticketNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
            //ģ����ʱ
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * �̰߳�ȫ��ͬ��
     */
    public synchronized void test(){
        if (ticketNums<=0){
            flag = false;
            return;
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
