package cn.sxt.thread.thread02;

/**
 * ¹Û²ìÏß³Ì×´Ì¬
 * @author »Æ½¨²¨
 */
public class AllState {
    public static void main(String[] args) {
        Thread t = new Thread(()->{
            for (int i=0; i<5; i++){
                try {
                    Thread.sleep(100);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
            }
            System.out.println("...");
        });
        //¹Û²ì×´Ì¬
        Thread.State state = t.getState();
        //NEW
        System.out.println(state);

        t.start();
        //RUNNABLE
        state = t.getState();
        System.out.println(state);

//        while (state != Thread.State.TERMINATED){
//            try {
//                Thread.sleep(200);
//            }catch (InterruptedException e){
//                e.printStackTrace();
//            }
//            //TIMED_WAITING
//            state = t.getState();
//            System.out.println(state);
//        }

        while (true){
            int num = Thread.activeCount();
            System.out.println(num);
            if (num == 2){
                break;
            }
            try {
                Thread.sleep(200);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            state = t.getState();
            System.out.println(state);
        }
    }
}
