package cn.sxt.thread.thread01;

/**
 * �����̷߳�ʽ����
 * 1.������ʵ��Runnable+��дrun
 * 2.����������ʵ�������+Thread����+start
 *
 * �Ƽ������ⵥ�̳еľ����ԣ�����ʹ�ýӿ�
 * ���㹲����Դ
 * @author �ƽ���
 */
public class StartRun implements Runnable{
    @Override
    public void run() {
        for (int i = 0; i < 20; i++){
            System.out.println("һ�߳���");
        }
    }

    public static void main(String[] args) {
        //����ʵ�������
        StartRun sr = new StartRun();
        //�������������
        Thread t = new Thread(sr);
        //����
        t.start();
        for (int i = 0; i < 20; i++){
            System.out.println("һ��coding");
        }
    }
}
