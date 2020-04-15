package cn.sxt.thread.thread04.others;

/**
 * 可重入锁：锁可以重复使用
 * @author 黄建波
 */
public class LockTest01 {
    public static void main(String[] args) {
        new LockTest01().test();
    }

    public void test(){
        //第一次获得锁
        synchronized (this){
            while (true){
                synchronized (this){
                    System.out.println("ReentrantLock!");
                }
                try {
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
