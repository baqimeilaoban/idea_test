package thread.thread04.cooperation;

/**
 * 协作模型：生产者消费者实现方式一：管程法
 * 借助缓冲区
 * @author 黄建波
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

/**
 * 生产者
 */
class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //生产
        for (int i=0; i<100; i++){
            System.out.println("生产-->" + i + "个馒头");
            container.push(new Steambun(i));
        }
    }
}

/**
 * 消费者
 */
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //消费
        for (int i=0; i<100; i++){
            System.out.println("消费-->" + container.pop().id + "个馒头");
        }
    }
}

/**
 * 缓冲区
 */
class SynContainer{
    /**
     * 存储容器
     */
    Steambun[] buns = new Steambun[10];
    /**
     * 计数器
     */
    int count = 0;

    /**
     * 存储 生产
     * @param bun 存储容器
     */
    public synchronized void push(Steambun bun){
        //何时能生产 容器存在空间 不能生产 只有等待
        if (count == buns.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //存在空间 可以生产
        buns[count] = bun;
        count++;
        //存在数据了 可以通知消费了
        this.notifyAll();
    }

    /**
     * 获取消费
     * @return 结果
     */
    public synchronized Steambun pop(){
        //何时消费 容器中是否存在数据 没有数据 只有等待
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //存在数据可以消费
        count--;
        Steambun bun = buns[count];
        //存在空间了，可以唤醒对方生产了
        this.notifyAll();
        return bun;
    }

}

/**
 * 馒头
 */
class Steambun{
    int id;

    public Steambun(int id) {
        this.id = id;
    }
}
