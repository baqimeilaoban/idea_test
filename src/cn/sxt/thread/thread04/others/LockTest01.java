package cn.sxt.thread.thread04.others;

/**
 * �����������������ظ�ʹ��
 * @author �ƽ���
 */
public class LockTest01 {
    public static void main(String[] args) {
        new LockTest01().test();
    }

    public void test(){
        //��һ�λ����
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
