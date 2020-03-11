package com.company.datastructure.linetable;

/**
 *
 * @author thinkpad
 */
public class SingleLinkedList implements List {
    /**
     * 头节点不存储数据，为了编程方便
     */
    private Node head = new Node();

    /**
     * 一共有多少个节点
     */
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //和顺序表不一样，不能通过索引直接计算定位，而需要从头节点开始进行查找
        Node p = head;
        for (int j = 0; j <= i; j++){
            p = p.next;
        }
        return p.data;
    }

    @Override
    public boolean isEmpty() {
        return size == 0;
    }

    @Override
    public boolean contains(Object e) {
        return false;
    }

    @Override
    public int indexOf(Object e) {
        return 0;
    }

    @Override
    public void add(int i, Object e) {
        //如果i的位置错误报异常
        if (i < 0 || i > size){
            throw new MyArrayIndexOutOfBoundsException("数组指针越界异常：" + i);
        }
        //找到前一个节点，从head节点开始找
        Node p = head;
        for (int j= 0;j < i;j++){
            p = p.next;
        }
        //新创建一个节点
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;
        //指明新节点的直接后继节点
        newNode.next = p.next;
        //指明新节点的直接前驱节点
        p.next = newNode;
        size++;
    }

    @Override
    public void add(Object e) {
        this.add(size,e);
    }

    @Override
    public boolean addBefore(Object obj, Object e) {
        return false;
    }

    @Override
    public boolean addAfter(Object obj, Object e) {
        return false;
    }

    @Override
    public Object remove(int i) {
        return null;
    }

    @Override
    public boolean remove(Object e) {
        //先确定前驱节点和要删除的节点
        Node p = head;
        Node s = head.getNext();
        //默认该节点不存在
        boolean flag = false;
        while (s != null){
            //判断是否找到
            if (e.equals(s.getData())){
                flag = true;
                break;
            }
            //如果没有找到，移动指针到后一个节点
            p = s;
            s = s.getNext();
        }
        //如果找到，就删除
        if (flag){
            p.setNext(s.getNext());
            s.setNext(null);
            s = null;
        }
        return flag;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        Node p = head.next;
        for (int i = 0; i < size; i++){
            if (i != size-1){
                sb.append(p.data + ",");
            }else {
                sb.append(p.data + "]");
            }
            //移动指针到下一个节点
            p = p.next;
        }
        return sb.toString();
    }
}
