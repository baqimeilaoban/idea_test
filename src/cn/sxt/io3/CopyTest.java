package cn.sxt.io3;

import java.io.*;

/**
 * 文件拷贝：文件字节输入、输出流 （仅限于纯文本）
 * @author 黄建波
 */
public class CopyTest {
    public static void main(String[] args) {
        copy("abc-copy.txt","abc-copy1.txt");
    }

    public static void copy(String srcPath,String destPath){
        //创建源
        File src = new File(srcPath);
        File dest = new File(destPath);
        //选择流
        try(BufferedReader br = new BufferedReader(new FileReader(src));
            BufferedWriter bw = new BufferedWriter(new FileWriter(dest))) {
            //操作
            String line = null;
            while ((line=br.readLine()) != null){
                //逐行写出
                bw.write(line);
                bw.newLine();
            }
            bw.flush();
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
