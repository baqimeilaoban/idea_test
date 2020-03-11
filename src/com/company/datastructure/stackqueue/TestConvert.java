package com.company.datastructure.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * 将十进制转换为二进制
 * @author 黄建波
 */
public class TestConvert {
    public static void main(String[] args) {
        //给定一个十进制数
        int n = 13;
        //把十进制数转换为二进制数

        //定义一个空栈
        Deque stack = new LinkedList();
        //t表示被除数
        int t = n;
        do {
            // 除以2求余数
            int mod = t%2;
            //将余数入栈
            stack.push(mod);
            //除以2得到商
            int result = t / 2;
            //使用商做被除数
            t = result;
            //当商大于0
        }while (t > 0);
        //输出结果
        System.out.print(n + "------->" );
        //栈非空时
        while (!stack.isEmpty()){
            System.out.print(stack.poll());
        }
    }
}
