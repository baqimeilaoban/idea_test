package cn.designpattern.singleton;

import java.util.concurrent.CountDownLatch;

/**
 * �������ִ�������ģʽ��Ч��
 * @author hjb
 */
public class Client03 {
    public static void main(String[] args) throws Exception {
        long start = System.currentTimeMillis();
        int threadNum = 10;
        final CountDownLatch countDownLatch = new CountDownLatch(threadNum);
        for (int i = 0; i < 10; i++) {
            new Thread(new Runnable() {
                @Override
                public void run() {
                    for (int i = 0; i < 100000; i++) {
                        Object o = SingletonDemo04.getInstance();
                    }
                    countDownLatch.countDown();
                }
            }).start();
        }
        //main�߳�������ֱ����������Ϊ0���Ż��������ִ��
        countDownLatch.await();
        long end = System.currentTimeMillis();
        System.out.println("�ܺ�ʱ��" + (end-start));
    }
}
