package cn.sxt.io;

import java.io.File;

/**
 * 统计文件夹得大小
 * @author 黄建波
 */
public class DirDemo05 {
    private static long len = 0;

    public static void count(File src){
        //获取大小
        if (null != src && src.exists()){
            if (src.isFile()){
                //大小
                len += src.length();
            }else {
                //子孙级
                for (File s:src.listFiles()){
                    count(s);
                }
            }
        }
    }

    public static void main(String[] args) {
        File src = new File("D:/idea-workspace/src/cn/sxt/io");
        count(src);
        System.out.println(len);
    }
}
