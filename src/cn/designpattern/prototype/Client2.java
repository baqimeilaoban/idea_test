package cn.designpattern.prototype;

import java.util.Date;

/**
 * 原型模式（深复制）
 * @author hjb
 */
public class Client2 {
    public static void main(String[] args) throws CloneNotSupportedException {
        Date date = new Date(12322333222L);
        Sheep2 s1 = new Sheep2("少利",date);
        Sheep2 s2 = (Sheep2)s1.clone();
        System.out.println(s1);
        System.out.println(s1.getSname());
        System.out.println(s1.getBirthday());
        date.setTime(23232323232L);
        System.out.println(s1.getBirthday());
        s2.setSname("多利");
        System.out.println(s2);
        System.out.println(s2.getSname());
        System.out.println(s2.getBirthday());
    }
}
