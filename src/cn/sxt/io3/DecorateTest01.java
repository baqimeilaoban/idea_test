package cn.sxt.io3;

/**
 * ʵ�ַŴ����������Ŵ�Ĺ���
 * @author �ƽ���
 */
public class DecorateTest01 {
    public static void main(String[] args) {
        Person p = new Person();
        p.say();

        //װ��
        Amplifier am = new Amplifier(p);
        am.say();
    }
}

interface Say{
    void say();
}

class Person implements Say{
    /**
     * �������
     */
    private int voice = 10;
    @Override
    public void say() {
        System.out.println("�˵�����Ϊ��" + this.getVoice());
    }

    public int getVoice() {
        return voice;
    }

    public void setVoice(int voice) {
        this.voice = voice;
    }
}

class Amplifier implements Say{
    /**
     * ����������װ�ηŴ�
     */
    private Person p;

    public Amplifier(Person p) {
        this.p = p;
    }

    @Override
    public void say() {
        System.out.println("�˵�����Ϊ��" + p.getVoice()*100);
        System.out.println("������������");
    }
}
