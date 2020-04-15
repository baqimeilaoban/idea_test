package cn.sxt.thread.thread03;

/**
 * 线程不安全：数据有负数、相同
 * @author 黄建波
 */
public class SynBlockTest03 {
    public static void main(String[] args) {
        //一份资源
        SynWeb12306 web = new SynWeb12306();
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"蚂蝗").start();
    }
}

class SynWeb12306 implements Runnable{
    private int tikerNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test5();
        }
    }

    /**
     * 尽可能锁定合理的范围（不是指代码 指数据的完整性）
     * double checking
     */
    public void test5(){
        //考虑没票的情况
        if (tikerNums<=0){
            flag = false;
            return;
        }
        synchronized (this) {
            //考虑最后的一张票
            if (tikerNums<=0){
                flag = true;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * 线程不安全 范围太小锁不住
     */
    public void test4(){
        synchronized (this) {
            if (tikerNums < 0) {
                flag = false;
                return;
            }
        }
        //模拟延时
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
    /**
     * 线程不安全 锁定失败 ticketNums对象在变
     */
    public void test3(){
        synchronized ((Integer)tikerNums) {
            if (tikerNums < 0) {
                flag = false;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * 线程安全 范围太大-->效率低下
     */
    public void test2(){
        synchronized (this) {
            if (tikerNums <= 0) {
                flag = false;
                return;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * 线程安全 同步
     */
    public synchronized void test1(){
        if (tikerNums<=0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
}