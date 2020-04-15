package cn.sxt.thread.thread04.others;

/**
 * InheritableThreadLocal:�̳������� ���������� ������һ�ݸ����߳�
 * @author �ƽ���
 */
public class ThreadLocalTest04 {
    private static ThreadLocal<Integer> threadLocal = new InheritableThreadLocal<>();

    public static void main(String[] args) {
        threadLocal.set(2);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        //�߳���main�߳̿���
        new Thread(()->{
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
            threadLocal.set(200);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }).start();
    }
}
