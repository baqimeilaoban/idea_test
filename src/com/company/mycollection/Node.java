package com.company.mycollection;

/**
 * @author thinkpad
 */
public class Node {
    /**
     * ��һ���ڵ�
     */
    Node previous;
    /**
     * ��һ���ڵ�
     */
    Node next;
    /**
     * Ԫ������
     */
    Object element;

    /**
     * ������
     * @param previous ��һ���ڵ�
     * @param next ��һ���ڵ�
     * @param element Ԫ������
     */
    public Node(Node previous, Node next, Node element) {
        super();
        this.previous = previous;
        this.next = next;
        this.element = element;
    }

    public Node(Object element) {
        this.element = element;
    }
}
