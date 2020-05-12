package cn.designpattern.singleton;

import java.io.FileInputStream;
import java.io.FileOutputStream;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.lang.reflect.Constructor;

/**
 * ���Է���ͷ����л��ƽⵥ��ģʽ
 * @author hjb
 */
public class Client02 {
    public static void main(String[] args) throws Exception{
        SingletonDemo06 s1 = SingletonDemo06.getInstance();
        SingletonDemo06 s2 = SingletonDemo06.getInstance();

        System.out.println(s1);
        System.out.println(s2);

        //ͨ������ķ�ʽֱ�ӵ���˽�й�������������
        /*Class<SingletonDemo06> clazz = (Class<SingletonDemo06>) Class.forName("cn.designpattern.singleton.SingletonDemo06");
	    Constructor<SingletonDemo06> c = clazz.getDeclaredConstructor(null);
		c.setAccessible(true);
		SingletonDemo06  s3 = c.newInstance();
		SingletonDemo06  s4 = c.newInstance();
		System.out.println(s3);
		System.out.println(s4);*/

        //ͨ�������л��ķ�ʽ����������
        FileOutputStream fos = new FileOutputStream("D:\\idea-workspace\\src\\cn\\designpattern\\singleton\\a.txt");
        ObjectOutputStream oos = new ObjectOutputStream(fos);
        oos.writeObject(s1);
        oos.close();
        fos.close();

        ObjectInputStream ois = new ObjectInputStream(new FileInputStream("D:\\idea-workspace\\src\\cn\\designpattern\\singleton\\a.txt"));
        SingletonDemo06 s3 = (SingletonDemo06) ois.readObject();
        System.out.println(s3);
    }
}
