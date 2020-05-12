package cn.designpattern.singleton;

/**
 * ���Ծ�̬�ڲ���ʵ�ֵ���ģʽ
 * ���ַ�ʽ���̰߳�ȫ������Ч�ʸߣ�����ʵ������ʱ����
 * @author hjb
 */
public class SingletonDemo04 {
    private static class SingletonClassInstance{
        private static final SingletonDemo04 instance = new SingletonDemo04();
    }

    private SingletonDemo04(){

    }

    /**
     * ����û��ͬ��������Ч�ʸ�
     */
    public static SingletonDemo04 getInstance(){
        return SingletonClassInstance.instance;
    }
}
