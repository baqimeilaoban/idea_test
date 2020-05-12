package cn.designpattern.singleton;

import java.io.ObjectStreamException;
import java.io.Serializable;

/**
 * ��������ʽ����ģʽ����η�ֹ����ͷ����л�©����
 * @author hjb
 */
public class SingletonDemo06 implements Serializable {
    /**
     * ���ʼ��ʱ������ʼ�����������ʱ���أ������õ�ʱ���ٴ�����
     */
    private static SingletonDemo06 instance;

    /**
     * ˽�л�������
     */
    private SingletonDemo06(){
        if (instance!=null){
            throw new RuntimeException();
        }
    }

    /**
     * ����ͬ��������Ч�ʵ�
     */
    public static synchronized SingletonDemo06 getInstance(){
        if (instance==null){
            instance = new SingletonDemo06();
        }
        return instance;
    }

    /**
     * �����л�ʱ�����������readResolve()��ֱ�ӷ��ش˷���ָ���Ķ��󡣶�����Ҫ�����ٴ����¶��󣬷����л�ʱ�Զ����ø÷���
     */
    private Object readResolve() throws ObjectStreamException{
        return instance;
    }
}
