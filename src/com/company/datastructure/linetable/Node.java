package com.company.datastructure.linetable;

/**
 * ������Ľڵ�
 * @author �ƽ���
 */
public class Node {
    /**
     * Ҫ�洢������
     */
    Object data;
    /**
     * ��һ���ڵ�
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
