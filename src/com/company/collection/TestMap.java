package com.company.collection;

import java.util.HashMap;
import java.util.Map;

/**
 * ����HaspMap��ʹ��
 * @author �ƽ���
 */
public class TestMap {
    public static void main(String[] args) {
        Map<Integer,String> m1 = new HashMap<>();

        m1.put(1,"one");
        m1.put(2,"two");
        m1.put(3,"three");

        System.out.println(m1.get(1));
        System.out.println(m1.size());
        System.out.println(m1.isEmpty());
        System.out.println(m1.containsKey(2));
        System.out.println(m1.containsValue("four"));

        Map<Integer,String> m2 = new HashMap<>();
        m2.put(4,"��");
        m2.put(5,"��");

        m1.putAll(m2);
        System.out.println(m1);

        //map�еļ������ظ�!����ظ����Ƿ��ظ�������equals�����������µĸ��Ǿɵ�
        m1.put(3,"��");
        System.out.println(m1);
    }
}
