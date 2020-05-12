package cn.designpattern.factory.abstractfactory;

public interface Engine {
    void run();
    void start();
}

class LuxuryEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转得快");
    }

    @Override
    public void start() {
        System.out.println("启动快！可以自动启停！");
    }
}


class lowEngine implements Engine{

    @Override
    public void run() {
        System.out.println("转得慢！");
    }

    @Override
    public void start() {
        System.out.println("启动慢！");
    }
}