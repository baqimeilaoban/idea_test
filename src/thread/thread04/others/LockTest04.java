package thread.thread04.others;

import java.util.concurrent.locks.ReentrantLock;

/**
 * 可重入锁：锁可以延续使用 + 计数器
 * @author 黄建波
 */
public class LockTest04 {
    final ReentrantLock lock = new ReentrantLock();
    public void a(){
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public void doSomething(){
        lock.lock();
        System.out.println(lock.getHoldCount());
        //.............
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    public static void main(String[] args) throws InterruptedException {
        LockTest04 test = new LockTest04();
        test.a();
        Thread.sleep(1000);
        System.out.println(test.lock.getHoldCount());
    }
}
