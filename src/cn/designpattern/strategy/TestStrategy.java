package cn.designpattern.strategy;

/**
 * ʵ�������Ƚ����ף�����һ�㿪����Ա��˼·
 * ���磬�����ر�࣬�㷨�Ƚϸ���ʱ�������������Ĵ���ͱ�úܳ�������ά��
 * ������������ͣ�����ҪƵ�����޸Ĵ˴�����
 * �����Ͽ���ԭ��
 * @author �ƽ���
 */
public class TestStrategy {
    public double getPrice(String type,double price){
        if ("��ͨ�ͻ�С����".equals(type)){
            System.out.println("�����ۣ�ԭ�ۣ�");
            return price;
        }else if ("��ͨ�ͻ�������".equals(type)){
            System.out.println("�����");
            return price*0.9;
        }else if ("�Ͽͻ�С����".equals(type)){
            System.out.println("�������");
            return price*0.85;
        }else if ("�Ͽͻ�������".equals(type)){
            System.out.println("�����");
            return price*0.8;
        }
        return price;
    }
}
