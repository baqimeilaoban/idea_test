package thread.thread04.others;

/**
 * volatile���ڱ�֤���ݵ�ͬ����Ҳ���ǿɼ���
 * @author �ƽ���
 */
public class VolatileTest {
    private volatile static int num = 0;

    public static void main(String[] args) throws InterruptedException {
        new Thread(()->{
            while (num==0){
                //�˴�����Ҫ����
            }
        }).start();

        Thread.sleep(1000);
        num = 1;
    }
}
