package cn.designpattern.prototype;

import java.util.Date;

/**
 * ����ԭ��ģʽ��ǳ��¡��
 * @author hjb
 */
public class Client {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(12312321331L);
        Sheep s1 = new Sheep("����",date);
        System.out.println(s1);
        System.out.println(s1.getSname());
        System.out.println(s1.getBirthday());

        date.setTime(23432432423L);
        System.out.println(s1.getBirthday());
        Sheep s2 = (Sheep) s1.clone();
        s2.setSname("����");
        System.out.println(s2);
        System.out.println(s2.getSname());
        System.out.println(s2.getBirthday());
    }
}
