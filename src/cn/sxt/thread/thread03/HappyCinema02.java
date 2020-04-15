package cn.sxt.thread.thread03;

import java.util.ArrayList;
import java.util.List;

/**
 * ����ӰԺ
 * @author �ƽ���
 */
public class HappyCinema02 {
    public static void main(String[] args) {
        //����λ��
        List<Integer> available = new ArrayList<Integer>();
        available.add(1);
        available.add(2);
        available.add(3);
        available.add(6);
        available.add(7);

        //�˿���Ҫ��λ��
        List<Integer> seats1 = new ArrayList<>();
        seats1.add(1);
        seats1.add(2);
        List<Integer> seats2 = new ArrayList<>();
        seats2.add(6);
        seats2.add(7);

        SxtCinema c = new SxtCinema(available,"Happy sxt");
        new Thread(new HappyCustomer(c,seats1),"�ϸ�").start();
        new Thread(new HappyCustomer(c,seats2),"����").start();
    }
}

/**
 * ӰԺ
 */
class SxtCinema{
    /**
     * ����λ��
     */
    List<Integer> available;
    /**
     * ����
     */
    String name;

    public SxtCinema(List<Integer> available, String name) {
        this.available = available;
        this.name = name;
    }

    /**
     * ��Ʊ
     * @param seats Ԥ����λ��
     * @return λ���Ƿ����
     */
    public boolean bookTickets(List<Integer> seats){
        System.out.println("��ӭ����" + this.name + ",��ǰ����λ��Ϊ��" + available);
        List<Integer> copy = new ArrayList<Integer>();
        copy.addAll(available);

        //���
        copy.removeAll(seats);
        //�жϴ�С
        if (available.size()-copy.size() != seats.size()){
            return false;
        }
        //�ɹ�
        available = copy;
        return true;
    }
}

/**
 * �˿�
 */
class HappyCustomer implements Runnable{
    SxtCinema cinema;
    List<Integer> seats;

    public HappyCustomer(SxtCinema cinema, List<Integer> seats) {
        this.cinema = cinema;
        this.seats = seats;
    }

    @Override
    public void run() {
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
