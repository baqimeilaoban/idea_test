package cn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * ����������ʽ�����ַ���ô���
 * @author �ƽ���
 */
public class Demo02 {
    public static void main(String[] args) {
        Pattern p = Pattern.compile("([a-z]+)([--9]+)");
        Matcher m = p.matcher("aa232**ssd445*sds223");
        while (m.find()){
            System.out.println(m.group());
            System.out.println(m.group(1));
            System.out.println(m.group(2));
        }
    }
}
