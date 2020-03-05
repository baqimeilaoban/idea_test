package com.company.mycollection;

/**
 * 自定义一个链表
 * 增加小的封装，增加泛型
 * @author 黄建波
 */
public class SxtLinkedList05<E> {
    private Node first;
    private Node last;

    private int size;

    /**
     * 向链表中添加元素
     * @param element 元素
     */
    public void add(E element){
        Node node = new Node(element);
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

    /**
     * 在链表索引处添加元素
     * @param index 索引
     * @param element 元素
     */
    public void add(int index, E element){
        checkRange(index);
        Node newNode = new Node(element);
        Node temp = getNode(index);
        if (temp != null){
            Node up = temp.previous;
            up.next = newNode;
            newNode.previous = up;
            newNode.next = temp;
            temp.previous = newNode;
        }
    }

    /**
     * 对get方法进行封装，以便重用
     * 返回索引处的链表节点
     * @param index 索引
     * @return 节点
     */
    private Node getNode(int index){
        checkRange(index);
        Node temp;
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

    /**
     * 返回索引处的元素
     * @param index 索引
     * @return 元素
     */
    public E get(int index){
        checkRange(index);
        Node temp = getNode(index);
        return temp != null ? (E) temp.element : null;
    }

    /**
     * 封装检查索引合法性的方法
     * @param index 索引值
     */
    private void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("索引数字不合法：" + index);
        }
    }

    /**
     * 删除索引处的节点
     * @param index 索引
     */
    public void remove(int index){
        checkRange(index);
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
            if (index == 0){
                first = down;
            }
            if (index == size - 1){
                last = up;
            }
            size--;
        }
    }

    /**
     * 对toString方法进行重写
     * @return 字符串
     */
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
        SxtLinkedList05<String> list = new SxtLinkedList05<>();
        list.add("a");
        list.add("b");
        list.add("c");
        list.add("d");
        list.add("e");
        list.add("f");

        System.out.println(list);

        System.out.println(list.get(3));
        list.add(3,"老黄");
        System.out.println(list);
    }
}
