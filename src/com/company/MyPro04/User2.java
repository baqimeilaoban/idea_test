package com.company.MyPro04;

/**
 * 测试static
 * @author 黄建波
 */
public class User2 {
    /**
     * id
     */
    int id;
    /**
     * 账户名
     */
    String name;
    /**
     * 密码
     */
    String pwd;
    /**
     * 公司名称
     */
    static String company = "北京尚学堂";

    public User2(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void login(){
        printCompany();
        System.out.println(company);
        System.out.println("登录：" + name);
    }

    public static void printCompany(){
        //login();调用非静态变量，编译就会出错
        System.out.println(company);
    }

    public static void main(String[] args) {
        User2 u = new User2(101,"高小七");
        User2.printCompany();
        User2.company = "北京阿里爷爷";
        User2.printCompany();
        u.login();
    }
}
