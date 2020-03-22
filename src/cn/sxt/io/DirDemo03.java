package cn.sxt.io;

/**
 * 递归：方法自己调用自己
 * 递归头：合适结束自己
 * 递归体：重复调用
 * @author 黄建波
 */
public class DirDemo03 {
    public static void main(String[] args) {
        printTen(1);
    }

    public static void printTen(int n){
        //递归头
        if (n > 10){
            return;
        }
        System.out.println(n);
        //递归体：方法自己调自己
        printTen(n+1);
    }


}
