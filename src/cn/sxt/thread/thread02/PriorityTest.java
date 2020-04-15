package cn.sxt.thread.thread02;

/**
 * 1��NORM_PRIORITY  5 Ĭ��
 * 2��MIN_PRIORITY   1
 * 3��MAX_PRIORITY  10
 * ���ʣ���������Ե��Ⱥ�˳��
 * @author �ƽ���
 */
public class PriorityTest {
    public static void main(String[] args) {
        System.out.println(Thread.currentThread().getPriority());
        MyProiority my = new MyProiority();

        Thread t1 = new Thread(my,"adidas");
        Thread t2 = new Thread(my,"NIKE");
        Thread t3 = new Thread(my,"����");
        Thread t4 = new Thread(my,"����");
        Thread t5 = new Thread(my,"˫��");
        Thread t6 = new Thread(my,"puma");

        //�������ȼ�������ǰ
        t1.setPriority(10);
        t2.setPriority(Thread.MAX_PRIORITY);
        t3.setPriority(Thread.MAX_PRIORITY);
        t4.setPriority(Thread.MIN_PRIORITY);
        t5.setPriority(Thread.MIN_PRIORITY);
        t6.setPriority(Thread.MIN_PRIORITY);

        t1.start();
        t2.start();
        t3.start();
        t4.start();
        t5.start();
        t6.start();
    }
}

class MyProiority implements Runnable{
    @Override
    public void run() {
        System.out.println(Thread.currentThread().getName() + "-->" + Thread.currentThread().getPriority());
        Thread.yield();
    }
}