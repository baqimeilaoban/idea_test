package com.company.MyPro04;

/**
 * 测试参数传递
 * @author 黄建波
 */
public class User4 {
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

    public User4(int id, String name){
        this.id = id;
        this.name = name;
    }

    public void testParameterTransfer01(User4 u){
        u.name = "高小八";
    }

    public void testParameterTransfer02(User4 u){
        u = new User4(200,"高三");
    }

    public static void main(String[] args) {
        User4 u1 = new User4(100,"高小七");
        u1.testParameterTransfer01(u1);
        System.out.println(u1.name);
        u1.testParameterTransfer02(u1);
        //不会变为高三
        System.out.println(u1.name);
    }
}
