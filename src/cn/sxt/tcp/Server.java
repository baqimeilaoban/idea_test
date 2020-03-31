package cn.sxt.tcp;

import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 熟悉流程
 * 创建服务器
 * 1.指定端口 使用ServerSocket创建服务器
 * 2.阻塞式等待连接accept
 * 3.操作；输入输出流
 * 4.释放资源
 */
public class Server {
    public static void main(String[] args) throws IOException {
        System.out.println("---server---");
        //指定端口 使用ServerSocket创建服务器
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接accept
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //操作；输入输出操作
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        String data = "hello";
        dos.writeUTF(data);
        dos.flush();
        //释放资源
        dos.close();
        client.close();

        server.close();
    }
}
