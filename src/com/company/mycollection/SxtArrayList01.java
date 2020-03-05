package com.company.mycollection;

import java.util.Arrays;

/**
 * 自定义一个ArrayList，体会底层原理
 * @author 黄建波
 */
public class SxtArrayList01 {
    private Object[] elementData;
    private int size;

    private static final int DEFAULT_CAPACITY = 10;

    public SxtArrayList01(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    public SxtArrayList01(int capacity){
        elementData = new Object[capacity];
    }

    public void add(Object element){
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
        SxtArrayList01 s2 = new SxtArrayList01();

        s2.add("aa");
        s2.add("bb");

        System.out.println(s2);
    }
}
