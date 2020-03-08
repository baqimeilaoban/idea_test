package com.company.collection;

import java.util.*;

/**
 * ���Ե���������List��Set��Map
 * @author �ƽ���
 */
public class TestItearator {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
        testIteratorMap2();
    }

    /**
     * ʹ�õ���������List
     */
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        System.out.println("ʹ��iterator����������List:");
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    /**
     * ʹ�õ���������Set
     */
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        System.out.println("ʹ��iterator����Set:");

        for (Iterator<String> iter = set.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    /**
     * ʹ�õ���������Map����ü�ֵ��
     */
    public static void testIteratorMap(){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(100,"aa");
        map1.put(200,"bb");
        map1.put(300,"cc");

        System.out.println("ʹ��iterator����Map����һ:");
        Set<Map.Entry<Integer,String>> ss = map1.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iter = ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> temp = iter.next();
            System.out.println(temp.getKey() + "---" + temp.getValue());
        }
    }

    /**
     * ʹ�õ���������Map�����keySet
     */
    public static void testIteratorMap2(){
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(100,"aa");
        map2.put(200,"bb");
        map2.put(300,"cc");
        System.out.println("ʹ��iterator����Map��������");
        Set<Integer> keyset = map2.keySet();
        for (Iterator<Integer> iter = keyset.iterator(); iter.hasNext(); ) {
            Integer key = iter.next();
            System.out.println(key + "---" + map2.get(key));
        }
    }
}
