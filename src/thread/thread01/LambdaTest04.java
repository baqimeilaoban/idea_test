package thread.thread01;

/**
 * Lambda推导
 * @author 黄建波
 */
public class LambdaTest04 {
    public static void main(String[] args) {
        new Thread(()->{
            for (int i=0; i<100; i++){
                System.out.println("一边学习lambda");
            }
        }).start();

        new Thread(()-> System.out.println("一边学习崩溃")).start();
    }
}
