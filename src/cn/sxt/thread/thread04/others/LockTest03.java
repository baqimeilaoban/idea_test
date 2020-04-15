package cn.sxt.thread.thread04.others;

/**
 * 重入锁：锁可以延续使用 + 计数器
 * @author 黄建波
 */
public class LockTest03 {
    ReLock lock = new ReLock();
    public void a() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        doSomething();
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }

    /**
     * 不可重入
     * @throws InterruptedException
     */
    public void doSomething() throws InterruptedException {
        lock.lock();
        System.out.println(lock.getHoldCount());
        //...........
        lock.unlock();
        System.out.println(lock.getHoldCount());
    }
    public static void main(String[] args) throws InterruptedException {
        LockTest03 test = new LockTest03();
        test.a();
        Thread.sleep(1000);
        System.out.println(test.lock.getHoldCount());
    }
}

/**
 * 不可重入锁
 */
class ReLock{
    /**
     * 是否占用
     */
    private boolean isLocked = false;
    /**
     * 存储线程
     */
    private Thread lockBy = null;
    private int holdCount = 0;

    /**
     * 使用锁
     * @throws InterruptedException
     */
    public synchronized void lock() throws InterruptedException {
        Thread t = Thread.currentThread();
        while (isLocked && lockBy!=t){
            wait();
        }
        isLocked = true;
        lockBy = t;
        holdCount++;
    }

    /**
     * 释放锁
     */
    public synchronized void unlock() {
        if (Thread.currentThread() == lockBy) {
            holdCount--;
            if (holdCount == 0) {
                isLocked = false;
                notify();
            }
        }
    }

    public int getHoldCount() {
        return holdCount;
    }
}

