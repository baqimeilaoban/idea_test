package cn.sxt.io;

import java.io.File;

/**
 * 其他信息：
 * length():文件的字节数
 * @author 黄建波
 */
public class FileDemo05 {
    public static void main(String[] args) {
        File src = new File("D:/idea-workspace/src/cn/sxt/io/IO.png");
        System.out.println("文件长度：" + src.length());
        System.out.println("--------------------");
        src = new File("D:/idea-workspace/src/cn/sxt/io");
        System.out.println("长度为：" + src.length());
        System.out.println("-----------------------");
        src = new File("D:/idea-workspace/src/cn/sxt/io2");
        System.out.println("长度为；" + src.length());
    }
}
