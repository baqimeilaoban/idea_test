package com.company.datastructure.linetable;

import java.util.Deque;
import java.util.Queue;

public class TestSingleLinkedList {
    public static void main(String[] args) {
        Deque de;
        Queue queue;
        List list = new SingleLinkedList();
        list.add(123);
        list.add(321);
        list.add(456);
        list.add(678);
        list.add(789);
        list.add(111);
        list.add(222);
        list.add(5,666);

        System.out.println(list.size());
        System.out.println(list.isEmpty());
        System.out.println(list.get(3));
        System.out.println(list.toString());

        list.add(10,444);
    }
}
