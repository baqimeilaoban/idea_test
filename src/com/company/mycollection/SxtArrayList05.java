package com.company.mycollection;

/**
 * ����remove����
 * @author �ƽ���
 */
public class SxtArrayList05<E> {
    private Object[] elementData;
    private int size;
    private static final int DEFAULT_CAPACITY = 10;

    /**
     * ��������
     */
    public SxtArrayList05(){
        elementData = new Object[DEFAULT_CAPACITY];
    }

    /**
     * �����С�綨
     * @param capacity������������������
     */
    public SxtArrayList05(int capacity){
        if (capacity < 0){
            throw new RuntimeException("��������������Ϊ������");
        }else if(capacity == 0){
            elementData = new Object[DEFAULT_CAPACITY];
        }else {
            elementData = new Object[capacity];
        }
    }

    /**
     * @return ���鳤��
     */
    public int size(){
        return size;
    }

    /**
     * @return �жϸ������Ƿ�Ϊ��
     */
    public boolean isEmpty(){
        return size == 0 ? true : false;
    }

    /**
     * �����ĺϷ����ж�
     * @param index������ֵ
     */
    public void checkRange(int index){
        if (index < 0 || index > size - 1){
            throw new RuntimeException("�������Ϸ���" + index);
        }
    }

    /**
     * ���������Ԫ��
     * @param element����ӵ�Ԫ��
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
     * �õ�����ֵ��������Ԫ��
     * @param index������ֵ
     * @return ����ֵ��������Ԫ��
     */
    public E get(int index){
        checkRange(index);
        return (E) elementData[index];
    }

    /**
     * ������ֵ����Ԫ���滻Ϊ������element
     * @param element��������Ԫ��
     * @param index������ֵ
     */
    public void set(E element, int index){
        checkRange(index);
        elementData[index] = element;
    }

    /**
     * �Ƴ�����ָ����Ԫ��
     * @param element��ָ����Ԫ��
     */
    public void remove(E element){
        //element������������Ԫ�ذ����Ƚϣ���õ�һ���Ƚ�Ϊtrue�ģ�����
        for (int i = 0; i < size; i++){
            //���������еıȽϲ����������õ�equals������==
            if (element.equals(get(i))){
                //����Ԫ�شӴ˴��Ƴ�
                remove(i);
            }
        }
    }

    /**
     * �Ƴ�����ֵ����Ԫ��
     * @param index������ֵ
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
     * ��toString����������д
     * @return ������д�������
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
            s1.add("��" + i);
        }

        s1.set("sss",10);
        System.out.println(s1);
        System.out.println(s1.get(39));

        s1.remove(3);
        System.out.println(s1);
        s1.remove("��11");
        System.out.println(s1);
        System.out.println(s1.size());
        System.out.println(s1.isEmpty());
    }
}