package thread.thread03;

/**
 * �����������ͬ����������໥���ͷ���Դ���Ӷ��໥�ȴ���һ�㷢����ͬ���г��ж���������
 * ���⣺��Ҫ��ͬһ��������У�ͬʱ���ж���������
 * @author �ƽ���
 */
public class DeadLock {
    public static void main(String[] args) {
        Makeup g1 = new Makeup(1,"�Ű�֥");
        Makeup g2 = new Makeup(0,"����");
        g1.start();
        g2.start();
    }
}

/**
 * �ں�
 */
class Lipstick{

}

/**
 * ����
 */
class Mirror{

}

/**
 * ��ױ
 */
class Makeup extends Thread{
    static Lipstick lipstick = new Lipstick();
    static Mirror mirror = new Mirror();
    /**
     * ѡ��
     */
    int choice;
    /**
     * ����
     */
    String girl;

    public Makeup(int choice, String girl) {
        this.choice = choice;
        this.girl = girl;
    }

    @Override
    public void run() {
        makeup();
    }

    private void makeup() {
        if (choice==0){
            //��ÿں����
            synchronized (lipstick){
                System.out.println(this.girl + "Ϳ�ں�");
                //1�����ӵ�о��ӵ���
                try {
                    Thread.sleep(1000);
                }catch (InterruptedException e){
                    e.printStackTrace();
                }
                /*synchronized (mirror){
                    System.out.println(this.girl + "�վ���");
                }*/
            }
            synchronized (mirror){
                System.out.println(this.girl + "�վ���");
            }
        }else {
            //��þ��ӵ���
            synchronized (mirror){
                System.out.println(this.girl + "�վ���");
                //2�����ӵ�пں����
                try {
                    Thread.sleep(3000);
                } catch (InterruptedException e) {
                    e.printStackTrace();
                }
                /*synchronized (lipstick){
                    System.out.println(this.girl + "Ϳ�ں�");
                }*/
            }
            synchronized (lipstick){
                System.out.println(this.girl + "Ϳ�ں�");
            }
        }
    }
}
