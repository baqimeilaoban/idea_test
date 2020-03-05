package com.company.MyPro07;

/**
 * ��������Ŀ���
 * @author �ƽ���
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        testBasicCopy();
        testBasicCopy2();

        String[] str = {"����","����","��ѧ��","�ٶ�","����ѷ"};
        removeElment(str,1);
        extendRange();
        extendRage2(str);
    }

    public static void testBasicCopy(){
        String[] s1 = {"aa","bb","cc","dd","ee"};
        String[] s2 = new String[10];
        System.arraycopy(s1,2,s2,6,3);
        for (String temp: s2) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    /**
     * ���Դ�������ɾ��ĳ��Ԫ�أ������ϻ��������copy�����������鷵��
     */
    public static void testBasicCopy2(){
        String[] s1 = {"aa","bb","cc","dd","ee"};

        System.arraycopy(s1,3,s1,2,2);
        s1[s1.length - 1] = null;
        for (String temp: s1) {
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    /**
     * ɾ��������ָ������λ�õ�Ԫ�أ�����ԭ���鷵��
     * ���з�װ
     */
    public static String[] removeElment(String[] s, int index){
        System.arraycopy(s,index+1,s,index,s.length-index-1);
        s[s.length-1] = null;
        for(String temp : s){
            System.out.print(temp + " ");
        }
        System.out.println();
        return s;
    }

    /**
     * ��������ݣ��������ȶ���һ����������飬Ȼ��ԭ��������ԭ�ⲻ���������������У�
     */
    public static void extendRange(){
        String[] s1 = {"aa","bb","cc"};

        String[] s2 = new String[s1.length + 10];
        //��s1������Ԫ�ؿ�����s2��
        System.arraycopy(s1,0,s2,0,s1.length);
        for (String temp : s2){
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    /**
     * ��װ����
     */
    public static String[] extendRage2(String[] s1){
        String s2[] = new String[s1.length + 10];
        System.arraycopy(s1,0,s2,0,s1.length);
        for (String temp : s2){
            System.out.print(temp + " ");
        }
        System.out.println();
        return s2;
    }
}


