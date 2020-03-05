package com.company.mycollection;

/**
 * 自定义一个链表
 * 增加remove方法
 * @author 黄建波
 */
public class SxtLinkedList03 {
    private Node first;
    private Node last;

    private int size;

    public void add(Object object){
        Node node = new Node(object);
        if (first == null){
            node.previous = null;
            node.next = null;
            first = node;
        }else {
            node.previous = last;
            node.next = null;
            last.next = node;
        }
        last = node;
        size++;
    }

    public Object get(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("索引数字不合法：" + index);
        }
        Node temp = getNode(index);
        return temp != null ? temp.element : null;
    }

    /**
     * 对get方法进行封装，以便重用
     * @param index 索引值
     * @return 索引值处的元素
     */
    public Node getNode(int index){
        Node temp = null;
        if (index <= (size >> 1)){
            temp = first;
            for (int i = 0; i < index; i++){
                temp = temp.next;
            }
        }else {
            temp = last;
            for (int i = size - 1; i > index; i--){
                temp = temp.previous;
            }
        }
        return temp;
    }

    public void remove(int index){
        Node temp = getNode(index);
        if (temp != null){
            Node up = temp.previous;
            Node down = temp.next;
            if (up != null){
                up.next = down;
            }
            if (down != null){
                down.previous = up;
            }
            //被删除的元素是第一个元素时
            if (index == 0){
                first = down;
            }
            //被删除的元素是最后一个元素时
            if (index == size -1){
                last = up;
            }
            size--;
        }
    }

    @Override
    public String toString() {
       StringBuilder sb = new StringBuilder();
       sb.append('[');
       Node temp = first;
       while (temp != null){
           sb.append(temp.element + ",");
           temp = temp.next;
       }
       sb.setCharAt(sb.length()-1, ']');
       return sb.toString();
    }

    public static void main(String[] args) {
        SxtLinkedList03 list = new SxtLinkedList03();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);

        System.out.println(list.get(3));
        list.remove(3);
        System.out.println(list);
        list.remove(0);
        System.out.println(list);
        list.remove(3);
        System.out.println(list);
    }
}
