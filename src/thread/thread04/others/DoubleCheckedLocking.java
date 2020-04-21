package thread.thread04.others;

/**
 * DCL����ģʽ: ����ʽ��·�����ϼ��벢�����ƣ���֤�ڶ��̻߳����£��������һ������
 * 1��������˽�л� -->�����ⲿnew������
 * 2���ṩ˽�еľ�̬���� -->�洢����ĵ�ַ
 * 3���ṩ�����ľ�̬���� --> ��ȡ����
 * @author �ƽ���
 */
public class DoubleCheckedLocking {
    /**
     * 2.�ṩ˽�еľ�̬����
     * û��volatile�����߳̿��ܷ���һ��û�г�ʼ���Ķ���
     */
    private static volatile DoubleCheckedLocking instance;
    /**
     * 1.������˽�л�
     */
    private DoubleCheckedLocking(){

    }
    /**
     * �ṩ�����ľ�̬���� --����ȡ����
     */
    public static DoubleCheckedLocking getInstance(){
        //�ٴμ��
        if (null!=instance){
            //���ⲻ��Ҫ��ͬ�����Ѿ����ڶ���
            return instance;
        }
        synchronized (DoubleCheckedLocking.class){
            if (null==instance){
                instance = new DoubleCheckedLocking();
            }
        }
        return instance;
    }

    public static DoubleCheckedLocking getInstance1(long time){
        if (null==instance){
            try {
                Thread.sleep(time);
            } catch (InterruptedException e) {
                e.printStackTrace();
            }
            instance = new DoubleCheckedLocking();
        }
        return instance;
    }

    public static void main(String[] args) {
        Thread t = new Thread(()->{
            System.out.println(DoubleCheckedLocking.getInstance());
        });
        t.start();
        System.out.println(DoubleCheckedLocking.getInstance());
    }
}
