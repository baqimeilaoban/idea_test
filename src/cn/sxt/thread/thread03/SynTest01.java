package cn.sxt.thread.thread03;

/**
 * 线程安全：在并发时保证数据的正确性、效率尽可能高
 * synchronized
 * 1.同步方法
 * 2.同步块
 * @author 黄建波
 */
public class SynTest01 {
    public static void main(String[] args) {
        //一份资源
        SafeWeb12306 web = new SafeWeb12306();
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"蚂蝗").start();
    }
}

class SafeWeb12306 implements Runnable{
    private int ticketNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
            //模拟延时
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
    }

    /**
     * 线程安全，同步
     */
    public synchronized void test(){
        if (ticketNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
    }
}
