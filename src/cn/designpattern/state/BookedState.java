package cn.designpattern.state;

/**
 * ��Ԥ��״̬
 * @author �ƽ���
 */
public class BookedState implements State{
    @Override
    public void handle() {
        System.out.println("������Ԥ�������˲��ܶ���");
    }
}
