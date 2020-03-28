package cn.sxt.io2;

import java.io.*;

/**
 * 第一个程序:理解操作步骤
 * 1.创建源
 * 2.选择流
 * 3.操作
 * 4.释放资源
 * @author 黄建波
 */
public class IOTest01 {
    public static void main(String[] args) {
        //1.创建源
        File src = new File("D:/idea-workspace/src/cn/sxt/io2/abc.txt");
        //2.选择流
        try {
            InputStream is = new FileInputStream(src);
            //3.操作（读取）
            //第一个数据
            int data1 = is.read();
            //第二个数据
            int data2 = is.read();
            //第三个数据
            int data3 = is.read();
            //第四个数据,不是数据，文件的末尾返回-1
            int data4 = is.read();
            System.out.println((char)data1);
            System.out.println((char)data2);
            System.out.println((char)data3);
            System.out.println((char)data4);
            //4.释放资源
            is.close();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }
}
