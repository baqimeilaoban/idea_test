package com.company.MyPro07;

import java.util.Arrays;

/**
 * ���Զ��ַ����ң��۰������
 * @author �ƽ���
 */
public class TtestBinarySearch {
    public static void main(String[] args) {
        int[] arr = {30,20,50,10,80,9,7,12,100,40,8};
        Arrays.sort(arr);
        System.out.println(Arrays.toString(arr));
        //Ҫ���ҵ�ֵ
        System.out.println(myBinarySeach(arr,40));
        System.out.println(myBinarySeach(arr,400));

    }

    public static int myBinarySeach(int[] arr, int value){
        int low = 0;
        int high = arr.length-1;
        while (low <= high){
            int mid = (low + high)/2;
            if (value == arr[mid]){
                return mid;
            }
            if (value > arr[mid]){
                low = mid + 1;
            }
            if (value < arr[mid]){
                high = mid - 1;
            }
        }
        return -1;
    }
}
