package cn.sxt.io;

import java.io.File;

/**
 * \ / 名称分隔符 separator
 * @author 黄建波
 */
public class PathDemo01 {
    public static void main(String[] args) {
        String path = "D:\\idea-workspace\\src\\cn\\sxt\\io\\IO.png";
        System.out.println(File.separatorChar);
        //建议1：/
        path = "D:/idea-workspace/src/cn/sxt/io/IO.png";
        System.out.println(path);
        //建议2：常量拼接
        path = "D:" + File.separator + "idea-workspace" + File.separator + "src" + File.separator + "cn" + File.separator + "sxt" + File.separator + "io" + File.separator + "IO.png";
        System.out.println(path);

    }
}
