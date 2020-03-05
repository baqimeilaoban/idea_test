package cn.sxt.oo2;

/**
 * ����Object��
 * @author �ƽ���
 */
public class TestObject {
    public static void main(String[] args) {
        //Object obj;

        TestObject to = new TestObject();
        System.out.println(to.toString());

        Person2 person2 = new Person2();
        person2.age = 25;
        person2.name = "�ƽ���";
        System.out.println(person2.toString());

        Person2 person21 = new Person2("��1",17);
        System.out.println(person21.toString());
    }

    /**
     * ��дtoString����
     * @return
     */
    @Override
    public String toString(){
        return "����Object����";
    }
}

class Person2{
    String name;
    int age;

    @Override
    public String toString(){
        return name + ",����" + age;
    }

    /**
     * ������
     * @param name������
     * @param age������
     */
    public Person2(String name, int age){
        this.name = name;
        this.age = age;
    }

    /**
     * �չ�����
     */
    public Person2(){}
}