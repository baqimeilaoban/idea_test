package cn.sxt.io3;

import java.io.*;

/**
 * 四个步骤：分段读取 文件字节输入流 加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author thinkpad
 */
public class BufferedTest01 {
    public static void main(String[] args) {
        //创建源
        File src = new File("src/cn/sxt/io2/abc.txt");
        //选择流
        InputStream is = null;
        BufferedInputStream bis = null;
        try {
            is = new FileInputStream(src);
            bis = new BufferedInputStream(is);
            //操作
            byte[] flush = new byte[1024];
            int len = -1;
            while ((len = is.read(flush)) != -1){
                //字节数组--->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
           try {
               if (null != is){
                   is.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }

           try {
               if (null != bis){
                   bis.close();
               }
           }catch (IOException e){
               e.printStackTrace();
           }
        }
    }
}
