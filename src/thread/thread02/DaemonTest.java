package thread.thread02;

/**
 * 守护线程：是为用户线程服务的；jvm停止不用等待守护线程执行完毕
 * 默认:用户线程 jvm等待用户线程执行完毕才会停止
 * @author 黄建波
 */
public class DaemonTest {
    public static void main(String[] args) {
        God god = new God();
        You you = new You();
        Thread t =new Thread(god);
        //将用户线程调整为守护
        t.setDaemon(true);
        t.start();
        new Thread(you).start();
    }
}

class You implements Runnable{
    @Override
    public void run() {
        for (int i=0; i<=365*100; i++){
            System.out.println("happy life...");
        }
        System.out.println("ooo...");
    }
}

class God implements Runnable{
    @Override
    public void run() {
        for (;true;){
            System.out.println("bless you...");
        }
    }
}
