package com.company.datastructure.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author thinkpad
 */
public class LinkedBinaryTree implements BinaryTree {
    /**
     * ���ڵ�
     */
    private Node root;

    public LinkedBinaryTree(Node node1) {
        this.root = node1;
    }

    public LinkedBinaryTree() {
    }


    @Override
    public boolean isEmpty() {
        System.out.print("�������Ƿ�Ϊ�գ�");
        return root == null;
    }

    @Override
    public int size() {
        System.out.print("����������ڵ�ĸ�����");
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null){
            return 0;
        }else {
            //��ȡ�������Ľڵ�
            int nl = this.size(root.leftChild);
            //��ȡ�������Ľڵ�
            int nr = this.size(root.rightChild);
            //�������������������ĺͲ���1
            return nl+nr+1;
        }
    }

    @Override
    public int getHeight() {
        System.out.print("�������ĸ߶��ǣ�");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null){
            return 0;
        }else {
            //��ȡ�������ĸ߶�
            int nl = this.getHeight(root.leftChild);
            //��ȡ�������ĸ߶�
            int nr = this.getHeight(root.rightChild);
            //�������������������ϴ�߶Ȳ���1
            return nl > nr ? nl+1 : nr+1;
        }
    }

    @Override
    public Node findKey(int value) {
        System.out.print("���ҵ�ֵΪ" + value + "�Ľڵ㣺");
        return this.findKey(value,root);
    }

    private Node findKey(Object value, Node root) {
        if (root == null){
            //�ݹ��������1���ڵ�Ϊnull���������������ĸ��ڵ㣬Ҳ�����ǵݹ������Ҷ�ӽڵ�����Ӻ��Һ���
            return null;
        }else if (root != null && root.value == value){
            //�ݹ��������2���ҵ���
            return root;
        }else {
            //�ݹ���
            Node node1 = this.findKey(value,root.leftChild);
            Node node2 = this.findKey(value,root.rightChild);
            if (node1 != null && node1.value == value){
                return node1;
            }else if (node2 != null && node2.value == value){
                return node2;
            }else {
                return null;
            }
        }
    }

    @Override
    public void preOrderTraverse() {
        System.out.print("���������");
        this.preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node root){
        if (root != null){
            //������ڵ��ֵ
            System.out.print(root.value + "\t");
            //�������������������������һ���������������������ĸ�
            this.preOrderTraverse(root.leftChild);
            //�������������������������һ���������������������ĸ�
            this.preOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.print("���������");
        this.inOrderTraverse(root);
        System.out.println();
    }

    /**
     * ���и�������
     */
    private void inOrderTraverse(Node root){
        if (root != null){
            //����������
            this.inOrderTraverse(root.leftChild);
            //�������ֵ
            System.out.print(root.value + "\t");
            //����������
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.print("����������");
        this.postOrderTraverse(root);
        System.out.println();
    }

    @Override
    public void postOrderTraverse(Node node) {
        if (node != null){
            //����������
            this.postOrderTraverse(node.leftChild);
            //����������
            this.postOrderTraverse(node.rightChild);
            //�������ֵ
            System.out.print(node.value + "\t");
        }
    }

    @Override
    public void inOrderByStack() {
        //ջ����ȳ�
        System.out.print("����ǵݹ������");
        //����ջ
        Deque<Node> stack = new LinkedList<>();
        Node current = root;
        while (current != null || !stack.isEmpty()){
            while (current != null){
                stack.push(current);
                current = current.leftChild;
            }
            if (!stack.isEmpty()){
                current = stack.pop();
                System.out.print(current.value + "\t");
                current = current.rightChild;
            }
        }
        System.out.println();
    }

    @Override
    public void preOrderByStack() {

    }

    @Override
    public void postOrderByStack() {

    }

    @Override
    public void levelOrderByStack() {
        //�����Ƚ��ȳ�
        System.out.print("���ղ�α���������:");
        if (root == null){
            return;
        }
        Queue<Node> queue = new LinkedList<>();
        queue.add(root);
        while (queue.size() != 0){
            int len = queue.size();
            for (int i = 0; i < len; i++){
                Node temp = queue.poll();
                assert temp != null;
                System.out.print(temp.value + "\t");
                if (temp.leftChild != null){
                    queue.add(temp.leftChild);
                }
                if (temp.rightChild != null){
                    queue.add(temp.rightChild);
                }
            }
        }
        System.out.println();
    }
}
