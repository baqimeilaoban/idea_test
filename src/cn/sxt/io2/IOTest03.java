package cn.sxt.io2;

import java.io.*;

/**
 * 四个步骤；分段读取 文件字节输入流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 */
public class IOTest03 {
    public static void main(String[] args) {
        //创建源
        File src = new File("src/cn/sxt/io2/abc.txt");
        //选择流
        InputStream is = null;
        try {
            is = new FileInputStream(src);
            //操作（读取）
            byte[] car = new byte[3];
            //接受长度
            int len = -1;
            while ((len = is.read(car)) != -1){
                //字节数组-->字符串
                String str = new String(car,0,len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
