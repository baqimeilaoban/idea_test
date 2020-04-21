package thread.thread03;

/**
 * 线程不安全：数据有负数、相同
 * @author 黄建波
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        //一份资源
        UnsafeWeb12306 web = new UnsafeWeb12306();
        //多个代理
        new Thread(web,"码畜").start();
        new Thread(web,"码农").start();
        new Thread(web,"蚂蝗").start();
    }
}

class UnsafeWeb12306 implements Runnable{
    private int tikerNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }

    public void test(){
        if (tikerNums<0){
            flag = false;
            return;
        }
        //模拟延时
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
}