package cn.designpattern.strategy;

/**
 * ����;���Ĳ�������н���
 * �����Ļ���������㷨��ֱ�ӵĿͻ��˵��÷����ˣ�ʹ���㷨���Զ����ڿͻ��˶����ı仯
 * ���ʹ��spring������ע�빦�ܣ�������ͨ�������ļ�����̬��ע�벻ͬ�Ĳ��Զ��󣬶�̬���л���ͬ���㷨
 * @author �ƽ���
 */
public class Context {
    /**
     * ��ǰ���õ��㷨����
     */
    private Strategy strategy;

    /**
     * ����ͨ����������ע��
     * @param strategy ����
     */
    public Context(Strategy strategy) {
        this.strategy = strategy;
    }

    /**
     * ����ͨ��set������ע��
     * @param strategy ����
     */
    public void setStrategy(Strategy strategy) {
        this.strategy = strategy;
    }

    public void pringPrince(double s){
        System.out.println("��ı��ۣ�" + strategy.getPrice(s));
    }
}
