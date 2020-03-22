package cn.sxt.io;

import java.io.File;

/**
 * 构建File对象
 * 相对路径和绝对路径
 * 1)、存在盘符：绝对路径
 * 2)、不存在盘符：相对路径
 * @author 黄建波
 */
public class FileDemo02 {
    public static void main(String[] args) {
        String path = "D:/idea-workspace/src/cn/sxt/io/IO.png";

        //绝对路径
        File src = new File(path);
        System.out.println(src.getAbsolutePath());
        //输出用户的目录
        System.out.println(System.getProperty("user.dir"));
        //相对路径
        src = new File("src/cn/sxt/io/IO.png");
        System.out.println(src.getAbsolutePath());
        //构建一个不存在的文件
        src = new File("aaa/IO2.png");
        System.out.println(src.getAbsolutePath());
    }
}
