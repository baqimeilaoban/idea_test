package com.company.MyPro08;

/**
 * 测试String
 * @author 黄建波
 */
public class TestString {
    public static void main(String[] args) {
        //前面加了final修饰，不能被改变，若需改变，则需重新赋值
        String str = "aaabbb";

        String str2 = str.substring(2,5);
        System.out.println(str);
        System.out.println(str2);

        //编译器做了优化直接在编译的时候将字符串进行了拼接
        String str3 = "hello" + " java";
        String str4 = "hello java";
        //true
        System.out.println(str3 == str4);
        String str5 = "hello";
        String str6 = "java";
        //编译的时候不知道变量中存储的是什么所以没办法在编译的时候优化
        String str7 = str3 + str4;
        //false
        System.out.println(str3 == str7);


        //做字符串比较时，使用equals方法，不要使用==
        System.out.println(str3.equals(str7));
    }
}
