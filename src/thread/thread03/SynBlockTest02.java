package thread.thread03;

import java.util.ArrayList;
import java.util.List;

/**
 * @author thinkpad
 */
public class SynBlockTest02 {
    public static void main(String[] args) {
        List<String> list = new ArrayList<String>();
        for (int i=0; i<10000; i++){
            new Thread(()->{
                //Í¬²½¿é
                synchronized (list){
                    list.add(Thread.currentThread().getName());
                }
            }).start();
        }
        try {
            Thread.sleep(10000);
        } catch (InterruptedException e) {
            e.printStackTrace();
        }
        System.out.println(list.size());
    }
}
