package com.company.datastructure.linetable;

/**
 * ���Ա�ӿ�
 * �ʹ洢�ṹ�޹�
 * @author �ƽ���
 */
public interface List {
    /**
     * �������Ա�Ĵ�С��������Ԫ�صĸ���
     */
    public int size();

    /**
     * �������Ա������Ϊi������Ԫ��
     */
    public Object get(int i);

    /**
     * �������Ϊ�շ���true�����򷵻�false
     */
    public boolean isEmpty();

    /**
     * �ж����Ա��Ƿ��������Ԫ��e
     */
    public boolean contains(Object e);

    /**
     * ��������Ԫ��e�����Ա��е����
     */
    public int indexOf(Object e);

    /**
     * ������Ԫ��e���뵽���Ա���i��λ��
     */
    public void add(int i, Object e);

    /**
     * ������Ԫ��e���뵽���Ա�ĩβ
     */
    public void add(Object e);

    /**
     * ������Ԫ��e���뵽Ԫ��obj֮ǰ
     */
    public boolean addBefore(Object obj, Object e);

    /**
     * ������Ԫ��e���뵽Ԫ��obj֮��
     */
    public boolean addAfter(Object obj, Object e);

    /**
     * ɾ�����Ա������Ϊi��Ԫ�أ�������
     */
    public Object remove(int i);

    /**
     * ɾ����һ����e��ͬ��Ԫ��
     */
    public boolean remove(Object e);

    /**
     * �滻���Ա������Ϊi������Ԫ��e������ԭ����Ԫ��
     */
    public Object replace(int i, Object e);

}


