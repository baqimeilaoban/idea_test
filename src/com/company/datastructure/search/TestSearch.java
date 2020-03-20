package com.company.datastructure.search;

/**
 * ���ܣ��ڷ����в���ָ������������
 * T(n) = O(n)
 * S(n) = O(1)
 * @author �ƽ���
 */
public class TestSearch {
    public static void main(String[] args) {
        //���ķ�������
        int[] scoreArr = {89,45,78,45,100,98,86,100,65};
        //����Ҫ���ҵ÷���
        int score = 100;
        //��ɲ���
        int index = search(scoreArr,score);
        //������
        if (index == -1){
            System.out.println("�÷���������");
        }else {
            System.out.println(score + "�������ǣ�" + index);
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
