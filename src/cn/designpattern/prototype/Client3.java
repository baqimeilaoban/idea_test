package cn.designpattern.prototype;

import com.sun.xml.internal.messaging.saaj.util.ByteOutputStream;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.ObjectInputStream;
import java.io.ObjectOutputStream;
import java.util.Date;

/**
 * ԭ��ģʽ����ƣ�ʹ�����л��ͷ����л��ķ�ʽʵ����ƣ�
 * @author hjb
 */
public class Client3 {
    public static void main(String[] args) throws IOException, ClassNotFoundException {
        Date date = new Date(12312321111L);
        Sheep s1 = new Sheep("����",date);
        System.out.println(s1);
        System.out.println(s1.getSname());
        System.out.println(s1.getBirthday());

        //ʹ�����л��ͷ����л�ʵ�����
        ByteOutputStream bos = new ByteOutputStream();
        ObjectOutputStream oos = new ObjectOutputStream(bos);
        oos.writeObject(s1);
        byte[] bytes = bos.toByteArray();
        ByteArrayInputStream bis = new ByteArrayInputStream(bytes);
        ObjectInputStream ois = new ObjectInputStream(bis);
        //��¡�õĶ���
        Sheep s2 = (Sheep)ois.readObject();
        System.out.println("�޸�ԭ�Ͷ��������ֵ");
        date.setTime(2311222255446L);
        System.out.println(s1.getBirthday());
        s2.setSname("����");
        System.out.println(s2);
        System.out.println(s2.getSname());
        System.out.println(s2.getBirthday());
    }
}
