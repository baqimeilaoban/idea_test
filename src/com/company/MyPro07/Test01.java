package com.company.MyPro07;

/**
 * ���������ʹ��
 * @author �ƽ���
 */
public class Test01 {
    public static void main(String[] args) {
        //�������飬���������ռ�
        //�����±�[0,length - 1]:0,1,2,3,4,5,6,7,8,9
        int[] arr01 = new int[10];
        String[] arr02 = new String[5];

        //ͨ��ѭ����ʼ����ֵ
       for (int i = 0; i < 10; i++){
           arr01[i] = 10 * i;

       }
       //ͨ��ѭ����ȡ
       for (int i = 0; i < arr01.length; i++){
           System.out.println(arr01[i]);
       }

        User[] arr03 = new User[3];
       arr03[0] = new User(1001,"��");
       arr03[1] = new User(1002,"��");
       arr03[2] = new User(1003,"��");

       for (int i = 0; i < arr03.length; i++){
           System.out.println(arr03[i].getName());
       }

    }
}


