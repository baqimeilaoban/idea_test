package cn.designpattern.singleton;

/**
 * ���Զ���ʽ����ģʽ
 * @author hjb
 */
public class SingletonDemo01 {
    /**
     * �࿪ʼ��ʼ��ʱ�����������������û����ʱ���ص����ƣ���������ʱ����Ȼ��ʱ�̰߳�ȫ��
     */
    private static SingletonDemo01 instance = new SingletonDemo01();

    private SingletonDemo01() {
    }

    /**
     * ����û��ͬ��������Ч�ʸ�
     */
    public static SingletonDemo01 getInstance() {
        return instance;
    }
}
