package cn.regex;

import java.util.regex.Matcher;
import java.util.regex.Pattern;

/**
 * @author »Æ½¨²¨
 */
public class Demo01 {
    static String regEx = "\\w+";
    static Pattern pattern = Pattern.compile(regEx);

    public static Matcher matchRegex(String str){
        Matcher matcher = pattern.matcher(str);
        return matcher;
    }

    public static void main(String[] args) {
        System.out.println(matchRegex("asfsdf23323").matches());

        while (matchRegex("asfsdf2&&3323").find()){
            System.out.println(matchRegex("asfsdf2&&3323").group());
            System.out.println(matchRegex("asfsdf2&&3323").group(0));
        }
    }

}

