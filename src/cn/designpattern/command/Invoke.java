package cn.designpattern.command;

/**
 * ������/������
 * @author �ƽ���
 */
public class Invoke {
    /**
     * Ҳ����ͨ������List<Command>���ɺܶ�������󣬽������������ݿ�ײ���������������ƵĽṹ��
     */
    private Command command;

    public Invoke(Command command) {
        this.command = command;
    }

    /**
     * ҵ�񷽷������ڵ���������ķ���
     */
    public void call(){
        command.execute();
    }
}
