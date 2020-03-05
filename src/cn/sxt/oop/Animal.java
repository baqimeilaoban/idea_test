package cn.sxt.oop;

/**
 * ���Գ�����
 * ��������������ڣ�Ϊ�����ṩͳһ�ģ��淶��ģ�壬�������ʵ����صĳ��󷽷�
 * @author �ƽ���
 */
public abstract class Animal {
    /**
     * ���󷽷�û��ʵ��
     * ��һ������û��ʵ��
     * �ڶ����������ʵ��
     */
    abstract public void shout();

    public void run(){
        System.out.println("�ܰ��ܣ�");
    }

    public static void main(String[] args) {
        Animal d = new Dog();
        d.shout();
    }
}

class Dog extends Animal{

    @Override
    public void shout() {
        System.out.println("��������");
    }
}
