package cn.designpattern.state;

/**
 * ����ס״̬
 * @author �ƽ���
 */
public class CheckedInState implements State{
    @Override
    public void handle() {
        System.out.println("��������ס��������ţ�");
    }
}
