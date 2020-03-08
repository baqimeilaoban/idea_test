package com.company.collection;

import java.util.*;

/**
 * 测试迭代器遍历List，Set，Map
 * @author 黄建波
 */
public class TestItearator {
    public static void main(String[] args) {
        testIteratorList();
        testIteratorSet();
        testIteratorMap();
        testIteratorMap2();
    }

    /**
     * 使用迭代器遍历List
     */
    public static void testIteratorList(){
        List<String> list = new ArrayList<>();
        list.add("aa");
        list.add("bb");
        list.add("cc");

        System.out.println("使用iterator迭代器遍历List:");
        for (Iterator<String> iter = list.iterator(); iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    /**
     * 使用迭代器遍历Set
     */
    public static void testIteratorSet(){
        Set<String> set = new HashSet<>();
        set.add("aa");
        set.add("bb");
        set.add("cc");
        System.out.println("使用iterator遍历Set:");

        for (Iterator<String> iter = set.iterator();iter.hasNext();){
            String temp = iter.next();
            System.out.println(temp);
        }
    }

    /**
     * 使用迭代器遍历Map：获得键值对
     */
    public static void testIteratorMap(){
        Map<Integer,String> map1 = new HashMap<>();
        map1.put(100,"aa");
        map1.put(200,"bb");
        map1.put(300,"cc");

        System.out.println("使用iterator遍历Map方法一:");
        Set<Map.Entry<Integer,String>> ss = map1.entrySet();
        for (Iterator<Map.Entry<Integer,String>> iter = ss.iterator(); iter.hasNext();){
            Map.Entry<Integer,String> temp = iter.next();
            System.out.println(temp.getKey() + "---" + temp.getValue());
        }
    }

    /**
     * 使用迭代器遍历Map：活鹅keySet
     */
    public static void testIteratorMap2(){
        Map<Integer,String> map2 = new HashMap<>();
        map2.put(100,"aa");
        map2.put(200,"bb");
        map2.put(300,"cc");
        System.out.println("使用iterator遍历Map方法二：");
        Set<Integer> keyset = map2.keySet();
        for (Iterator<Integer> iter = keyset.iterator(); iter.hasNext(); ) {
            Integer key = iter.next();
            System.out.println(key + "---" + map2.get(key));
        }
    }
}
