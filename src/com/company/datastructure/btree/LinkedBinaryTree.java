package com.company.datastructure.btree;

import java.util.Deque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @author thinkpad
 */
public class LinkedBinaryTree implements BinaryTree {
    /**
     * 根节点
     */
    private Node root;

    public LinkedBinaryTree(Node node1) {
        this.root = node1;
    }

    public LinkedBinaryTree() {
    }


    @Override
    public boolean isEmpty() {
        System.out.print("二叉树是否为空：");
        return root == null;
    }

    @Override
    public int size() {
        System.out.print("输出二叉树节点的个数：");
        return this.size(root);
    }

    private int size(Node root) {
        if (root == null){
            return 0;
        }else {
            //获取左子树的节点
            int nl = this.size(root.leftChild);
            //获取右子树的节点
            int nr = this.size(root.rightChild);
            //返回左子树和右子树的和并加1
            return nl+nr+1;
        }
    }

    @Override
    public int getHeight() {
        System.out.print("二叉树的高度是：");
        return this.getHeight(root);
    }

    private int getHeight(Node root) {
        if (root == null){
            return 0;
        }else {
            //获取左子树的高度
            int nl = this.getHeight(root.leftChild);
            //获取右子树的高度
            int nr = this.getHeight(root.rightChild);
            //返回左子树，右子树较大高度并加1
            return nl > nr ? nl+1 : nr+1;
        }
    }

    @Override
    public Node findKey(int value) {
        System.out.print("查找的值为" + value + "的节点：");
        return this.findKey(value,root);
    }

    private Node findKey(Object value, Node root) {
        if (root == null){
            //递归结束条件1：节点为null，可能是整个树的根节点，也可能是递归调用中叶子节点的左孩子和右孩子
            return null;
        }else if (root != null && root.value == value){
            //递归结束条件2：找到了
            return root;
        }else {
            //递归体
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
        System.out.print("先序遍历：");
        this.preOrderTraverse(root);
        System.out.println();
    }

    private void preOrderTraverse(Node root){
        if (root != null){
            //输出根节点的值
            System.out.print(root.value + "\t");
            //对左子树进行先序遍历，构建一个二叉树，根是左子树的根
            this.preOrderTraverse(root.leftChild);
            //对右子树进行先序遍历，构建一个二叉树，根是右子树的根
            this.preOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void inOrderTraverse() {
        System.out.print("中序遍历：");
        this.inOrderTraverse(root);
        System.out.println();
    }

    /**
     * 进行辅助操作
     */
    private void inOrderTraverse(Node root){
        if (root != null){
            //遍历左子树
            this.inOrderTraverse(root.leftChild);
            //输出根的值
            System.out.print(root.value + "\t");
            //遍历右子树
            this.inOrderTraverse(root.rightChild);
        }
    }

    @Override
    public void postOrderTraverse() {
        System.out.print("后续遍历：");
        this.postOrderTraverse(root);
        System.out.println();
    }

    @Override
    public void postOrderTraverse(Node node) {
        if (node != null){
            //遍历左子树
            this.postOrderTraverse(node.leftChild);
            //遍历右子树
            this.postOrderTraverse(node.rightChild);
            //输出根的值
            System.out.print(node.value + "\t");
        }
    }

    @Override
    public void inOrderByStack() {
        //栈后进先出
        System.out.print("中序非递归遍历：");
        //创建栈
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
        //队列先进先出
        System.out.print("按照层次遍历二叉树:");
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
