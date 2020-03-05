package cn.sxt.oo2;

/**
 * ���Զ�̬
 * @author �ƽ���
 */
public class TestPolym {
    public static void main(String[] args) {
        Animal a = new Animal();
        animalCry(a);
        //�����Զ�ת��
        Animal d = new Dog();
        //d.seeDoor(); ����������ʶ������ǿ��ת��ΪDog����
        animalCry(d);
        animalCry(new Cat());
        //����ǿ��ת��
        Dog d2 = (Dog)d;
        d2.seeDoor();
    }

    /**
     * ��̬
     * @param a��������󣬸�������ָ���������
     */
    static void animalCry(Animal a){
        a.shout();
    }
}

class Animal{
    public void shout(){
        System.out.println("����һ��");
    }
}

class Dog extends Animal{
    /**
     * ��дshout����
     */
    @Override
    public void shout(){
        System.out.println("��������");
    }

    public void seeDoor(){
        System.out.println("���ţ�");
    }
}

class Cat extends Animal{
    /**
     * ��дshout����
     */
    @Override
    public void shout(){
        System.out.println("��������");
    }
}