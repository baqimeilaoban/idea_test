package cn.sxt.thread.thread03;

/**
 * ���ֻ�Ʊ
 * @author �ƽ���
 */
public class Happy12306 {
    public static void main(String[] args) {
        Web12306 c = new Web12306(2,"Happy 12306");
        new Passenger(c,"�ϸ�",2).start();
        new Passenger(c,"����",1).start();
    }
}

/**
 * ��Ʊ����
 */
class Web12306 implements Runnable{
    /**
     * ����λ��
     */
    int available;

    /**
     * ����
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
            System.out.println("��Ʊ�ɹ�" + Thread.currentThread().getName() + "-->λ��Ϊ��" + p.seats);
        }else {
            System.out.println("��Ʊʧ��" + Thread.currentThread().getName() + "-->λ�ò���");
        }
    }

    private synchronized boolean bookTickets(int seats) {
        System.out.println("����λ��Ϊ��" + available);
        if (seats>available){
            return false;
        }
        available -= seats;
        return true;
    }
}

/**
 * �˿�
 */
class Passenger extends Thread{
    int seats;

    public Passenger(Runnable target,String name,int seats) {
        super(target,name);
        this.seats = seats;
    }
}