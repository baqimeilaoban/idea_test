package cn.sxt.oo2;

/**
 * ���Է�װ
 * @author �ƽ���
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
        h.name = "�ƽ���";
        h.height = 230;

        Person4Encapsulation p4 = new Person4Encapsulation();
        p4.setAge(-14);
        System.out.println(p4.getAge());
    }
}

class Boy extends Human{
    void sayHello(){
        //System.out.println(age); �����޷�ʹ�ø����˽�����Է���
    }
}
