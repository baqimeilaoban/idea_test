package com.company.mycollection;

/**
 * �Զ���һ������
 * @author �ƽ���
 */
public class SxtLinkedList01 {
    private Node first;
    private Node last;

    private int size;

    public void add(Object obj){
        Node node = new Node(obj);
        if (first == null){
            node.previous = null;
            node.next = null;
            first = node;
            last = node;
        }else {
            node.previous = last;
            node.next = null;
            last.next = node;
            last = node;
        }
    }

    @Override
    public String toString() {
        //[a,b,c] first = a  last = c
        StringBuilder sb = new StringBuilder("[");

        Node temp = first;
        while (temp != null){
            sb.append(temp.element + ",");
            temp = temp.next;
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtLinkedList01 list = new SxtLinkedList01();
        list.add('a');
        list.add('b');
        list.add('c');
        System.out.println(list);
    }
}
