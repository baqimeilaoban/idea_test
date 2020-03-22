package cn.sxt.io;

import java.io.File;

/**
 * 文件状态
 * 1.不存在：exists
 * 2.存在：
 *      文件：isFile
 *      文件夹：isDirctory
 * @author thinkpad
 */
public class FileDemo04 {
    public static void main(String[] args) {
        File src = new File("src/cn/sxt/io/IO.png");
        System.out.println("是否存在：" + src.exists());
        System.out.println("是否是文件：" + src.isFile());
        System.out.println("是否是文件夹；" + src.isDirectory());
        System.out.println("------------------");
        src = new File("xxx");
        if (!src.exists()){
            System.out.println("文件不存在");
        }else {
            if (src.isFile()){
                System.out.println("文件操作");
            }else {
                System.out.println("文件夹操作");
            }
        }
    }

}
