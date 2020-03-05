package com.company.MyPro08;

/**
 * 测试StringBuilder，StringBuffer可变字符序列的常用方法
 * @author 黄建波
 */
public class TestStringBuilder2 {
    public static void main(String[] args) {
        StringBuilder sb = new StringBuilder();
        for(int i = 0; i < 26; i++){
            char temp = (char)('a' + i);
            sb.append(temp);
        }
        System.out.println(sb);

        //测试reverse
        sb.reverse();
        System.out.println(sb);
        //测试setCharAt
        sb.setCharAt(3,'高');
        System.out.println(sb);
        //测试insert
        sb.insert(0,'我');
        System.out.println(sb);
        //测试insert链式调用，核心就是该方法调用了return this，把自己返回了
        sb.insert(0,'他').insert(6,'爱').insert(10," ");
        System.out.println(sb);
        //测试delete，也可使用链式调用
        sb.delete(20,23);
        System.out.println(sb);
    }
}
