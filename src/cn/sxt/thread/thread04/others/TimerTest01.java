package cn.sxt.thread.thread04.others;

import java.util.Calendar;
import java.util.GregorianCalendar;
import java.util.Timer;
import java.util.TimerTask;

/**
 * �������: Timer ��TimerTask��
 * @author �ƽ���
 *
 */
public class TimerTest01 {
    public static void main(String[] args) {
        Timer timer = new Timer();
        //ִ�а���
        //timer.schedule(new MyTask(),1000); //ִ������һ��
        //timer.schedule(new MyTask(),1000,200);
        Calendar cal = new GregorianCalendar(2099,12,31,21,53,54);
        //ָ��ʱ��
        timer.schedule(new MyTask(),cal.getTime(),200);
    }
}

/**
 * ������
 */
class MyTask extends TimerTask{
    @Override
    public void run() {
        for (int i=0; i<10; i++){
            System.out.println("�ſմ�����Ϣһ���");
        }
        System.out.println("----------end------------");
    }
}
