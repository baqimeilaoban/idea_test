package cn.sxt.thread.thread03;

/**
 * ����ӰԺ
 * @author �ƽ���
 */
public class HappyCinema01 {
    public static void main(String[] args) {
        Cinema c = new Cinema(2,"happy sxt");
        new Thread(new Customer(c,2),"�ϸ�").start();
        new Thread(new Customer(c,1),"����").start();
    }
}

/**
 * �˿�
 */
class Customer implements Runnable{
    Cinema cinema;
    int seats;

    public Customer(Cinema cinema, int seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
        //����ӰԺ
        synchronized (cinema){
            boolean flag = cinema.bookTickets(seats);
            if (flag){
                System.out.println("��Ʊ�ɹ�" + Thread.currentThread().getName() + "->λ��Ϊ" + seats);
            }else {
                System.out.println("��Ʊʧ��" + Thread.currentThread().getName() + "->λ�ò���");
            }
        }
    }
}

/**
 * ӰԺ
 */
class Cinema{
    /**
     * ����λ��
     */
    int available;
    /**
     * ����
     */
    String name;

    /**
     * ��Ʊ
     * @param available ����λ��
     * @param name ����
     */
    public Cinema(int available, String name) {
        this.available = available;
        this.name = name;
    }

    public boolean bookTickets(int seats){
        System.out.println("����λ��Ϊ��" + available);
        if (seats>available){
            return false;
        }
        available -= seats;
        return true;
    }
}