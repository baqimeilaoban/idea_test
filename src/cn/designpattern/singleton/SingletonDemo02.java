package cn.designpattern.singleton;

/**
 * ��������ʽ����ģʽ
 * @author hjb
 */
public class SingletonDemo02 {
    /**
     *  ���ʼ��ʱ������ʼ�����������ʱ���أ������õ�ʱ���ٴ�����
     */
    private static SingletonDemo02 instance;

    /**
     * ˽�л�������
     */
    private SingletonDemo02() {
    }

    /**
     * ����ͬ��������Ч�ʵ�
     */
    public static synchronized SingletonDemo02 getInstance(){
        if (instance==null){
            instance = new SingletonDemo02();
        }
        return instance;
    }
}
