package com.company.MyPro08;

import java.io.File;
import java.io.IOException;
import java.util.Date;

/**
 * 测试File类的基本用法
 * @author thinkpad
 */
public class TestFile {
    public static void main(String[] args) throws IOException {
        File f = new File("D:\\idea-workspace\\src\\com\\company\\MyPro08\\a.txt");

        System.out.println(f);
        f.renameTo(new File("D:\\idea-workspace\\src\\com\\company\\MyPro08\\b.txt"));
        //得到项目路径
        System.out.println(System.getProperty("user.dir"));

        //在项目下创建新文件
        File f2 = new File("gg.txt");
        f2.createNewFile();

        System.out.println("File是否存在：" + f2.exists());
        System.out.println("File是否是目录：" + f2.isDirectory());
        System.out.println("File是否是文件：" + f2.isFile());
        System.out.println("File最后修改时间：" + new Date(f2.lastModified()));
        System.out.println("File文件的大小：" + f2.length());
        System.out.println("File文件名：" + f2.getName());
        System.out.println("File目录路径：" + f2.getAbsolutePath());

        File f3 = new File("D:/电影/华语/大陆");
        //目录结构中有一个不存在，则不会创建整个目录
        //boolean flag = f3.mkdir();
        //利用mkdirs创建目录，中有一个不存在，也能创建成功
        boolean flag = f3.mkdirs();
        //创建失败
        System.out.println(flag);
    }
}
