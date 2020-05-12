package cn.designpattern.observer;

import java.util.ArrayList;
import java.util.List;

public class Subject {
    protected List<Observer> list = new ArrayList<>();
    public void registerObserver(Observer obs){
        list.add(obs);
    }

    public void removeObserver(Observer obs){
        list.add(obs);
    }

    /**
     * ֪ͨ���й۲��߸���״̬
     */
    public void notifyAllObservers(){
        for (Observer obs: list){
            obs.update(this);
        }
    }
}
