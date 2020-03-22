package cn.sxt.io;

import java.io.File;

/**
 * @author �ƽ���
 */
public class FileDemo01 {
    /**
     * ����File����
     * @param args
     */
    public static void main(String[] args) {
        String path = "D:/idea-workspace/src/cn/sxt/io/IO.png";
        //1.����File����
        File src = new File(path);
        System.out.println(src.length());

        //2.����File����
        src = new File("D:/idea-workspace/src/cn/sxt/io","IO.png");
        System.out.println(src.length());

        //3:����File����
        src = new File(new File("D:/idea-workspace/src/cn/sxt/io"),"IO.png");
        System.out.println(src.length());
    }
}
