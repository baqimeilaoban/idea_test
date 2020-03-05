package com.company.mycollection;

/**
 * �Զ���һ������
 * ����С�ķ�װ�����ӷ���
 * @author �ƽ���
 */
public class SxtLinkedList05<E> {
    private Node first;
    private Node last;

    private int size;

    /**
     * �����������Ԫ��
     * @param element Ԫ��
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
     * ���������������Ԫ��
     * @param index ����
     * @param element Ԫ��
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
     * ��get�������з�װ���Ա�����
     * ����������������ڵ�
     * @param index ����
     * @return �ڵ�
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
     * ������������Ԫ��
     * @param index ����
     * @return Ԫ��
     */
    public E get(int index){
        checkRange(index);
        Node temp = getNode(index);
        return temp != null ? (E) temp.element : null;
    }

    /**
     * ��װ��������Ϸ��Եķ���
     * @param index ����ֵ
     */
    private void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("�������ֲ��Ϸ���" + index);
        }
    }

    /**
     * ɾ���������Ľڵ�
     * @param index ����
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
     * ��toString����������д
     * @return �ַ���
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
        list.add(3,"�ϻ�");
        System.out.println(list);
    }
}
