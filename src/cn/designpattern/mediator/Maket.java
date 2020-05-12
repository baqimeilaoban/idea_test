package cn.designpattern.mediator;

public class Maket implements Department{
    /**
     * 持有中介者（总经理）的引用
     */
    private Mediator m;

    public Maket(Mediator m) {
        this.m = m;
        m.register("market",this);
    }

    @Override
    public void selfAction() {
        System.out.println("跑去接项目！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作！项目承接的进度，需要资金支持！");
        m.command("financial");
    }
}
