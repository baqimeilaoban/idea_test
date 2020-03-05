package com.company.MyPro04;

/**
 * 测试this关键字
 * @author 黄建波
 */
public class TestThis01 {
    /**
     * id
     */
    int id;
    /**
     * 用户名
     */
    String name;
    /**
     * 密码
     */
    String pwd;

    public TestThis01(){

    }

    public TestThis01(int id, String name){
        System.out.println("正在初始化已经创建好的对象：" + this);
        //不写this，无法区分局部变量id和成员变量id
        this.id = id;
        this.name = name;
    }

    void login(){
        //不屑this效果一样
        System.out.println(this.name + "，要登陆！");
    }

    public static void main(String[] args) {
        TestThis01 u3 = new TestThis01(101, "黄建波");
        System.out.println("打印黄建波对象：" + u3);
        u3.login();
    }
}
