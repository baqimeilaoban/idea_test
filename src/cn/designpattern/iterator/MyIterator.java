package cn.designpattern.iterator;

/**
 * �Զ���ĵ������ӿ�
 * @author �ƽ���
 */
public interface MyIterator {
    /**
     * ���α�ָ���һ��Ԫ��
     */
    void first();
    /**
     * ���α�ָ����һ��Ԫ��
     */
    void next();
    /**
     * �ж��Ƿ������һ��Ԫ��
     */
    boolean hasNext();

    boolean isFirst();
    boolean isLast();

    /**
     * ��ȡ��ǰ�α�ָ��Ķ���
     */
    Object getCurrentObj();
}
