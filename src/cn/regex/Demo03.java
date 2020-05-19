package cn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * 测试正则表达式对象的替换操作
 * @author 黄建波
 */
public class Demo03 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher matcher = p.matcher("aa232**ssd445*sds223");
        //替换
        String newStr = matcher.replaceAll("#");
        System.out.println(newStr);
    }
}
