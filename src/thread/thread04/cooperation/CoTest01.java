package thread.thread04.cooperation;

/**
 * Э��ģ�ͣ�������������ʵ�ַ�ʽһ���̷ܳ�
 * ����������
 * @author �ƽ���
 */
public class CoTest01 {
    public static void main(String[] args) {
        SynContainer container = new SynContainer();
        new Producer(container).start();
        new Consumer(container).start();
    }
}

/**
 * ������
 */
class Producer extends Thread{
    SynContainer container;

    public Producer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //����
        for (int i=0; i<100; i++){
            System.out.println("����-->" + i + "����ͷ");
            container.push(new Steambun(i));
        }
    }
}

/**
 * ������
 */
class Consumer extends Thread{
    SynContainer container;

    public Consumer(SynContainer container) {
        this.container = container;
    }

    @Override
    public void run() {
        //����
        for (int i=0; i<100; i++){
            System.out.println("����-->" + container.pop().id + "����ͷ");
        }
    }
}

/**
 * ������
 */
class SynContainer{
    /**
     * �洢����
     */
    Steambun[] buns = new Steambun[10];
    /**
     * ������
     */
    int count = 0;

    /**
     * �洢 ����
     * @param bun �洢����
     */
    public synchronized void push(Steambun bun){
        //��ʱ������ �������ڿռ� �������� ֻ�еȴ�
        if (count == buns.length){
            try {
                this.wait();
            }catch (InterruptedException e){
                e.printStackTrace();
            }
        }
        //���ڿռ� ��������
        buns[count] = bun;
        count++;
        //���������� ����֪ͨ������
        this.notifyAll();
    }

    /**
     * ��ȡ����
     * @return ���
     */
    public synchronized Steambun pop(){
        //��ʱ���� �������Ƿ�������� û������ ֻ�еȴ�
        if (count == 0){
            try {
                this.wait();
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
        }
        //�������ݿ�������
        count--;
        Steambun bun = buns[count];
        //���ڿռ��ˣ����Ի��ѶԷ�������
        this.notifyAll();
        return bun;
    }

}

/**
 * ��ͷ
 */
class Steambun{
    int id;

    public Steambun(int id) {
        this.id = id;
    }
}
