package com.company.datastructure.linetable;

import java.util.LinkedList;

/**
 * 双向链表
 * 双向循环链表
 * @author 黄建波
 */
public class TestDoubleLinkedList {
    public static void main(String[] args) {
        //创建一个集合对象
        LinkedList<Integer> list = new LinkedList<Integer>();
        //向集合中添加元素
        list.add(78);
        list.add(80);
        list.add(89);
        list.add(80);
        list.add(75);
    }
}
