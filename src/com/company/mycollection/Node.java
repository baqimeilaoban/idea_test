package com.company.mycollection;

/**
 * @author thinkpad
 */
public class Node {
    /**
     * 上一个节点
     */
    Node previous;
    /**
     * 下一个节点
     */
    Node next;
    /**
     * 元素数据
     */
    Object element;

    /**
     * 构造器
     * @param previous 上一个节点
     * @param next 下一个节点
     * @param element 元素数据
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
