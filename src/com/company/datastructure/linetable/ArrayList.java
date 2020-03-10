package com.company.datastructure.linetable;

import java.util.Arrays;

/**
 * 顺序表
 * 底层采用的数组，但长度可以动态变化
 * 核心是数组的扩容
 * @author 黄建波
 */
public class ArrayList implements List {
    /**
     * 底层是一个数组，目前没确定长度
     */
    private Object[] elementData;
    /**
     * 不是数组分配了几个空间，而是元素的个数
     */
    private int size;

    /**
     * 没有指定长度，默认长度是4
     */
    public ArrayList(){
        //没有指定长度，默认长度是4
        this(4);
    }

    /**
     * 构造器
     * @param initialCapacity 数组的初始长度
     */
    public ArrayList(int initialCapacity){
        //给数组分配指定数量的空间
        elementData = new  Object[initialCapacity];
        //指定顺序表的元素个数，默认是0
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //如果i < 0或者i >= elementData.length
        if (i < 0 || i >= elementData.length){
            throw new MyArrayIndexOutOfBoundsException("数组索引越界异常：" + i);
        }
        return elementData[i];
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
        //i的位置要正确
        if (i < 0 || i > size){
            throw new MyArrayIndexOutOfBoundsException("数组索引越界异常：" + i);
        }
        if (size == elementData.length){
            grow();
        }
        //后移i及其后面元素，从最后一个元素开始
        for (int j = size; j > i; j--){
            elementData[j] = elementData[j-1];
        }
        //给数组第i个位置赋值
        elementData[i] = e;
        //元素个数+1
        size++;
    }

    /**
     * java.util.ArrayList每次增长50%
     * @param e 增加的元素
     */
    @Override
    public void add(Object e) {
        this.add(size,e);
//        if (size == elementData.length) {
//            grow();
//        }
//        //给数组赋值
//        elementData[size] = e;
//        //元素个数加1
//        size++;
    }

    private void grow(){
        //如果数组满了，就扩容
        //新创建一个新的数组，长度是就数组的二倍
        Object[] newArr = new Object[size * 2];
        //将数组的数据拷贝到新数组中
        for (int i = 0; i < size; i++){
            newArr[i] = elementData[i];
        }
        //让elementData指向新数组
        elementData = newArr;
        //上述扩容语句可以写为：elementData = Arrays.copyOf(elementData,elementData.length*2);

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
        return false;
    }

    @Override
    public Object replace(int i, Object e) {
        return null;
    }

    /**
     * 重写toString方法
     * @return 返回[123,321,456,666,678,...]
     */
    @Override
    public String toString() {
        if (size == 0){
            return "[]";
        }
        StringBuilder sb = new StringBuilder();
        sb.append("[");
        for (int i = 0; i < size; i++){
            if (i != size-1){
                sb.append(elementData[i] + ",");
            }else {
                sb.append(elementData[i]);
            }
        }
        sb.append("]");
        return sb.toString();
    }
}
