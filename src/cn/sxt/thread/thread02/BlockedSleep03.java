package cn.sxt.thread.thread02;

import java.text.SimpleDateFormat;
import java.util.Date;

/**
 * sleepģ�⵹��ʱ
 * @author �ƽ���
 */
public class BlockedSleep03 {
    public static void main(String[] args) throws InterruptedException {
        //����ʱ
        Date endTime = new Date(System.currentTimeMillis()+1000*10);
        long end = endTime.getTime();
        while (true){
            System.out.println(new SimpleDateFormat("mm:ss").format(endTime));
            Thread.sleep(1000);
            endTime = new Date(endTime.getTime()-1000);
            if (end-10000 > endTime.getTime()){
                break;
            }
        }
    }

    public static void test() throws InterruptedException {
        //����ʮ������һ��һ��
        int num = 10;
        while (true){
            Thread.sleep(1000);
            System.out.println(num--);
            if (num < 0){
                break;
            }
        }
    }
}

