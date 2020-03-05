package com.company.MyPro08;

import java.io.File;

/**
 * 使用递归算法打印目录树
 * @author 黄建波
 */
public class PrintFileTree {
    public static void main(String[] args) {
        File f = new File("D:\\java\\java\\1-java基础语法");
        printFile(f,0);
    }

    static void printFile(File file,int level){
        //输出层数
        for (int i = 0; i < level; i++){
            System.out.print("-");
        }
        System.out.println(file.getName());
        if (file.isDirectory()){
            File[] files = file.listFiles();

            for (File temp:files){
                printFile(temp,level + 1);
            }
        }
    }
}
