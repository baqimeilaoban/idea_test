package cn.sxt.thread.thread01;

/**
 * 静态代理
 * 公共接口；
 * 1.真实角色
 * 2.代理角色
 * @author 黄建波
 */
public class StaticProxy {
    public static void main(String[] args) {
        new WeddingCompany(new You()).happyMarry();

        //new Thread(线程对象).start();
    }
}

interface Marry{
    void happyMarry();
}

/**
 * 真实角色
 */
class You implements Marry{

    @Override
    public void happyMarry() {
        System.out.println("嫦娥终于奔月了。。。");
    }
}

/**
 * 代理角色
 */
class WeddingCompany implements Marry{
    private Marry target;

    public WeddingCompany(Marry target) {
        this.target = target;
    }

    @Override
    public void happyMarry() {
        ready();
        this.target.happyMarry();
        after();
    }

    private void after() {
        System.out.println("洞房花烛夜。。。");
    }

    private void ready() {
        System.out.println("布置新房。。。。");
    }
}
