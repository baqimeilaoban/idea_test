package cn.sxt.io2;

import java.io.*;

/**
 * 标准写法
 * @author 黄建波
 */
public class IOTest02 {
    public static void main(String[] args) {
        //创建源
        File src = new File("src/cn/sxt/io2/abc.txt");
        InputStream is = null;
        //选择流
        try {
            is = new FileInputStream(src);
            //读取
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print(((char) temp));
            }
        } catch (IOException e) {
            e.printStackTrace();
        }finally {
            //释放资源
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
