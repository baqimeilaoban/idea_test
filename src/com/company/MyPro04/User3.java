package com.company.MyPro04;

/**
 * 测试static
 * @author 黄建波
 */
public class User3 {
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
    static String company;

    static {
        System.out.println("执行类的初始化工作！");
        company = "北京尚学堂";
        printCompany();
    }

    public static void printCompany(){
        System.out.println(company);
    }

    public static void main(String[] args) {
        User3 u3 = null;
    }
}
