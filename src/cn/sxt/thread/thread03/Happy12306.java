package cn.sxt.thread.thread03;

/**
 * 快乐火车票
 * @author 黄建波
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(2,"Happy 12306");
        new Passenger(c,"老高",2).start();
        new Passenger(c,"老裴",1).start();
    }
}

/**
 * 火车票官网
 */
class Web12306 implements Runnable{
    /**
     * 可用位置
     */
    int available;

    /**
     * 名称
     */
    String name;

    public Web12306(int available, String name) {
        this.available = available;
        this.name = name;
    }

    @Override
    public void run() {
        Passenger p = (Passenger)Thread.currentThread();
        boolean flag = this.bookTickets(p.seats);
        if (flag){
            System.out.println("出票成功" + Thread.currentThread().getName() + "-->位置为：" + p.seats);
        }else {
            System.out.println("出票失败" + Thread.currentThread().getName() + "-->位置不够");
        }
    }

    private synchronized boolean bookTickets(int seats) {
        System.out.println("可用位置为：" + available);
        if (seats>available){
            return false;
        }
        available -= seats;
        return true;
    }
}

/**
 * 顾客
 */
class Passenger extends Thread{
    int seats;

    public Passenger(Runnable target,String name,int seats) {
        super(target,name);
        this.seats = seats;
    }
}