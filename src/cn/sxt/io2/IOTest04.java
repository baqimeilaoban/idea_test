package cn.sxt.io2;

import java.io.*;

/**
 * 文件字节输出流
 * 1.创建源
 * 2.选择流
 * 3.操作（写出内容）
 * 4.释放资源
 */
public class IOTest04 {
    public static void main(String[] args) {
        //创建源
        File src = new File("dest.txt");
        //选择流
        OutputStream dest = null;
        try {
            dest = new FileOutputStream(src,false);
            //操作：写出
            String msg = "IO is so easy";
            //字符串-->字节数组（编码）
            byte[] datas = msg.getBytes();
            dest.write(datas,0,datas.length);
            dest.flush();
        } catch (IOException e){
            e.printStackTrace();
        } finally {
            if (null != dest){
                try {
                    //释放资源
                    dest.close();
                } catch (IOException e) {
                    e.printStackTrace();
                }

            }
        }
    }
}
