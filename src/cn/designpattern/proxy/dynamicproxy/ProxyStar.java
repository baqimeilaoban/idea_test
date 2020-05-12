package cn.designpattern.proxy.dynamicproxy;

/**
 * 模拟动态生成的代理的结构
 * @author hjb
 */
public class ProxyStar implements Star{
    StarHandler handler;

    public ProxyStar(StarHandler handler) {
        this.handler = handler;
    }


    @Override
    public void confer() {
        //handler.invoke(this,当前方法 , args);
    }

    @Override
    public void signContract() {
        //handler.invoke(this,当前方法 , args);
    }

    @Override
    public void bookTicket() {
        //handler.invoke(this,当前方法 , args);
    }

    @Override
    public void sing() {
        //handler.invoke(this,当前方法 , args);
    }

    @Override
    public void collectMoney() {
        //handler.invoke(this,当前方法 , args);
    }
}
