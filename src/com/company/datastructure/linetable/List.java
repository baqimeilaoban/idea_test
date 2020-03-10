package com.company.datastructure.linetable;

/**
 * 线性表接口
 * 和存储结构无关
 * @author 黄建波
 */
public interface List {
    /**
     * 返回线性表的大小，即数据元素的个数
     */
    public int size();

    /**
     * 返回线性表中序号为i的数据元素
     */
    public Object get(int i);

    /**
     * 如果线性为空返回true，否则返回false
     */
    public boolean isEmpty();

    /**
     * 判断线性表是否包含数据元素e
     */
    public boolean contains(Object e);

    /**
     * 返回数据元素e在线性表中的序号
     */
    public int indexOf(Object e);

    /**
     * 将数据元素e插入到线性表中i号位置
     */
    public void add(int i, Object e);

    /**
     * 将数据元素e插入到线性表末尾
     */
    public void add(Object e);

    /**
     * 将数据元素e插入到元素obj之前
     */
    public boolean addBefore(Object obj, Object e);

    /**
     * 将数据元素e插入到元素obj之后
     */
    public boolean addAfter(Object obj, Object e);

    /**
     * 删除线性表中序号为i的元素，并返回
     */
    public Object remove(int i);

    /**
     * 删除第一个与e相同的元素
     */
    public boolean remove(Object e);

    /**
     * 替换线性表中序号为i的数据元素e，返回原数据元素
     */
    public Object replace(int i, Object e);

}


