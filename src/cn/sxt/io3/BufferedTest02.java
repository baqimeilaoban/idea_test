package cn.sxt.io3;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileReader;
import java.io.IOException;

/**
 * 四个步骤：分段读取 文件字符输入流 加入缓冲流
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4。释放资源
 * @author 黄建波
 */
public class BufferedTest02 {
    public static void main(String[] args) {
        //创建源
        File src = new File("src/cn/sxt/io2/abc.txt");
        //选择流
        BufferedReader reader = null;
        try {
            reader = new BufferedReader(new FileReader(src));
            //操作
            String line = null;
            //逐行读取
            while ((line=reader.readLine())!=null){
                //字符数组--->字符串
                System.out.println(line);
            }
        }catch (IOException e){
            e.printStackTrace();
        }finally {
            try {
                if (null != reader){
                    reader.close();
                }
            }catch (IOException E){
                E.printStackTrace();
            }
        }
    }

}
