package cn.sxt.oop;

/**
 * 测试字符串的常用方法
 * @author 黄建波
 */
public class TestString2 {
    public static void main(String[] args) {
        String s1 = "core java";
        String s2 = "Core java";
        //提取下标为3的字符
        System.out.println(s1.charAt(3));
        //字符串的长度
        System.out.println(s2.length());
        //比较两个字符串是否相等
        System.out.println(s1.equals(s2));
        //比较两个字符串（忽略大小写）
        System.out.println(s1.equalsIgnoreCase(s2));
        //字符串s1中是否包含java
        System.out.println(s1.indexOf("java"));
        //字符串s1中是否包含apple
        System.out.println(s1.indexOf("apple"));
        //将s1中的空格替换成&
        String s = s1.replace(' ', '&');
        System.out.println("result is:" + s);

        String s3 = "";
        String s4 = "How are you?";
        //是否以How开头
        System.out.println(s4.startsWith("How"));
        //是否以you结尾
        System.out.println(s4.endsWith("you"));
        //提取子字符串：从下标为4的开始到字符串结尾为止
        s3 = s4.substring(4);
        System.out.println(s3);
        //提取子字符串：下标[4,7]不包括7
        s3 = s4.substring(4,7);
        System.out.println(s3);
        //转小写
        s3 = s4.toLowerCase();
        System.out.println(s3);
        //转大写
        s3 = s4.toUpperCase();
        System.out.println(s3);
        String s5 = "How old are you!!";
        //去掉字符串首尾的空格。注意：中间的空格不能去除
        s3 = s5.trim();
        System.out.println(s3);
        //因为String是不可变字符串，所以s5不变
        System.out.println(s5);
    }
}
