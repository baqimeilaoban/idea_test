package com.company.datastructure.sort;

import java.util.Arrays;

/**
 * ��������ð������ĸĽ��棬����õ�һ���������漰�����κ͵ݹ�
 * @author �ƽ���
 */
public class TestQuickSort {
    public static void main(String[] args) {
        //������������
        int arr[] = {72,6,57,88,60,42,83,73,48,85};
        //�����������
        System.out.println(Arrays.toString(arr));
        //��������
        quickSort(arr);
        //�����������
        System.out.println(Arrays.toString(arr));
    }

    public static void quickSort(int[] arr){
        int low = 0;
        int high = arr.length - 1;
        quickSort(arr,low,high);
    }

    private static void quickSort(int[] arr, int low, int high) {
        if (low < high){
            //������������һ������ֳ��������������ط������޵�����
            int index = partition(arr,low,high);
            //����������п���
            quickSort(arr,low,index-1);
            //���ҷ������п���
            quickSort(arr,index+1,high);
        }
    }

    private static int partition(int[] arr, int low, int high) {
        //ָ����ָ��i����ָ��j
        int i = low;
        int j = high;
        //����һ������Ϊ��׼ֵ
        int x = arr[low];
        //ʹ��ѭ��ʵ�ַ�������
        while (i < j){
            //1.���������ƶ�j���ҵ���һ��С�ڻ�׼ֵ��ֵ
            while (arr[j] >= x && i < j){
                j--;
            }
            //2.���Ҳ��ҵ���С�ڻ�׼����ֵ���뵽��ߵĿ��У���ָ�����м��ƶ�һ��λ��
            if (i < j){
                arr[i] = arr[j];
                i++;
            }
            //3.���������ƶ�i���ҵ���һ�����ڵ��ڻ�׼ֵ��ֵarr[i]
            while (arr[i] < x && i < j){
                i++;
            }
            //4.������ҵ��Ĵ��ڵ��ڻ�׼ֵ��ֵ���뵽�ұߵĿ��У���ָ�����м��ƶ�һ��λ��
            if (i < j){
                arr[j] = arr[i];
                j--;
            }
        }
        //ʹ�û�׼ֵ��ӣ�����ǻ�׼ֵ������λ��
        arr[i] = x;
        //���ػ�׼ֵ��λ������
        return i;
    }
}
