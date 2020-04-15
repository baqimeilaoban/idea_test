package cn.sxt.thread.thread04.others;

/**
 * ThreadLocal������������ ����
 * @author �ƽ���
 */
public class ThreadLocalTest03 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->1);
    public static void main(String[] args) {
        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        public MyRun(){
            threadLocal.set(-100);
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
        @Override
        public void run() {
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
}
