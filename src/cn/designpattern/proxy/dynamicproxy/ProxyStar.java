package cn.designpattern.proxy.dynamicproxy;

/**
 * ģ�⶯̬���ɵĴ���Ľṹ
 * @author hjb
 */
public class ProxyStar implements Star{
    StarHandler handler;

    public ProxyStar(StarHandler handler) {
        this.handler = handler;
    }


    @Override
    public void confer() {
        //handler.invoke(this,��ǰ���� , args);
    }

    @Override
    public void signContract() {
        //handler.invoke(this,��ǰ���� , args);
    }

    @Override
    public void bookTicket() {
        //handler.invoke(this,��ǰ���� , args);
    }

    @Override
    public void sing() {
        //handler.invoke(this,��ǰ���� , args);
    }

    @Override
    public void collectMoney() {
        //handler.invoke(this,��ǰ���� , args);
    }
}
