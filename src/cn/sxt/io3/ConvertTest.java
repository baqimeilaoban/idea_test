package cn.sxt.io3;

import java.io.*;

/**
 * 转换流：InputStreamReader OutputStreamWriter
 * 1.字符流的形式操作字节流（处理纯文本）
 * 2.指定字符集
 * @author 黄建波
 */
public class ConvertTest {
    public static void main(String[] args) {
        //操作System.in和System.out
        try(BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
            BufferedWriter writer = new BufferedWriter(new OutputStreamWriter(System.out))) {
            //循环获取键盘的输入(exit退出)，输出此内容
            String msg = "";
            while (!msg.equals("exit")){
                //循环读取
                msg = reader.readLine();
                //循环写出
                writer.write(msg);
                writer.newLine();
                //强制刷新
                writer.flush();
            }
        }catch (IOException e){
            System.out.println("操作异常");
        }


    }
}
