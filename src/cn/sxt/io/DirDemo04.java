package cn.sxt.io;

import java.io.File;

/**
 * 递归：方法自己调用自己
 * 打印子孙级目录和文件的名称
 * @author 黄建波
 */
public class DirDemo04 {
    public static void main(String[] args) {
        File src = new File("D:/idea-workspace");
        printName(src,0);
    }

    /**
     * 打印子孙级目录和文件的名称
     * @param
     */
    public static void printName(File src,int deep){
        for (int i = 0; i < deep; i++){
            //控制前面层次
            System.out.printf("-");
        }
        System.out.println(src.getName());
        if (null == src || !src.exists()){
            return;
        }else if(src.isDirectory()){
            //目录
            for (File s:src.listFiles()){
                printName(s,deep+1);
            }
        }
    }
}
