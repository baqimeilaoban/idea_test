package thread.thread03;

/**
 * �̲߳���ȫ�������и�������ͬ
 * @author �ƽ���
 */
public class UnsafeTest01 {
    public static void main(String[] args) {
        //һ����Դ
        UnsafeWeb12306 web = new UnsafeWeb12306();
        //�������
        new Thread(web,"����").start();
        new Thread(web,"��ũ").start();
        new Thread(web,"���").start();
    }
}

class UnsafeWeb12306 implements Runnable{
    private int tikerNums = 10;
    private boolean flag = true;
    @Override
    public void run() {
        while (flag){
            test();
        }
    }

    public void test(){
        if (tikerNums<0){
            flag = false;
            return;
        }
        //ģ����ʱ
        try {
            Thread.sleep(100);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        System.out.println(Thread.currentThread().getName() + "-->" + tikerNums--);
    }
}