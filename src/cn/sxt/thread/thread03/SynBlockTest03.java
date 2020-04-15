package cn.sxt.thread.thread03;

/**
 * �̲߳���ȫ�������и�������ͬ
 * @author �ƽ���
 */
public class SynBlockTest03 {
    public static void main(String[] args) {
        //һ����Դ
        SynWeb12306 web = new SynWeb12306();
        //�������
        new Thread(web,"����").start();
        new Thread(web,"��ũ").start();
        new Thread(web,"���").start();
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
     * ��������������ķ�Χ������ָ���� ָ���ݵ������ԣ�
     * double checking
     */
    public void test5(){
        //����ûƱ�����
        if (tikerNums<=0){
            flag = false;
            return;
        }
        synchronized (this) {
            //��������һ��Ʊ
            if (tikerNums<=0){
                flag = true;
                return;
            }
            //ģ����ʱ
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * �̲߳���ȫ ��Χ̫С����ס
     */
    public void test4(){
        synchronized (this) {
            if (tikerNums < 0) {
                flag = false;
                return;
            }
        }
        //ģ����ʱ
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
    /**
     * �̲߳���ȫ ����ʧ�� ticketNums�����ڱ�
     */
    public void test3(){
        synchronized ((Integer)tikerNums) {
            if (tikerNums < 0) {
                flag = false;
                return;
            }
            //ģ����ʱ
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * �̰߳�ȫ ��Χ̫��-->Ч�ʵ���
     */
    public void test2(){
        synchronized (this) {
            if (tikerNums <= 0) {
                flag = false;
                return;
            }
            //ģ����ʱ
            try {
                Thread.sleep(100);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
        }
    }
    /**
     * �̰߳�ȫ ͬ��
     */
    public synchronized void test1(){
        if (tikerNums<=0){
            flag = false;
            return;
        }
        //ģ����ʱ
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
}