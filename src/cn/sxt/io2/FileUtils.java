package cn.sxt.io2;

import java.io.*;

/**
 * 1.封装拷贝
 * 2.封装释放资源
 * @author thinkpad
 */
public class FileUtils {
    public static void main(String[] args) {
        //文件到文件
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io2/abc.txt");
            OutputStream os = new FileOutputStream("abc-copy.txt");
            copy(is,os);
        } catch (FileNotFoundException e) {
            e.printStackTrace();
        }

        //文件到字节数组
        byte[] datas = null;
        try {
            InputStream is = new FileInputStream("src/cn/sxt/io/IO.png");
            ByteArrayOutputStream os  = new ByteArrayOutputStream();
            copy(is,os);
            datas = os.toByteArray();
            System.out.println(datas.length);
        }catch (IOException e){
            e.printStackTrace();
        }

        //字节数组到文件
        try {
            InputStream is = new ByteArrayInputStream(datas);
            OutputStream os = new FileOutputStream("p-copy.png");
            copy(is,os);
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 对接输入输出流
     * @param is 输入流
     * @param os 输出流
     */
    public static void copy(InputStream is, OutputStream os){
       try {
           byte[] flush = new byte[1024];
           int len = -1;
           while ((len = is.read(flush)) != -1){
               os.write(flush,0,len);
           }
           os.flush();
       }catch (IOException e){
           e.printStackTrace();
       }finally {
           //释放资源 分别关闭 先打开的后关闭
           close(is,os);
       }
    }

    /**
     * 删除资源 可用下面的一个close方法
     * @param is 输入流
     * @param os 输出流
     */
    public static void close(InputStream is,OutputStream os){
        try {
            if (null != os){
                os.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }

        try {
            if (null != is){
                is.close();
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 释放资源
     * @param ios 传过来的
     */
    public static void close(Closeable... ios){
        for (Closeable io:ios){
            try {
                if (null != io){
                    io.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
