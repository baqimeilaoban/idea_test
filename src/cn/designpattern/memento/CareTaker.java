package cn.designpattern.memento;

/**
 * ��������
 * �����·����¼����
 * @author �ƽ���
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
