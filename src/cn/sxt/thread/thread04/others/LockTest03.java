package cn.sxt.thread.thread04.others;

/**
 * ������������������ʹ�� + ������
 * @author �ƽ���
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
     * ��������
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
 * ����������
 */
class ReLock{
    /**
     * �Ƿ�ռ��
     */
    private boolean isLocked = false;
    /**
     * �洢�߳�
     */
    private Thread lockBy = null;
    private int holdCount = 0;

    /**
     * ʹ����
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
     * �ͷ���
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

