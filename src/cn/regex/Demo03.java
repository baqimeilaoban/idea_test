package cn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ������滻����
 * @author �ƽ���
 */
public class Demo03 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("[0-9]");
        Matcher matcher = p.matcher("aa232**ssd445*sds223");
        //�滻
        String newStr = matcher.replaceAll("#");
        System.out.println(newStr);
    }
}
