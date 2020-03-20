package com.company.datastructure.search;

public class TestSearch3 {
    public static void main(String[] args) {
        //��������
        int[] array = {1,2,3,4,5,6,7,8,9,10};
        //����Ҫ���ҵ�ֵ
        int key = 6;
        //�����۰����
        int index = binarySearch(array,key);
        //������
        if (index == -1){
            System.out.println("������");
        }else {
            System.out.println(key + "�������ǣ�" + index);
        }
    }

    /**
     * ʹ�õݹ�
     * T(n) = O(logn)
     * S(n) = O(logn)
     * @param array ����
     * @param key ���ҵ�ֵ
     * @return ����
     */
    static int binarySearch(int[] array, int key){
        //ָ��low��high
        int low = 0;
        int high = array.length - 1;
        return binarySearch(array,key,low,high);
    }

    static int binarySearch(int[] array,int key,int low,int high){
        //�ݹ�Ľ�������
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
