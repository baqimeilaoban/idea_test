package cn.sxt.thread.thread03;

import java.util.concurrent.CopyOnWriteArrayList;

/**
 * �̰߳�ȫ��������������
 * @author �ƽ���
 */
public class SynContainer {
    public static void main(String[] args) {
        CopyOnWriteArrayList<String> list = new CopyOnWriteArrayList<>();
        for (int i=0; i<10000; i++){
            new Thread(()->{
                list.add(Thread.currentThread().getName());
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
