package cn.sxt.io;

import java.io.File;

/**
 * 列出下一级
 * 1.list():找出下级名称
 * 2.listFiles():列出下级File对象
 * 3.列出所有盘符
 * @author 黄建波
 */
public class DirDemo02 {
    public static void main(String[] args) {
        File dir = new File("D:\\Iotest");
        //列出下级名称 list()
        String[] subsName = dir.list();
        for (String s:subsName){
            System.out.println(s);
        }

        //下级对象listFile()
        File[] subFiles = dir.listFiles();
        for (File s : subFiles){
            System.out.println(s.getAbsolutePath());
        }

        //所有盘符
        File[] roots = File.listRoots();
        for (File r:roots){
            System.out.println(r.getAbsolutePath());
        }
    }
}
