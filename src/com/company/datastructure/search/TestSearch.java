package com.company.datastructure.search;

/**
 * 功能：在分数中查找指定分数得索引
 * T(n) = O(n)
 * S(n) = O(1)
 * @author 黄建波
 */
public class TestSearch {
    public static void main(String[] args) {
        //给的分数数组
        int[] scoreArr = {89,45,78,45,100,98,86,100,65};
        //给定要查找得分数
        int score = 100;
        //完成查找
        int index = search(scoreArr,score);
        //输出结果
        if (index == -1){
            System.out.println("该分数不存在");
        }else {
            System.out.println(score + "的索引是：" + index);
        }
    }

    public static int search(int[] arr, int key){
        int index = -1;
        for (int i = 0; i < arr.length; i++){
            if (arr[i] == key){
                index = i;
                break;
            }
        }
        return index;
    }
}
