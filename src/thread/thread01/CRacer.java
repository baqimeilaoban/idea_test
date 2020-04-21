package thread.thread01;

import java.util.concurrent.*;

/**
 * ģ���������
 * @author �ƽ���
 */
public class CRacer implements Callable {
    private String winner;

    @Override
    public Integer call() throws Exception {
        for (int steps = 1;steps <= 100; steps++){
            //ģ����Ϣ
            if (Thread.currentThread().getName().equals("pool-1-thread-1") && steps%10==0){
                Thread.sleep(100);
            }
            System.out.println(Thread.currentThread().getName()+"--->" + steps);
            //�����Ƿ����
            boolean flag = gameOver(steps);
            if (flag){
                return steps;
            }
        }
        return null;
    }

    private boolean gameOver(int steps) {
        //����ʤ����
        if (winner!=null){
            return true;
        }else {
            if (steps==100){
                winner=Thread.currentThread().getName();
                System.out.println("winner==>" + winner);
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) throws ExecutionException, InterruptedException {
        CRacer racer = new CRacer();
        //����ִ�з���
        ExecutorService service = Executors.newFixedThreadPool(2);
        //�ύִ��
        Future<Integer> result1 = service.submit(racer);
        Future<Integer> result2 = service.submit(racer);
        //��ȡ���
        Integer r1 = result1.get();
        Integer r2 = result2.get();
        System.out.println(r1 + "--->" + r2);
        //�رշ���
        service.shutdownNow();
    }
}
