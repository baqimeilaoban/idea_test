package thread.thread03;

/**
 * �̰߳�ȫ: �ڲ���ʱ��֤���ݵ���ȷ�ԡ�Ч�ʾ����ܸ�
 * synchronized
 * 1��ͬ������
 * 2��ͬ���� ,Ŀ�����ȷ
 * @author �ƽ���
 */
public class SynBlockTest01 {
    public static void main(String[] args){
        //�˻�
        Account account =new Account(100,"������");
        SynDrawing you = new SynDrawing(account,80,"�ɱ�����");
        SynDrawing wife = new SynDrawing(account,90,"happy����");
        you.start();
        wife.start();
    }
}

class SynDrawing extends Thread{
    /**
     * ȡǮ���˻�
     */
    Account account;

    /**
     * ȡ��Ǯ��
     */
    int drawingMoney;

    /**
     * �ڴ�������
     */
    int packetTotal;

    public SynDrawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    @Override
    public void run() {
        test();
    }

    /**
     * Ŀ������account
     */
    private void test() {
        //�������
        if (account.money<0){
            return;
        }
        synchronized (account){
            if (account.money-drawingMoney<0){
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
}
