package cn.sxt.oo;

import cn.sxt.oo2.Human;

/**
 * ���Է�װ
 * @author �ƽ���
 */
public class TestEncapsulation {
    public static void main(String[] args) {
        Human h = new Human();
        // h.name = "�ƽ���"; nameΪdefault���ԣ����ܱ���ͬ���������
        h.sayAge(); //�����ģ���ͬ�İ����ܵ���
    }
}

class Girl extends Human{
    void sayGood(){
        System.out.println(height);
    }
}
