package cn.sxt.io2;

import java.io.ByteArrayInputStream;
import java.io.IOException;
import java.io.InputStream;

/**
 * 四个步骤：字节数组输入流
 * 1.创建源：字节数组 不要太大
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author 黄建波
 */
public class IOTest07 {
    public static void main(String[] args) {
        //创建源
        byte[] src = "talk is cheap show me the code".getBytes();
        //选择流
        InputStream is = null;
        try {
            //操作
            is = new ByteArrayInputStream(src);
            //缓冲容器
            byte[] flush = new byte[5];
            //接受长度
            int len = -1;
            while ((len = is.read(flush)) != -1) {
                //字节数组-->字符串（解码）
                String str = new String(flush, 0, len);
                System.out.println(str);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            try {
                if (null != is){
                    is.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
