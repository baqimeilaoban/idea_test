package com.company.collection;

import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/**
 * Collections辅助类的使用
 * Collections是接口，Collections是工具类
 * @author 黄建波
 */
public class TestCollection {
    public static void main(String[] args) {
        List<String> list = new ArrayList<>();
        for (int i = 0; i < 10; i++){
            list.add("huang:" + i);
        }

        System.out.println(list);
        //随机排列list中的元素
        Collections.shuffle(list);
        System.out.println(list);
        Collections.reverse(list);
        //逆序排列list
        System.out.println(list);
        //按照递增的方式排序。自定义类的使用则使用comparable接口
        Collections.sort(list);

        System.out.println(Collections.binarySearch(list,"张山"));
        System.out.println(Collections.binarySearch(list,"huang:1"));
    }
}
