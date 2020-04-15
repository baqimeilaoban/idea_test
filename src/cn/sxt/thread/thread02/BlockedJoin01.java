package cn.sxt.thread.thread02;

/**
 * join：合并线程，插队线程
 * @author 黄建波
 */
public class BlockedJoin01 {
    public static void main(String[] args) throws InterruptedException {
        Thread t = new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("lambda..." + i);
            }
        });
        t.start();

        for (int i=0; i<100; i++){
            if (i==20){
                //插队，main被阻塞了
                t.join();
            }
            System.out.println("main..." + i);
        }
    }
}
