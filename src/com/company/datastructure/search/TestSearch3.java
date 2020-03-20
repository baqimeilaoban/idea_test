package com.company.datastructure.search;

public class TestSearch3 {
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
     * 使用递归
     * T(n) = O(logn)
     * S(n) = O(logn)
     * @param array 数组
     * @param key 查找的值
     * @return 索引
     */
    static int binarySearch(int[] array, int key){
        //指定low和high
        int low = 0;
        int high = array.length - 1;
        return binarySearch(array,key,low,high);
    }

    static int binarySearch(int[] array,int key,int low,int high){
        //递归的结束条件
        if (low > high){
            return -1;
        }
        int mid = (low + high) / 2;
        if (key == array[mid]){
            return mid;
        }else if(key < array[mid]){
            return binarySearch(array,key,low,mid-1);
        }else {
            return binarySearch(array,key,mid+1,high);
        }
    }
}
