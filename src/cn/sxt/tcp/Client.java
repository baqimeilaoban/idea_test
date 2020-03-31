package cn.sxt.tcp;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建客户端
 * 1.建立连接；使用Socket创建客户端 + 服务器的地址和端口
 * 2.操作：输入输出流操作
 * 2.释放资源
 *
 * @author 黄建波
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("---client---");
        //建立连接
        Socket client = new Socket("localhost",8888);
        //操作
        DataInputStream dis = new DataInputStream(client.getInputStream());
        String data = dis.readUTF();
        System.out.println(data);
        //释放资源
        dis.close();
        client.close();

    }
}
