package cn.sxt.tcp;

import java.io.*;
import java.net.Socket;

/**
 * 上传文件
 * 创建客户端
 * 1.建立连接；使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作：输入输出流操作
 * 2.释放资源
 *
 * @author 黄建波
 */
public class FileClient {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //建立连接
        Socket client = new Socket("localhost",8888);
        //操作
        InputStream is = new BufferedInputStream(new FileInputStream("src/cn/sxt/io/IO.png"));
        OutputStream os = new BufferedOutputStream(client.getOutputStream());
        byte[] flush = new byte[1024];
        int len = -1;
        while ((len=is.read(flush))!=-1){
            os.write(flush,0,len);
        }
        os.flush();
        //释放资源
        os.close();
        is.close();
        client.close();
    }
}
