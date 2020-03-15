package com.company.datastructure.btree;

/**
 * �������ӿ�
 * �����в�ͬ��ʵ���࣬ÿ�������ʹ�ò�ͬ�Ĵ洢�ṹ������˳��ṹ����ʽ�ṹ
 * @author �ƽ���
 */
public interface BinaryTree {

    /**
     * �Ƿ����
     */
    public boolean isEmpty();

    /**
     * ���ڵ�����
     */
    public int size();

    /**
     * ��ȡ�������ĸ߶�
     */
    public int getHeight();

    /**
     * ��ѯָ��ֵ�Ľڵ�
     */
    public Node findKey(int value);

    /**
     * ǰ��ݹ����
     */
    public void preOrderTraverse();

    /**
     * ��������ݹ����
     */
    public void inOrderTraverse();

    /**
     * ��������ݹ����
     */
    public void postOrderTraverse();

    /**
     * ��������ݹ����
     * @param node �����ڵ�
     */
    public void postOrderTraverse(Node node);

    /**
     * ����Ǳ����ݹ����
     * 1����������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹ�ߣ������������ڵ���Ϊcurrent���ظ��˲�����ֱ��
     * 2����������Ϊ�գ�ջ���ڵ��ջ�����ʽڵ�󽫸ýڵ����������Ϊcurrent
     * 3���ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ��
     */
    public void inOrderByStack();

    /**
     * ǰ������ǵݹ����
     * 1����������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹ�ߣ������������ڵ���Ϊcurrent���ظ��˲�����ֱ��
     * 2����������Ϊ�գ�ջ���ڵ��ջ�����ʽڵ�󽫸ýڵ����������Ϊcurrent
     * 3���ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ��
     */
    public void preOrderByStack();

    /**
     * ����ǵݹ����
     * 1����������ڵ�current�����ýڵ㲻Ϊ���򽫸ýڵ�ѹ�ߣ������������ڵ���Ϊcurrent���ظ��˲�����ֱ��
     * 2����������Ϊ�գ�ջ���ڵ��ջ�����ʽڵ�󽫸ýڵ����������Ϊcurrent
     * 3���ظ�1��2��������ֱ��currentΪ����ջ�ڽڵ�Ϊ��
     */
    public void postOrderByStack();

    /**
     * ���ղ�α���������
     */
    public void levelOrderByStack();
}
