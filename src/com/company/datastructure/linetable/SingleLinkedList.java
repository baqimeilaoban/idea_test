package com.company.datastructure.linetable;

/**
 *
 * @author thinkpad
 */
public class SingleLinkedList implements List {
    /**
     * ͷ�ڵ㲻�洢���ݣ�Ϊ�˱�̷���
     */
    private Node head = new Node();

    /**
     * һ���ж��ٸ��ڵ�
     */
    private int size;

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //��˳���һ��������ͨ������ֱ�Ӽ��㶨λ������Ҫ��ͷ�ڵ㿪ʼ���в���
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
        //���i��λ�ô����쳣
        if (i < 0 || i > size){
            throw new MyArrayIndexOutOfBoundsException("����ָ��Խ���쳣��" + i);
        }
        //�ҵ�ǰһ���ڵ㣬��head�ڵ㿪ʼ��
        Node p = head;
        for (int j= 0;j < i;j++){
            p = p.next;
        }
        //�´���һ���ڵ�
        Node newNode = new Node();
        newNode.data = e;
        newNode.next = null;
        //ָ���½ڵ��ֱ�Ӻ�̽ڵ�
        newNode.next = p.next;
        //ָ���½ڵ��ֱ��ǰ���ڵ�
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
        //��ȷ��ǰ���ڵ��Ҫɾ���Ľڵ�
        Node p = head;
        Node s = head.getNext();
        //Ĭ�ϸýڵ㲻����
        boolean flag = false;
        while (s != null){
            //�ж��Ƿ��ҵ�
            if (e.equals(s.getData())){
                flag = true;
                break;
            }
            //���û���ҵ����ƶ�ָ�뵽��һ���ڵ�
            p = s;
            s = s.getNext();
        }
        //����ҵ�����ɾ��
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
            //�ƶ�ָ�뵽��һ���ڵ�
            p = p.next;
        }
        return sb.toString();
    }
}
