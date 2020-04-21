package thread.thread04.others;

import java.util.concurrent.atomic.AtomicInteger;

/**
 * CAS���Ƚϲ�����
 * @author �ƽ���
 */
public class CAS {
    /**
     * ���
     */
    private static AtomicInteger stock = new AtomicInteger(5);

    public static void main(String[] args) {
        for (int i=0; i<5; i++){
            new Thread(()->{
                try {
                    //ģ��������ʱ
                    Thread.sleep(1000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                Integer left = stock.decrementAndGet();
                if (left<1){
                    System.out.println("�����ˡ�����");
                    return;
                }
                System.out.print(Thread.currentThread().getName() + "����һ����Ʒ");
                System.out.println("-->��ʣ" + left);
            }).start();
        }
    }

}
