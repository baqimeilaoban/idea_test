package com.company.datastructure.search;

/**
 * 前提：顺序结构，按照关键字有序
 * @author 黄建波
 */
public class TestSearch2 {
    public static void main(String[] args) {
        //给定数组
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //给定要查找的值
        int key = 6;
        //进行折半查找
        int index = binarySearch(array,key);
        //输出结果
        if (index == -1){
            System.out.println("不存在");
        }else {
            System.out.println(key + "的索引是：" + index);
        }
    }

    /**
     * 不使用递归
     * T(n) = O(logn)
     * S(n) = O(1)
     * @param array 数组
     * @param key 要查找的值
     * @return 索引
     */
    public static int binarySearch(int[] array,int key){
         //指定low和high
        int low = 0;
        int hight = array.length-1;
        //折半查找
        while (low <= hight){
            //求的mid
            int mid = (low + hight) / 2;
            //判断是否等于
            if (key == array[mid]){
                return mid;
            }else if (key < array[mid]){
                hight = mid - 1;
            }else {
                low = mid + 1;
            }
        }
        return -1;
    }
}
