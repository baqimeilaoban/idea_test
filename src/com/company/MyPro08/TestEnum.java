package com.company.MyPro08;

/**
 * ����ö��
 * @author �ƽ���
 */
public class TestEnum {
    public static void main(String[] args) {
        System.out.println(Season.SPRING);

        //ö�ٱ���
        for (Week k : Week.values()){
            System.out.println(k);
        }
        Season a = Season.AUTUMN;

        switch (a){
            case SPRING:
                System.out.println("��������");
                break;
            case SUMMER:
                System.out.println("��������");
                break;
            case AUTUMN:
                System.out.println("��������");
                break;
            case WINTER:
                System.out.println("��������");
                break;
        }
    }
}

enum Season{
    SPRING, SUMMER, AUTUMN, WINTER
}

enum Week{
    ����һ,���ڶ�,������,������,������,������,������
}
