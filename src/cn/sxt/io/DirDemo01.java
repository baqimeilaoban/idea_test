package cn.sxt.io;

import java.io.File;

/**
 * 创建目录
 * 1.mkdir:确保上级目录存在，不存在创建失败
 * 2.mkdirs：上级目录可以不存在，不存在则一同来创建
 * @author 黄建波
 */
public class DirDemo01 {
    public static void main(String[] args) {
        File dir = new File("D:/Iotest/dir/test");
        //创建目录，推荐使用mkdirs
        boolean flag = dir.mkdirs();
        System.out.println(flag);


    }
}
