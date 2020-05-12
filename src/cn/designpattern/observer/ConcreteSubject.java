package cn.designpattern.observer;

public class ConcreteSubject extends Subject{
    private int state;

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
        //�������Ŀ�����ֵ�����˱仯����֪ͨ���еĹ۲���
        this.notifyAllObservers();
    }
}
