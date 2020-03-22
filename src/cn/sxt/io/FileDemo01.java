package cn.sxt.io;

import java.io.File;

/**
 * @author 黄建波
 */
public class FileDemo01 {
    /**
     * 构建File对象
     * @param args
     */
    public static void main(String[] args) {
        String path = "D:/idea-workspace/src/cn/sxt/io/IO.png";
        //1.构建File对象
        File src = new File(path);
        System.out.println(src.length());

        //2.构建File对象
        src = new File("D:/idea-workspace/src/cn/sxt/io","IO.png");
        System.out.println(src.length());

        //3:构建File对象
        src = new File(new File("D:/idea-workspace/src/cn/sxt/io"),"IO.png");
        System.out.println(src.length());
    }
}
