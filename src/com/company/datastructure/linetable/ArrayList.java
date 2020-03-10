package com.company.datastructure.linetable;

import java.util.Arrays;

/**
 * ˳���
 * �ײ���õ����飬�����ȿ��Զ�̬�仯
 * ���������������
 * @author �ƽ���
 */
public class ArrayList implements List {
    /**
     * �ײ���һ�����飬Ŀǰûȷ������
     */
    private Object[] elementData;
    /**
     * ������������˼����ռ䣬����Ԫ�صĸ���
     */
    private int size;

    /**
     * û��ָ�����ȣ�Ĭ�ϳ�����4
     */
    public ArrayList(){
        //û��ָ�����ȣ�Ĭ�ϳ�����4
        this(4);
    }

    /**
     * ������
     * @param initialCapacity ����ĳ�ʼ����
     */
    public ArrayList(int initialCapacity){
        //���������ָ�������Ŀռ�
        elementData = new  Object[initialCapacity];
        //ָ��˳����Ԫ�ظ�����Ĭ����0
        size = 0;
    }

    @Override
    public int size() {
        return size;
    }

    @Override
    public Object get(int i) {
        //���i < 0����i >= elementData.length
        if (i < 0 || i >= elementData.length){
            throw new MyArrayIndexOutOfBoundsException("��������Խ���쳣��" + i);
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
        //i��λ��Ҫ��ȷ
        if (i < 0 || i > size){
            throw new MyArrayIndexOutOfBoundsException("��������Խ���쳣��" + i);
        }
        if (size == elementData.length){
            grow();
        }
        //����i�������Ԫ�أ������һ��Ԫ�ؿ�ʼ
        for (int j = size; j > i; j--){
            elementData[j] = elementData[j-1];
        }
        //�������i��λ�ø�ֵ
        elementData[i] = e;
        //Ԫ�ظ���+1
        size++;
    }

    /**
     * java.util.ArrayListÿ������50%
     * @param e ���ӵ�Ԫ��
     */
    @Override
    public void add(Object e) {
        this.add(size,e);
//        if (size == elementData.length) {
//            grow();
//        }
//        //�����鸳ֵ
//        elementData[size] = e;
//        //Ԫ�ظ�����1
//        size++;
    }

    private void grow(){
        //����������ˣ�������
        //�´���һ���µ����飬�����Ǿ�����Ķ���
        Object[] newArr = new Object[size * 2];
        //����������ݿ�������������
        for (int i = 0; i < size; i++){
            newArr[i] = elementData[i];
        }
        //��elementDataָ��������
        elementData = newArr;
        //��������������дΪ��elementData = Arrays.copyOf(elementData,elementData.length*2);

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
     * ��дtoString����
     * @return ����[123,321,456,666,678,...]
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
