package thread.thread02;

/**
 * sleep模拟网络延时，放大发生问题的可能性
 * @author 黄建波
 */
public class BlockedSleep01 {
    public static void main(String[] args) {
        //一份资源
        Web12306 web = new Web12306();
        System.out.println(Thread.currentThread().getName());
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"蚂蝗").start();
    }
}

class Web12306 implements Runnable{
    /**
     * 票数
     */
    private int ticketNums = 99;

    @Override
    public void run() {
        while (true){
            if (ticketNums<0){
                break;
            }
            //模拟延时
            try {
                Thread.sleep(100);
            }catch (InterruptedException e){
                e.printStackTrace();
            }
            System.out.println(Thread.currentThread().getName() + "-->" + ticketNums--);
        }
    }
}
