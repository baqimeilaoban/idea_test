package com.company.MyPro04;

/**
 * ����this�ؼ���
 * @author �ƽ���
 */
public class TestThis01 {
    /**
     * id
     */
    int id;
    /**
     * �û���
     */
    String name;
    /**
     * ����
     */
    String pwd;

    public TestThis01(){

    }

    public TestThis01(int id, String name){
        System.out.println("���ڳ�ʼ���Ѿ������õĶ���" + this);
        //��дthis���޷����־ֲ�����id�ͳ�Ա����id
        this.id = id;
        this.name = name;
    }

    void login(){
        //��мthisЧ��һ��
        System.out.println(this.name + "��Ҫ��½��");
    }

    public static void main(String[] args) {
        TestThis01 u3 = new TestThis01(101, "�ƽ���");
        System.out.println("��ӡ�ƽ�������" + u3);
        u3.login();
    }
}
