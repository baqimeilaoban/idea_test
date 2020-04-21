package thread.thread03;

/**
 * 线程不安全：取钱
 * @author 黄建波
 */
public class UnsafeTest02 {
    public static void main(String[] args) {
        //账户
        Account account = new Account(100,"结婚礼金");
        Drawing you = new Drawing(account,80,"可悲的你");
        Drawing wife = new Drawing(account,90,"happy的她");
        you.start();
        wife.start();
    }
}

/**
 * 模拟取款
 */
class SafeDrawing extends Thread{
    /**
     * 取钱的账户
     */
    Account account;

    /**
     * 取钱的钱数
     */
    int drawingMoney;

    /**
     * 口袋的总数
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
        System.out.println(this.getName() + "-->账户余额为：" + account.money);
        System.out.println(this.getName() + "-->口袋的钱为：" + packetTotal);
    }
}
