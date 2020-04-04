package cn.sxt.chat.chat01;

import java.io.DataInputStream;
import java.io.DataOutputStream;
import java.io.IOException;
import java.net.ServerSocket;
import java.net.Socket;

/**
 * 在线聊天室：服务器
 * 目标；实现一个客户可以正常收多条发消息
 * @author 黄建波
 */
public class MutiChat {
    public static void main(String[] args) throws IOException {
        System.out.println("---Server---");
        //指定端口
        ServerSocket server = new ServerSocket(8888);
        //阻塞式等待连接
        Socket client = server.accept();
        System.out.println("一个客户端建立了连接");
        //接收消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        boolean isRunning = true;
        while (isRunning) {
            String msg = dis.readUTF();
            //返回消息
            dos.writeUTF(msg);
            dos.flush();
        }
        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
