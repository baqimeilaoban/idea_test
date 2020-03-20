package com.company.datastructure.search;

/**
 * ǰ�᣺˳��ṹ�����չؼ�������
 * @author �ƽ���
 */
public class TestSearch2 {
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
     * ��ʹ�õݹ�
     * T(n) = O(logn)
     * S(n) = O(1)
     * @param array ����
     * @param key Ҫ���ҵ�ֵ
     * @return ����
     */
    public static int binarySearch(int[] array,int key){
         //ָ��low��high
        int low = 0;
        int hight = array.length-1;
        //�۰����
        while (low <= hight){
            //���mid
            int mid = (low + hight) / 2;
            //�ж��Ƿ����
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
