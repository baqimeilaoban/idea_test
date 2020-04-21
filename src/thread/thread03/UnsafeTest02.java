package thread.thread03;

/**
 * �̲߳���ȫ��ȡǮ
 * @author �ƽ���
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        //�˻�
        Account account = new Account(100,"������");
        Drawing you = new Drawing(account,80,"�ɱ�����");
        Drawing wife = new Drawing(account,90,"happy����");
        you.start();
        wife.start();
    }
}

/**
 * ģ��ȡ��
 */
class SafeDrawing extends Thread{
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

    public SafeDrawing(Account account,int drawingMoney,String name){
        super(name);
        this.account = account;
        this.drawingMoney = drawingMoney;
    }
    int packetTotal;
    @Override
    public void run() {
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
