package thread.thread04.others;

/**
 * ָ�����ţ������ִ��˳����Ԥ�ڵĲ�һ��
 * Ŀ�ģ��������
 * @author �ƽ���
 */
public class HappenBefore {
    private static int a = 0;
    private static boolean flag = false;
    public static void main(String[] args) throws InterruptedException {
        for (int i=0; i<10; i++){
            a = 0;
            flag = false;
            //�߳�1����������
            Thread t1 = new Thread(()->{
                a = 1;
                flag = true;
            });
            //�߳�2����ȡ����
            Thread t2 = new Thread(()->{
                if (flag){
                    a *= 1;
                }
                //ָ������
                if (a==0){
                    System.out.println("happen before a->" + a);
                }
            });

            t1.start();
            t2.start();

            //�ϲ��߳�
            t1.join();
            t2.join();
        }
    }
}
