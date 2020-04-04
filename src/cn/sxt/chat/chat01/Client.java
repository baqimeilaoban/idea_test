package cn.sxt.chat.chat01;

import java.io.*;
import java.net.Socket;

/**
 * 在线聊天室：客户端
 * 目标；实现一个客户可以正常收发消息
 * @author 黄建波
 */
public class Client {
    public static void main(String[] args) throws IOException {
        System.out.println("---Client---");
        //建立连接
        Socket client = new Socket("localhost",8888);
        //客户端发送消息
        BufferedReader console = new BufferedReader(new InputStreamReader(System.in));
        String msg = console.readLine();
        DataOutputStream dos = new DataOutputStream(client.getOutputStream());
        dos.writeUTF(msg);
        dos.flush();
        //获取消息
        DataInputStream dis = new DataInputStream(client.getInputStream());
        msg = dis.readUTF();
        System.out.println(msg);
        //释放资源
        dos.close();
        dis.close();
        client.close();
    }
}
