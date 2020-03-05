package com.company.mycollection;

/**
 * 增加set，get方法
 * 增加数组边界的检查
 * @author 黄建波
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
            throw new RuntimeException("容器的容量不能为负数！");
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
        //索引合法判断
        if (index < 0 || index > size - 1){
            //不合法
            throw new RuntimeException("索引不合法:" + index);
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
            s2.add("高" + i);
        }

        s2.set("黄",10);
        System.out.println(s2);
        System.out.println(s2.get(39));
    }
}
