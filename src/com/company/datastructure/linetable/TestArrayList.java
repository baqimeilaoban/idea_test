package com.company.datastructure.linetable;

public class TestArrayList {
    public static void main(String[] args) {
        List list = new ArrayList();

        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);
        list.add(3,666);
        list.add(20,777);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(2));
        System.out.println(list.get(4));
        System.out.println(list.get(3));
        System.out.println(list.toString());
    }
}
