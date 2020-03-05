package com.company.mycollection;


/**
 * 自定义一个ArrayList，体会底层原理
 * 增加泛型
 * @author 黄建波
 */
public class SxtArrayList03<E> {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList03(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList03(int capacity){
        elementData = new Object[capacity];
    }

    public void add(E element){
        //什么时候扩容，会一直扩容
        if (size == elementData.length){
            //怎么扩容 10-->10+10/2
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;

    }

    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();

        //[a,b,c]
        sb.append("[");
        for (int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtArrayList03 s2 = new SxtArrayList03();

        for (int i = 0; i < 40; i++){
            s2.add("高" + i);
        }

        System.out.println(s2);
    }
}

