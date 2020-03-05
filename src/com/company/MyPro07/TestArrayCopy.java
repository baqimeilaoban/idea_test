package com.company.MyPro07;

/**
 * 测试数组的拷贝
 * @author 黄建波
 */
public class TestArrayCopy {
    public static void main(String[] args) {
        testBasicCopy();
        testBasicCopy2();

        String[] str = {"阿里","京东","尚学堂","百度","亚马逊"};
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
     * 测试从数组中删除某个元素（本质上还是数组的copy），并将数组返回
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
     * 删除数组中指定索引位置的元素，并将原数组返回
     * 进行封装
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
     * 数组的扩容（本质上先定义一个更大的数组，然后将原数组内容原封不动拷贝到新数组中）
     */
    public static void extendRange(){
        String[] s1 = {"aa","bb","cc"};

        String[] s2 = new String[s1.length + 10];
        //将s1中所有元素拷贝到s2中
        System.arraycopy(s1,0,s2,0,s1.length);
        for (String temp : s2){
            System.out.print(temp + " ");
        }
        System.out.println();
    }

    /**
     * 封装扩容
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


