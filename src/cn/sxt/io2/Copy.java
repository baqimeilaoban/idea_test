package cn.sxt.io2;

import java.io.*;

/**
 * 文件拷贝：文件字节输入、输出流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author 黄建波
 */
public class Copy {
    public static void main(String[] args) {
        copy("src/cn/sxt/io2/Copy.java","copy.txt");
    }

    public static void copy(String srcPath, String destPath) {
        //源头
        File src = new File(srcPath);
        //目的地
        File dest = new File(destPath);
        //try...with...resource
        try (InputStream is = new FileInputStream(src);
             OutputStream os = new FileOutputStream(dest)) {
            //操作；分段读取
            //缓冲容器
            byte[] flush = new byte[1024];
            //接收长度
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                //分段写出
                os.write(flush, 0, len);
            }
            os.flush();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
