package com.company.MyPro04;

/**
 * ����static
 * @author �ƽ���
 */
public class User2 {
    /**
     * id
     */
    int id;
    /**
     * �˻���
     */
    String name;
    /**
     * ����
     */
    String pwd;
    /**
     * ��˾����
     */
    static String company = "������ѧ��";

    public User2(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void login(){
        printCompany();
        System.out.println(company);
        System.out.println("��¼��" + name);
    }

    public static void printCompany(){
        //login();���÷Ǿ�̬����������ͻ����
        System.out.println(company);
    }

    public static void main(String[] args) {
        User2 u = new User2(101,"��С��");
        User2.printCompany();
        User2.company = "��������үү";
        User2.printCompany();
        u.login();
    }
}
