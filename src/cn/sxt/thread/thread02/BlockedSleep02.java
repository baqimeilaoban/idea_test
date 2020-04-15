package cn.sxt.thread.thread02;

/**
 * sleepģ����Ϣ
 * @author �ƽ���
 */
public class BlockedSleep02 {
    public static void main(String[] args) {
        Racer racer = new Racer();
        new Thread(racer,"tortoise").start();
        new Thread(racer,"rabbit").start();
    }
}

class Racer implements Runnable{
    private String winner;

    @Override
    public void run() {
        for (int steps=1; steps<=100; steps++){
            //ģ����Ϣ
            if (Thread.currentThread().getName().equals("rabbit") && steps%10==0){
                try {
                    Thread.sleep(100);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
            }
            System.out.println(Thread.currentThread().getName() + "-->" + steps);
            //�����Ƿ����
            boolean flag = gameOver(steps);
            if (flag){
                break;
            }
        }
    }

    private boolean gameOver(int steps) {
        if (winner != null){
            return true;
        }else {
            if (steps == 100) {
                winner = Thread.currentThread().getName();
                System.out.println("winner==>" + winner);
                return true;
            }
        }
        return false;
    }
}