package cn.sxt.io3;

import java.io.BufferedWriter;
import java.io.File;
import java.io.FileWriter;
import java.io.IOException;

/**
 * 文件字符输出流 加入缓冲流
 * 1.创建源
 * 2。选择流
 * 3.操作
 * 4.释放内容
 * @author 黄建波
 */
public class BufferedTest03 {
    public static void main(String[] args) {
        //创建源
        File dest = new File("src/cn/sxt/io2/ab.txt");
        //选择流
        BufferedWriter writer = null;
        try {
            writer = new BufferedWriter(new FileWriter(dest));
            writer.append("IO is so easy");
            writer.newLine();
            writer.append("尚学堂欢迎你！");
            writer.flush();
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != writer){
                    writer.close();
                }
            }catch (IOException e){
                e.printStackTrace();
            }
        }
    }
}
