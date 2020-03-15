package com.company.datastructure.btree;

/**
 * 二叉树接口
 * 可以有不同的实现类，每个类可以使用不同的存储结构，比如顺序结构，链式结构
 * @author 黄建波
 */
public interface BinaryTree {

    /**
     * 是否空树
     */
    public boolean isEmpty();

    /**
     * 树节点数量
     */
    public int size();

    /**
     * 获取二叉树的高度
     */
    public int getHeight();

    /**
     * 查询指定值的节点
     */
    public Node findKey(int value);

    /**
     * 前序递归遍历
     */
    public void preOrderTraverse();

    /**
     * 中序遍历递归操作
     */
    public void inOrderTraverse();

    /**
     * 后序遍历递归操作
     */
    public void postOrderTraverse();

    /**
     * 后序遍历递归操作
     * @param node 树根节点
     */
    public void postOrderTraverse(Node node);

    /**
     * 中序非遍历递归操作
     * 1）对于任意节点current，若该节点不为空则将该节点压线，并将左子树节点置为current，重复此操作，直到
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3）重复1、2步操作，直到current为空且栈内节点为空
     */
    public void inOrderByStack();

    /**
     * 前序遍历非递归操作
     * 1）对于任意节点current，若该节点不为空则将该节点压线，并将左子树节点置为current，重复此操作，直到
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3）重复1、2步操作，直到current为空且栈内节点为空
     */
    public void preOrderByStack();

    /**
     * 后序非递归操作
     * 1）对于任意节点current，若该节点不为空则将该节点压线，并将左子树节点置为current，重复此操作，直到
     * 2）若左子树为空，栈顶节点出栈，访问节点后将该节点的右子树置为current
     * 3）重复1、2步操作，直到current为空且栈内节点为空
     */
    public void postOrderByStack();

    /**
     * 按照层次遍历二叉树
     */
    public void levelOrderByStack();
}
