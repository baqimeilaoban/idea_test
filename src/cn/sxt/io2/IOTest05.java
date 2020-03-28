package cn.sxt.io2;

import java.io.File;
import java.io.FileWriter;
import java.io.IOException;
import java.io.Writer;

/**
 * 文件字符输出流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author 黄建波
 */
public class IOTest05 {
    public static void main(String[] args) {
        //选择源
        File dest = new File("dest.txt");
        //选择流
        Writer writer = null;
        try {
            writer = new FileWriter(dest);
            //操作
            String msg = "IO is so easy\r\n尚学堂欢迎你";
            //字符串-->字符数组
            char[] datas = msg.toCharArray();
            writer.write(datas,0,datas.length);
            writer.flush();
        } catch (IOException e) {
                e.printStackTrace();
        }finally {
             //释放资源
            try {
                if (null != writer){
                    writer.close();
                }
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }
}
