package cn.sxt.server.basic;

import java.lang.reflect.InvocationTargetException;

/**
 * ���䣺��Java���еĸ��ֽṹ�����������ԡ���������������ӳ���һ����Java����
 * 1.��ȡClass����
 * ���ַ�ʽ��Class.forName("����·��")
 * 2.���Զ�̬��������
 * clz.getConstructor().newInstance()
 * @author �ƽ���
 */
public class ReflectTest {
    public static void main(String[] args) throws ClassNotFoundException, IllegalAccessException, InstantiationException, NoSuchMethodException, InvocationTargetException {
        //���ַ�ʽ
        //1.����.getClass()
        Iphone iphone = new Iphone();
        Class clz = iphone.getClass();
        //2.��.class()
        clz = Iphone.class;
        //3.Class.forName("����.����")
        clz = Class.forName("cn.sxt.server.basic.Iphone");

        //��������
        /*Iphone iphone2 = (Iphone)clz.newInstance();
        System.out.println(iphone2);*/
        Iphone iphone2 = (Iphone)clz.getConstructor().newInstance();
        System.out.println(iphone2);
    }
}

class Iphone{
    public Iphone(){

    }
}
