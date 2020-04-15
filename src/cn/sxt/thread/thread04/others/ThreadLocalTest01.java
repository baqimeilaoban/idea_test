package cn.sxt.thread.thread04.others;

/**
 * ThreadLocal：每个线程自身的存储本地、局部区域
 * get/set/initialValue
 * @author 黄建波
 */
public class ThreadLocalTest01 {
    private static ThreadLocal<Integer> threadLocal = ThreadLocal.withInitial(()->200);

    public static void main(String[] args) {
        //获取值
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        //设置值
        threadLocal.set(99);
        System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());

        new Thread(new MyRun()).start();
        new Thread(new MyRun()).start();
    }

    public static class MyRun implements Runnable{
        @Override
        public void run() {
            threadLocal.set((int)(Math.random()*99));
            System.out.println(Thread.currentThread().getName() + "-->" + threadLocal.get());
        }
    }
}

