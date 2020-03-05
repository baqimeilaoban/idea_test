package com.company.mycollection;

/**
 * ����set��get����
 * ��������߽�ļ��
 * @author �ƽ���
 */
public class SxtArrayList04<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList04(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList04(int capacity){
        if (capacity < 0){
            throw new RuntimeException("��������������Ϊ������");
        }else if (capacity == 10){
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
        elementData = new Object[capacity];
    }

    public void add(E element){
        if (size == elementData.length){
            Object[] newArray= new Object[elementData.length + (elementData.length >> 2)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    public E get(int index){
        checkRange(index);
       return (E)elementData[index];
    }

    public void set(E element,int index){
       checkRange(index);
        elementData[index] = element;
    }

    public void checkRange(int index){
        //�����Ϸ��ж�
        if (index < 0 || index > size - 1){
            //���Ϸ�
            throw new RuntimeException("�������Ϸ�:" + index);
        }
    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length() - 1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtArrayList04 s2 = new SxtArrayList04();

        for (int i = 0; i < 40; i++){
            s2.add("��" + i);
        }

        s2.set("��",10);
        System.out.println(s2);
        System.out.println(s2.get(39));
    }
}
