package thread.thread04.cooperation;

/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽ�����źŵƷ�
 * ������־λ
 * @author �ƽ���
 */
public class CoTest02 {
    public static void main(String[] args) {
        Tv tv = new Tv();
        new Player(tv).start();
        new Watcher(tv).start();
    }
}

/**
 * ������ ��Ա
 */
class Player extends Thread{
    Tv tv;

    public Player(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            if (i%2==0){
                this.tv.play("����˵");
            }else {
                this.tv.play("̫���ˣ���ƿ����ϴϴ��");
            }
        }
    }
}

/**
 * ������ ����
 */
class Watcher extends Thread{
    Tv tv;

    public Watcher(Tv tv) {
        this.tv = tv;
    }

    @Override
    public void run() {
        for (int i=0; i<20; i++){
            tv.watch();
        }
    }
}
/**
 * ͬһ����Դ ����
 */
class Tv{
    String voice;
    /**
     * �źŵ� T��ʾ��Ա���� ���ڵȴ� F��ʾ���ڹۿ� ��Ա�ȴ�
     */
    boolean flag = true;

    /**
     * ����
     */
    public synchronized void play(String voice){
        //��Ա�ȴ�
        if (!flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //����
        System.out.println("�����ˣ�" + voice);
        this.voice = voice;
        //����
        this.notifyAll();
        //�л���־
        this.flag = !this.flag;
    }

    /**
     * �ۿ�
     */
    public synchronized void watch(){
        //���ڵȴ�
        if (flag){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //�ۿ�
        System.out.println("�����ˣ�" + voice);
        //����
        this.notifyAll();
        //�л���־
        this.flag = !this.flag;
    }

}