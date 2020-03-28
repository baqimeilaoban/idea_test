package cn.sxt.io2;

import java.io.*;

/**
 * 文件流输入
 * @author thinkpad
 */
public class FileTest {
    public static void main(String[] args) {
        //创建源
        File src = new File("src/cn/sxt/io2/abc.txt");
        //选择流
        Reader reader = null;
        try {
            reader = new FileReader(src);
            //操作（读取）
            char[] flush = new char[2];
            //接受长度
            int len = -1;
            while ((len = reader.read(flush)) != -1){
                //字节数组-->字符串
                String str = new String(flush,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            if (null != reader){
                try {
                    reader.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }
            }
        }
    }
}
