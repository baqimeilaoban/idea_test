package thread.thread01;

/**
 * �����̷߳�ʽһ��
 * 1.�������̳�Thread+��дrun
 * 2.�����������������+start
 * @author thinkpad
 */
public class StartThread extends Thread{
    /**
     * �̵߳���ڵ�
     */
    @Override
    public void run() {
        for (int i = 0;i < 20;i++){
            System.out.println("һ������");
        }
    }

    public static void main(String[] args) {
        //�����������
        StartThread st = new StartThread();
        //����������һ���µ��߳�
        st.start();
        for (int i = 0; i < 20; i++){
            System.out.println("һ��coding");
        }
    }
}
