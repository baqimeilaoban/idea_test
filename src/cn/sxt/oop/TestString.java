package cn.sxt.oop;

/**
 * 测试String字符串
 * @author 黄建波
 */
public class TestString {
    public static void main(String[] args) {
        String str = "abc";
        String str2 = new String("def");
        String str3 = "abc" + "defgh";
        //此时不是加法，是连接符
        String str4 = "18" + 19;
        System.out.println(str4);

        System.out.println("**************************");
        String str10 = "gaoqi";
        String str11 = "gaoqi";
        String str12 = new String("gaoqi");

        //==比较的是对象
        System.out.println(str10 == str11);
        System.out.println(str10.equals(str11));
        //str11和str12不是同一个对象
        System.out.println(str11 == str12);

        //通常比较字符串使用的是equals，equals比较的是内容
        System.out.println(str11.equals(str12));
    }
}
