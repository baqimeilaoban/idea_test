package cn.designpattern.mediator;

public class Development implements Department{
    /**
     * 持有中介者（总经理）的引用
     */
    private Mediator m;

    public Development(Mediator m) {
        this.m = m;
        m.register("development",this);
    }

    @Override
    public void selfAction() {
        System.out.println("专心科研，开发项目！");
    }

    @Override
    public void outAction() {
        System.out.println("汇报工作！没钱了，需要资金支持！");
    }
}
