package thread.thread03;

/**
 * �̰߳�ȫ���ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1.ͬ������
 * 2.ͬ����
 * @author �ƽ���
 */
public class SynTest02 {
    public static void main(String[] args) {
        //�˻�
        Account account = new Account(100,"������");
        SafeDrawing you = new SafeDrawing(account,80,"�ɱ�����");
        SafeDrawing wife = new SafeDrawing(account,90,"happy����");
        you.start();
        wife.start();
    }
}

/**
 * ģ��ȡ��
 */
class Drawing extends Thread{
    /**
     * ȡǮ���˻�
     */
    Account account;

    /**
     * ȡǮ��Ǯ��
     */
    int drawingMoney;

    /**
     * �ڴ�������
     */
    int packetTotal;

    public Drawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }

    @Override
    public void run() {
        test();
    }

    /**
     * Ŀ�겻�ԣ�����ʧ�� ���ﲻ����this Ӧ������account
     */
    public synchronized void test(){
        if (account.money - drawingMoney<0){
            return;
        }
        try {
            Thread.sleep(1000);
        }catch (InterruptedException e){
            e.printStackTrace();
        }
        account.money -= drawingMoney;
        packetTotal += drawingMoney;
        System.out.println(this.getName() + "-->�˻����Ϊ��" + account.money);
        System.out.println(this.getName() + "-->�ڴ���ǮΪ��" + packetTotal);
    }
}
