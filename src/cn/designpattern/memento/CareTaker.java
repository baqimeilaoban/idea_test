package cn.designpattern.memento;

/**
 * 负责人类
 * 负责管路备忘录对象
 * @author 黄建波
 */
public class CareTaker {
    private EmpMemento memento;

    public EmpMemento getMemento(){
        return memento;
    }

    public void setMemento(EmpMemento memento){
        this.memento = memento;
    }
}
