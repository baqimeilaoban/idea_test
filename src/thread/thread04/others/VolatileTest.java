package thread.thread04.others;

/**
 * volatile用于保证数据的同步，也就是可见性
 * @author 黄建波
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){
                //此处不需要代码
            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }
}
