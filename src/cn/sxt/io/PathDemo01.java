package cn.sxt.io;

import java.io.File;

/**
 * \ / ���Ʒָ��� separator
 * @author �ƽ���
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.png";
        System.out.println(File.separatorChar);
        //����1��/
        path = "D:/idea-workspace/src/cn/sxt/io/IO.png";
        System.out.println(path);
        //����2������ƴ��
        path = "D:" + File.separator + "idea-workspace" + File.separator + "src" + File.separator + "cn" + File.separator + "sxt" + File.separator + "io" + File.separator + "IO.png";
        System.out.println(path);

    }
}
