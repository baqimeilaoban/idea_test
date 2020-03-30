package cn.sxt.io3;

import java.io.*;
import java.net.URL;
import java.nio.charset.StandardCharsets;

/**
 * 转换流；InputStreamReader OutputStreamWriter
 * 1.以字符流的形式操作字节流
 * 2.指定字符集
 * @author 黄建波
 */
public class ConvertTest02 {
    public static void main(String[] args) {
        try (BufferedReader reader = new BufferedReader(new InputStreamReader(new URL("http://www.baidu.com").openStream(),StandardCharsets.UTF_8));
             BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(new FileOutputStream("baidu.html"),StandardCharsets.UTF_8))){
            String msg;
            while ((msg=reader.readLine())!=null){
                writer.write(msg);
                writer.newLine();
            }
            writer.flush();
        }catch (IOException e) {
            System.out.println("操作异常");
        }
    }

    /**
     * 与上述方法进行对比
     */
    public static void test1(){
        //操作网络流 下载百度的源代码
        try(InputStream is = new URL("http://www.baidu.com").openStream();) {
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print((char)temp);
            }

        }catch (IOException e){
            e.printStackTrace();
        }
    }

    /**
     * 与上述方法进行对比
     */
    public static void test2(){
        //操作网络流 下载百度的源代码
        try(InputStreamReader is = new InputStreamReader(new URL("http://www.baidu.com").openStream(), StandardCharsets.UTF_8)) {
            //操作
            int temp;
            while ((temp=is.read())!=-1){
                System.out.print((char)temp);
            }
        }catch (IOException e){
            e.printStackTrace();
        }
    }
}
