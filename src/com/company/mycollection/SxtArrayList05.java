package com.company.mycollection;

/**
 * 增加remove方法
 * @author 黄建波
 */
public class SxtArrayList05<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * 数组容量
     */
    public SxtArrayList05(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * 数组大小界定
     * @param capacity：传的数组容量参数
     */
    public SxtArrayList05(int capacity){
        if (capacity < 0){
            throw new RuntimeException("容器的容量不能为负数！");
        }else if(capacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    /**
     * @return 数组长度
     */
    public int size(){
        return size;
    }

    /**
     * @return 判断该数组是否为空
     */
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /**
     * 索引的合法性判断
     * @param index：索引值
     */
    public void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("索引不合法：" + index);
        }
    }

    /**
     * 数组中添加元素
     * @param element：添加的元素
     */
    public void add(E element){
        if (size == elementData.length){
            Object[] newArray = new Object[elementData.length + (elementData.length >> 1)];
            System.arraycopy(elementData,0,newArray,0,elementData.length);
            elementData = newArray;
        }
        elementData[size++] = element;
    }

    /**
     * 得到索引值处的数组元素
     * @param index：索引值
     * @return 索引值处的数组元素
     */
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    /**
     * 将索引值处的元素替换为传进的element
     * @param element：传进的元素
     * @param index：索引值
     */
    public void set(E element, int index){
        checkRange(index);
        elementData[index] = element;
    }

    /**
     * 移除数组指定的元素
     * @param element：指定的元素
     */
    public void remove(E element){
        //element，将它和所有元素挨个比较，获得第一个比较为true的，返回
        for (int i = 0; i < size; i++){
            //容器中所有的比较操作，都是用的equals而不是==
            if (element.equals(get(i))){
                //将该元素从此处移除
                remove(i);
            }
        }
    }

    /**
     * 移除索引值处的元素
     * @param index：索引值
     */
    public void remove(int index){
        //a,b,c,d,e,f,g,h
        int numMoved = elementData.length-index-1;
        if (numMoved > 0){
            System.arraycopy(elementData,index+1,elementData,index,numMoved);
        }
        elementData[size - 1] = null;
        size--;
    }

    /**
     * 对toString方法进行重写
     * @return 返回重写后的数组
     */
    @Override
    public String toString() {
        StringBuilder sb = new StringBuilder();
        sb.append('[');
        for (int i = 0; i < size; i++){
            sb.append(elementData[i] + ",");
        }
        sb.setCharAt(sb.length()-1,']');
        return sb.toString();
    }

    public static void main(String[] args) {
        SxtArrayList05 s1 = new SxtArrayList05();

        for (int i = 0; i < 40; i++){
            s1.add("高" + i);
        }

        s1.set("sss",10);
        System.out.println(s1);
        System.out.println(s1.get(39));

        s1.remove(3);
        System.out.println(s1);
        s1.remove("高11");
        System.out.println(s1);
        System.out.println(s1.size());
        System.out.println(s1.isEmpty());
    }
}