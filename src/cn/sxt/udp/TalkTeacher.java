package cn.sxt.udp;

/**
 * ������̣߳�ʵ��˫���� ģ��������ѯ
 * @author �ƽ���
 */
public class TalkTeacher {
    public static void main(String[] args) {
        //����
        new Thread(new TalkReceive(9999,"��ʦ")).start();

        //����
        new Thread(new TalkSend(5555,"localhost",8888)).start();
    }
}
