package cn.sxt.oo2;

/**
 * ����super�ؼ���
 * @author �ƽ���
 */
public class TestSuper02 {
    public static void main(String[] args) {
        System.out.println("��ʼ����һ��ChildClass����...");
        new ChildClass2();
    }
}

class FatherClass2{
    public FatherClass2(){
        System.out.println("����FatherClass");
    }
}

class ChildClass2 extends FatherClass2{
    public ChildClass2(){
        //��������һ�仰����super();
        System.out.println("����ChildClass");
    }
}

