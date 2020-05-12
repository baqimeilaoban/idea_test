package cn.designpattern.observer2;

import java.util.Observable;

public class ConcreteSubject extends Observable {
    private int state;
    public void set(int s){
        //Ŀ������״̬�����˸ı�
        state = s;
        //��ʾĿ������Ѿ����˸���
        setChanged();
        //֪ͨ���еĹ۲���
        notifyObservers(state);
    }

    public int getState() {
        return state;
    }

    public void setState(int state) {
        this.state = state;
    }
}
