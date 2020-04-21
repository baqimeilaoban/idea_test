package thread.thread03;

/**
 * 死锁：过多的同步可能造成相互不释放资源，从而相互等待，一般发生于同步中持有多个对象的锁
 * 避免：不要在同一个代码块中，同时持有多个对象的锁
 * @author 黄建波
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(1,"张柏芝");
        Makeup g2 = new Makeup(0,"王菲");
        g1.start();
        g2.start();
    }
}

/**
 * 口红
 */
class Lipstick{

}

/**
 * 镜子
 */
class Mirror{

}

/**
 * 化妆
 */
class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    /**
     * 选择
     */
    int choice;
    /**
     * 名字
     */
    String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice==0){
            //获得口红的锁
            synchronized (lipstick){
                System.out.println(this.girl + "涂口红");
                //1秒后想拥有镜子的锁
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                /*synchronized (mirror){
                    System.out.println(this.girl + "照镜子");
                }*/
            }
            synchronized (mirror){
                System.out.println(this.girl + "照镜子");
            }
        }else {
            //获得镜子的锁
            synchronized (mirror){
                System.out.println(this.girl + "照镜子");
                //2秒后想拥有口红的锁
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*synchronized (lipstick){
                    System.out.println(this.girl + "涂口红");
                }*/
            }
            synchronized (lipstick){
                System.out.println(this.girl + "涂口红");
            }
        }
    }
}
