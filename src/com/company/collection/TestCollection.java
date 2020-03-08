package com.company.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections�������ʹ��
 * Collections�ǽӿڣ�Collections�ǹ�����
 * @author �ƽ���
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add("huang:" + i);
        }

        System.out.println(list);
        //�������list�е�Ԫ��
        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        //��������list
        System.out.println(list);
        //���յ����ķ�ʽ�����Զ������ʹ����ʹ��comparable�ӿ�
        Collections.sort(list);

        System.out.println(Collections.binarySearch(list,"��ɽ"));
        System.out.println(Collections.binarySearch(list,"huang:1"));
    }
}
