package com.company.datastructure.stackqueue;

import java.util.Deque;
import java.util.LinkedList;

/**
 * ��ʮ����ת��Ϊ������
 * @author �ƽ���
 */
public class TestConvert {
    public static void main(String[] args) {
        //����һ��ʮ������
        int n = 13;
        //��ʮ������ת��Ϊ��������

        //����һ����ջ
        Deque stack = new LinkedList();
        //t��ʾ������
        int t = n;
        do {
            // ����2������
            int mod = t%2;
            //��������ջ
            stack.push(mod);
            //����2�õ���
            int result = t / 2;
            //ʹ������������
            t = result;
            //���̴���0
        }while (t > 0);
        //������
        System.out.print(n + "------->" );
        //ջ�ǿ�ʱ
        while (!stack.isEmpty()){
            System.out.print(stack.poll());
        }
    }
}
