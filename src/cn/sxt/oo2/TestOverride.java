package cn.sxt.oo2;

/**
 * ������д(Override)
 * @author �ƽ���
 */
public class TestOverride {
    public static void main(String[] args) {
        System.out.println("����ʼ��");
        Horse h = new Horse();
        h.run();
    }
}

class Vehicle{
    public void run(){
        System.out.println("��......");
    }

    public void stop(){
        System.out.println("ֹͣ��");
    }

    public Person WhoIsPsg(){
        return new Person();
    }
}

class  Horse extends Vehicle{

    @Override
    /**
     * ���ȵ����Լ���ʵ��
     */
    public void run(){
        System.out.println("���㷭�ɣ��õõõ�");
    }

    @Override
    public Student WhoIsPsg(){
        return new Student();
    }
}