package com.company.datastructure.btree;

/**
 * ��������Ľڵ�
 * @author �ƽ���
 */
public class Node {
    /**
     * value:���ֵ
     */
    Object value;
    /**
     * ������������
     */
    Node leftChild;
    /**
     * ������������
     */
    Node rightChild;

    public Node(Object value) {
        this.value = value;
    }

    public Node(Object value, Node leftChild, Node rightChild) {
        this.value = value;
        this.leftChild = leftChild;
        this.rightChild = rightChild;
    }

    @Override
    public String toString() {
        return "Node{" +
                "value=" + value +
                ", leftChild=" + leftChild +
                ", rightChild=" + rightChild +
                '}';
    }
}
