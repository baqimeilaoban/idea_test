package cn.sxt.io;

import java.io.File;

/**
 * ͳ���ļ��еô�С
 * @author �ƽ���
 */
public class DirDemo05 {
    private static long len = 0;

    public static void count(File src){
        //��ȡ��С
        if (null != src && src.exists()){
            if (src.isFile()){
                //��С
                len += src.length();
            }else {
                //���Ｖ
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
