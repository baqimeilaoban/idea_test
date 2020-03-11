package com.company.datastructure.linetable;

/**
 * 单链表的节点
 * @author 黄建波
 */
public class Node {
    /**
     * 要存储的数据
     */
    Object data;
    /**
     * 下一个节点
     */
    Node next;

    public Node() {
    }

    public Node(Object data) {
        this.data = data;
    }

    public Object getData() {
        return data;
    }

    public void setData(Object data) {
        this.data = data;
    }

    public Node getNext() {
        return next;
    }

    public void setNext(Node next) {
        this.next = next;
    }
}
